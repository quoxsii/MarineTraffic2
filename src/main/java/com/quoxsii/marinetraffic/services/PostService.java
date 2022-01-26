package com.quoxsii.marinetraffic.services;

import com.quoxsii.marinetraffic.entities.PostEntity;
import com.quoxsii.marinetraffic.exceptions.PostAlreadyExistsException;
import com.quoxsii.marinetraffic.exceptions.PostNotFoundException;
import com.quoxsii.marinetraffic.mappers.PostMapper;
import com.quoxsii.marinetraffic.models.Post;
import com.quoxsii.marinetraffic.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAll() throws PostNotFoundException {
        List<PostEntity> entityList = (List<PostEntity>) postRepository.findAll();
        if (entityList.isEmpty()) {
            throw new PostNotFoundException("Посты не найдены");
        }
        return entityList.stream().map(PostMapper.INSTANCE::toModel).collect(toList());
    }

    public Post getById(Long id) throws PostNotFoundException {
        Optional<PostEntity> post = postRepository.findById(id);
        if(post.isEmpty()) {
            throw new PostNotFoundException("Пост не найден");
        }
        return PostMapper.INSTANCE.toModel(post.get());
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

    public Post delete(Long id) throws PostNotFoundException {
        if (postRepository.findById(id).isEmpty()) {
            throw new PostNotFoundException("Пост не зарегистрирован");
        }

        Post post = PostMapper.INSTANCE.toModel(postRepository.findById(id).get());
        postRepository.deleteById(id);
        return post;
    }
}
