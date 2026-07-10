package ru.alfabank.edu.lesson12.checkedExceptions;

// указанного рейса нет в списке доступных рейсов
public class FlightNotFoundException extends AirportServiceException {
    public FlightNotFoundException (String message) {
        super(message);
    }
}
