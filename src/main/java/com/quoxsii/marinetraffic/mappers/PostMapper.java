package com.quoxsii.marinetraffic.mappers;

import com.quoxsii.marinetraffic.entities.PostEntity;
import com.quoxsii.marinetraffic.models.Post;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Интерфейс конвертации для поста.
 */
@Mapper
public interface PostMapper {
    /**
     * Объект реализующий интерфейс конвертации для поста.
     */
    PostMapper INSTANCE = Mappers.getMapper( PostMapper.class );

    /**
     * Функция конвертации сущности в модель.
     * @param postEntity сущность пост.
     * @return возвращает модель пост.
     */
    Post toModel(PostEntity postEntity);
}
