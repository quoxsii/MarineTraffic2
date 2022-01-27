package com.quoxsii.marinetraffic.exceptions;

/**
 * Исключение пост уже существует.
 */
public class PostAlreadyExistsException extends Exception{
    public PostAlreadyExistsException(String message) {
        super(message);
    }
}
