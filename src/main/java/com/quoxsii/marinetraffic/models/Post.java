package com.quoxsii.marinetraffic.models;

import com.quoxsii.marinetraffic.entities.PostEntity;

import java.util.List;

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
}
