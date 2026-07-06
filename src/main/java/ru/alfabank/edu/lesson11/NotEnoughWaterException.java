package ru.alfabank.edu.lesson11;

public class NotEnoughWaterException extends RuntimeException {
    public NotEnoughWaterException(String errorMessage) {
        super(errorMessage);
    }
}
