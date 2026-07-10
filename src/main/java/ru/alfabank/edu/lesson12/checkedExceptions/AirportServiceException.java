package ru.alfabank.edu.lesson12.checkedExceptions;

// Базовое проверяемое исключение
public class AirportServiceException extends Exception {
    public AirportServiceException (String message) {
        super(message);
    }
}
