package com.quoxsii.marinetraffic.exceptions;

/**
 * Исключение судно не найдено.
 */
public class VesselNotFoundException extends Exception{
    public VesselNotFoundException(String message) {
        super(message);
    }
}
