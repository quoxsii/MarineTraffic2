package com.quoxsii.marinetraffic.mappers;

import com.quoxsii.marinetraffic.entities.PostEntity;
import com.quoxsii.marinetraffic.models.Post;
import org.mapstruct.Mapper;

/**
 * Интерфейс конвертации для поста.
 */
@Mapper(componentModel = "spring")
public interface PostMapper {
    /**
     * Метод конвертации сущности в модель.
     * @param postEntity сущность пост.
     * @return возвращает модель пост.
     */
    Post toModel(PostEntity postEntity);
}
