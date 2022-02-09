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

/**
 * Сервис постов.
 */
@Service
public class PostService {
    /**
     * Поле репозиторий постов.
     */
    private final PostRepository postRepository;
    /**
     * Поле маппер постов.
     */
    private final PostMapper postMapper;

    /**
     * Конструктор - используется для инъекций зависимостей.
     * @param postRepository репозиторий постов.
     * @param postMapper маппер постов.
     */
    public PostService(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    /**
     * Функция получения списка всех моделей {@link Post}.
     * @return возвращает список моделей всех постов.
     * @throws PostNotFoundException возникает когда в репозитории не зарегистрировано ни одного поста.
     */
    public List<Post> getAll() throws PostNotFoundException {
        List<PostEntity> entityList = (List<PostEntity>) postRepository.findAll();
        if (entityList.isEmpty()) {
            throw new PostNotFoundException("Не найдено зарегистрированных постов");
        }
        return entityList.stream().map(postMapper::toModel).collect(toList());
    }

    /**
     * Функция получения модели поста по идентификатору.
     * @param id идентификатор поста.
     * @return возвращает модель поста.
     * @throws PostNotFoundException возникает когда в репозитории не зарегистрировано ни одного поста с указанным идентификатором.
     */
    public Post getById(Long id) throws PostNotFoundException {
        Optional<PostEntity> post = postRepository.findById(id);
        if(post.isEmpty()) {
            throw new PostNotFoundException("Пост не зарегистрирован");
        }
        return postMapper.toModel(post.get());
    }

    /**
     * Функция добавления поста в репозиторий.
     * @param name название поста.
     * @param url ссылка поста.
     * @return возвращает модель добалвенного поста.
     * @throws PostAlreadyExistsException возникает когда в репозитории уже зарегистрирован пост с идентичной ссылкой.
     */
    public Post add(String name, String url) throws PostAlreadyExistsException {
        if(postRepository.findByUrl(url) != null) {
            throw new PostAlreadyExistsException("Данный пост уже отслеживается");
        }
        PostEntity postEntity = new PostEntity();
        postEntity.setName(name);
        postEntity.setUrl(url);
        postRepository.save(postEntity);
        return postMapper.toModel(postEntity);
    }

    /**
     * Функция удаления поста из репозитория.
     * @param id идентификатор поста.
     * @return возвращает модель удаленного поста.
     * @throws PostNotFoundException возникает когда в репозитории не зарегистрирован пост с указанным идентификатором.
     */
    public Post delete(Long id) throws PostNotFoundException {
        if (postRepository.findById(id).isEmpty()) {
            throw new PostNotFoundException("Пост не зарегистрирован");
        }
        postRepository.deleteById(id);
        return postMapper.toModel(postRepository.findById(id).get());
    }
}
