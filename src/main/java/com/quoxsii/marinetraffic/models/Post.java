package com.quoxsii.marinetraffic.models;

import com.quoxsii.marinetraffic.entities.PostEntity;

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
     * Поле ссылка.
     */
    private String url;

    /**
     * Конструктор - создание нового объекта.
     */
    public Post() {
    }

    /**
     * Метод получения значения поля {@link Post#id}.
     * @return возвращает идентификатор сущности поста.
     */
    public Long getId() {
        return id;
    }

    /**
     * Метод определения идентификатора поста {@link Post#id}.
     * @param id идентификатор сущности поста.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Метод получения значения поля {@link Post#name}.
     * @return возвращает название поста.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод определения названия поста {@link Post#name}.
     * @param name название поста.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод получения значения поля {@link Post#url}.
     * @return возвращает ссылку поста.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Метод определения ссылки поста {@link Post#url}.
     * @param url ссылка поста.
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
