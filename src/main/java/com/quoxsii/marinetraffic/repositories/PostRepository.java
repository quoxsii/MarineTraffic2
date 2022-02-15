package com.quoxsii.marinetraffic.repositories;

import com.quoxsii.marinetraffic.entities.PostEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Репозиторий сущностей постов.
 */
public interface PostRepository extends CrudRepository<PostEntity, Long> {
    /**
     * Метод поиска в репозитории по ссылке поста.
     * @param url ссылка поста.
     * @return возвращает сущность пост.
     */
    PostEntity findByUrl(String url);
}
