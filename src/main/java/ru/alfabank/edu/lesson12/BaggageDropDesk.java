package ru.alfabank.edu.lesson12;

import ru.alfabank.edu.lesson12.checkedExceptions.BaggageTagPrintException;
import ru.alfabank.edu.lesson12.checkedExceptions.FlightNotFoundException;
import ru.alfabank.edu.lesson12.checkedExceptions.OverweightBaggageException;
import ru.alfabank.edu.lesson12.uncheckedExceptions.InvalidBaggageWeightException;
import ru.alfabank.edu.lesson12.uncheckedExceptions.InvalidPassengerNameException;

public class BaggageDropDesk {
    private static final int MAX_BAGGAGE_WEIGHT = 23;
    private final String[] availableFlights;

    public BaggageDropDesk(String[] availableFlights) {
        this.availableFlights = availableFlights;
    }

    public BaggageTicket dropBaggage (String namePassenger, String flightNumber, int baggageWeight) throws FlightNotFoundException, OverweightBaggageException, BaggageTagPrintException {
        // Проверить имя пассажира
        if (namePassenger == null || namePassenger.trim().isEmpty()) {
            throw new InvalidPassengerNameException("Ошибка! Имя пассажира null или пустое");
        }

        // Проверить вес багажа, когда он 0 или отрицательный
        if (baggageWeight <= 0) {
            throw new InvalidBaggageWeightException("Ошибка! Вес багажа меньше или равен нулю");
        }

        // Проверить наличие рейса
        if (flightNumber == null || flightNumber.trim().isEmpty()) {
            throw new FlightNotFoundException("Ошибка! Номер рейса не указан");
        }

        boolean flightExists = false;
        for (String flight : availableFlights) {
            if (flight != null && flight.equals(flightNumber)) {
                flightExists = true;
                break;
            }
        }
        if (!flightExists) {
            throw new FlightNotFoundException("Ошибка! Указанного номера рейса: / " + flightNumber + " / нет в базе данных аэропорта");
        }

        //  Проверить вес багажа, когда он больше максимального значения 23 кг
        if (baggageWeight > MAX_BAGGAGE_WEIGHT) {
            throw new OverweightBaggageException("Ошибка! Вес багажа не может быть больше 23 кг. Текущий вес багажа: " + baggageWeight);
        }

        // Имитировать проблему с печатью багажной бирки "AE-404"
        if ("AE-404".equals(flightNumber)) {
            throw new BaggageTagPrintException("Ошибка! Проблема с печатью багажной бирки: " + flightNumber);
        }

        // Если все хорошо - создаем бирку
        BaggageTicket ticket = new BaggageTicket(namePassenger, flightNumber, baggageWeight);

        // Оповещаем пассажира о налоге (имитация)
        System.out.println("Внимание! Не забудьте оплатить налог за слишком правильные введенные данные!");

        return ticket;
    }


}
