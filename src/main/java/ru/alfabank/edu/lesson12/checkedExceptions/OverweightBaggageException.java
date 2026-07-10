package ru.alfabank.edu.lesson12.checkedExceptions;

// багаж слишком тяжелый
public class OverweightBaggageException  extends AirportServiceException {
    public OverweightBaggageException (String message) {
        super(message);
    }
}
