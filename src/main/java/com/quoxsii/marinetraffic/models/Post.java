package com.quoxsii.marinetraffic.models;

import com.quoxsii.marinetraffic.entities.PostEntity;

/**
 * Класс пост - используется в качестве модели для сущности пост {@link PostEntity}.
 */
public class Post {
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
     * Функция получения значения поля {@link Post#url}.
     * @return возвращает ссылку поста.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Процедура определения ссылки поста {@link Post#url}.
     * @param url ссылка поста.
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
