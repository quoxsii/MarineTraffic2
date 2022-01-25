package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.entities.PostEntity;
import com.quoxsii.marinetraffic.entities.VesselEntity;
import com.quoxsii.marinetraffic.entities.VesselRecordEntity;
import com.quoxsii.marinetraffic.exceptions.PostAlreadyExistsException;
import com.quoxsii.marinetraffic.exceptions.PostNotFoundException;
import com.quoxsii.marinetraffic.models.Post;
import com.quoxsii.marinetraffic.dtos.PostApiClientDto;
import com.quoxsii.marinetraffic.repositories.PostRepository;
import com.quoxsii.marinetraffic.repositories.VesselRecordRepository;
import com.quoxsii.marinetraffic.repositories.VesselRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAll() {
        List<PostEntity> entityList = (List<PostEntity>) postRepository.findAll();
        return entityList.stream().map(Post::toModel).collect(toList());
    }

    public Post getById(Long id) throws PostNotFoundException {
        Optional<PostEntity> post = postRepository.findById(id);
        if(post.isEmpty()) {
            throw new PostNotFoundException("Пост не найден");
        }
        return Post.toModel(post.get());
    }

    public PostEntity add(String name, String url) throws PostAlreadyExistsException {
        if(postRepository.findByUrl(url) != null) {
            throw new PostAlreadyExistsException("Данный пост уже отслеживается");
        }

        PostEntity postEntity = new PostEntity();
        postEntity.setName(name);
        postEntity.setUrl(url);

        return postRepository.save(postEntity);
    }
}
