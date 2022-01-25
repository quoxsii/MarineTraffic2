package com.quoxsii.marinetraffic.models;

import com.quoxsii.marinetraffic.entities.PostEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс пост - используется в качестве модели для сущности пост {@link PostEntity}.
 */
public class Post {
    /**
     * Поле идентификатор.
     */
    private Long id;
    /**
     * Поле название.
     */
    private String name;
    /**
     * Поле список судов.
     */
    private List<Vessel> vessels;

    /**
     * Функция конвертации сущности пост в модель.
     * @param entity сущность пост.
     * @return возвращает модель пост.
     */
    public static Post toModel(PostEntity entity) {
        Post model = new Post();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setVessels(entity.getVesselEntities().stream().map(Vessel::toModel).collect(Collectors.toList()));
        return model;
    }

    /**
     * Конструктор - создание нового объекта.
     */
    public Post() {
    }

    /**
     * Функция получения значения поля {@link Post#id}.
     * @return возвращает идентификатор поста.
     */
    public Long getId() {
        return id;
    }

    /**
     * Процедура определения идентификатора поста {@link Post#id}.
     * @param id идентификатор поста.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Функция получения значения поля {@link Post#name}.
     * @return возвращает название поста.
     */
    public String getName() {
        return name;
    }

    /**
     * Процедура определения названия поста {@link Post#name}.
     * @param name название поста.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Функция получения значения поля {@link Post#vessels}.
     * @return возвращает список судов.
     */
    public List<Vessel> getVessels() {
        return vessels;
    }

    /**
     * Процедура определения списка судов {@link Post#vessels}.
     * @param vessels список судов.
     */
    public void setVessels(List<Vessel> vessels) {
        this.vessels = vessels;
    }
}
