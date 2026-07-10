package ru.alfabank.edu.lesson12.checkedExceptions;

// не получилось напечатать багажную бирку
public class BaggageTagPrintException extends AirportServiceException{
    public BaggageTagPrintException (String message) {
        super(message);
    }
}
