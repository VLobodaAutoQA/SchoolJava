package ru.alfabank.edu.lesson12.uncheckedExceptions;

// (имя пассажира null или пустое)
public class InvalidPassengerNameException extends RuntimeException{
    public InvalidPassengerNameException (String message) {
        super(message);
    }
}
