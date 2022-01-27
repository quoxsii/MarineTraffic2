package com.quoxsii.marinetraffic.exceptions;

/**
 * Исключение пост не найден.
 */
public class PostNotFoundException extends Exception{
    public PostNotFoundException(String message) {
        super(message);
    }
}
