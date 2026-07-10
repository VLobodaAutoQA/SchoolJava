package ru.alfabank.edu.lesson12.uncheckedExceptions;

// (вес багажа меньше или равен нулю)
public class InvalidBaggageWeightException extends RuntimeException{
    public InvalidBaggageWeightException(String message) {
        super(message);
    }
}
