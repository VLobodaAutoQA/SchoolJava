package ru.alfabank.edu.lesson12;

import ru.alfabank.edu.lesson12.checkedExceptions.BaggageTagPrintException;
import ru.alfabank.edu.lesson12.checkedExceptions.FlightNotFoundException;
import ru.alfabank.edu.lesson12.checkedExceptions.OverweightBaggageException;
import ru.alfabank.edu.lesson12.uncheckedExceptions.InvalidBaggageWeightException;
import ru.alfabank.edu.lesson12.uncheckedExceptions.InvalidPassengerNameException;

public class Main {
    static void main() {
        String[] flights = { "SU-123", "TK-777", "KC-909", "AE-404" };

        BaggageDropDesk baggageDropDesk = new BaggageDropDesk(flights);

        System.out.println("=== 1. успешная сдача багажа ===");
        try {
            BaggageTicket ticket = baggageDropDesk.dropBaggage("Ivan Petrov", "SU-123", 18);
            System.out.println("Успех! Бирка создана: " + ticket);
        } catch (FlightNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (OverweightBaggageException e) {
            System.out.println(e.getMessage());
            System.out.println("Отправляем пассажира на доплату за перевес!");
        } catch (BaggageTagPrintException e) {
            System.out.println(e.getMessage());
            System.out.println("Проверяем состояние принтера и печатаем бирку заново!");
        } catch (InvalidPassengerNameException e) {
            System.out.println(e.getMessage());
        } catch (InvalidBaggageWeightException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("=== 2. указанного пассажиром рейса не существует в базе ===");
        try {
            BaggageTicket ticket = baggageDropDesk.dropBaggage("Anna Smirnova", "SU-777", 18);
            System.out.println("Успех! Бирка создана: " + ticket);
        } catch (FlightNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (OverweightBaggageException e) {
            System.out.println(e.getMessage());
            System.out.println("Отправляем пассажира на доплату за перевес!");
        } catch (BaggageTagPrintException e) {
            System.out.println(e.getMessage());
            System.out.println("Проверяем состояние принтера и печатаем бирку заново!");
        } catch (InvalidPassengerNameException e) {
            System.out.println(e.getMessage());
        } catch (InvalidBaggageWeightException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("=== 3. багаж слишком тяжелый ===");
        try {
            BaggageTicket ticket = baggageDropDesk.dropBaggage("Petr Ivanov", "TK-777", 30);
            System.out.println("Успех! Бирка создана: " + ticket);
        } catch (FlightNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (OverweightBaggageException e) {
            System.out.println(e.getMessage());
            System.out.println("Отправляем пассажира на доплату за перевес!");
        } catch (BaggageTagPrintException e) {
            System.out.println(e.getMessage());
            System.out.println("Проверяем состояние принтера и печатаем бирку заново!");
        } catch (InvalidPassengerNameException e) {
            System.out.println(e.getMessage());
        } catch (InvalidBaggageWeightException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("=== 4. проблема с печатью бирки ===");
        try {
            BaggageTicket ticket = baggageDropDesk.dropBaggage("Maria Sidorova", "AE-404", 5);
            System.out.println("Успех! Бирка создана: " + ticket);
        } catch (FlightNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (OverweightBaggageException e) {
            System.out.println(e.getMessage());
            System.out.println("Отправляем пассажира на доплату за перевес!");
        } catch (BaggageTagPrintException e) {
            System.out.println(e.getMessage());
            System.out.println("Проверяем состояние принтера и печатаем бирку заново!");
        } catch (InvalidPassengerNameException e) {
            System.out.println(e.getMessage());
        } catch (InvalidBaggageWeightException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("=== 5. некорректное имя пассажира (null) ===");
        try {
            BaggageTicket ticket = baggageDropDesk.dropBaggage(null, "KC-909", 5);
            System.out.println("Успех! Бирка создана: " + ticket);
        } catch (FlightNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (OverweightBaggageException e) {
            System.out.println(e.getMessage());
            System.out.println("Отправляем пассажира на доплату за перевес!");
        } catch (BaggageTagPrintException e) {
            System.out.println(e.getMessage());
            System.out.println("Проверяем состояние принтера и печатаем бирку заново!");
        } catch (InvalidPassengerNameException e) {
            System.out.println(e.getMessage());
        } catch (InvalidBaggageWeightException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("=== 6. некорректный вес багажа (отрицательный) ===");
        try {
            BaggageTicket ticket = baggageDropDesk.dropBaggage("Maria Sidorova", "KC-909", -15);
            System.out.println("Успех! Бирка создана: " + ticket);
        } catch (FlightNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (OverweightBaggageException e) {
            System.out.println(e.getMessage());
            System.out.println("Отправляем пассажира на доплату за перевес!");
        } catch (BaggageTagPrintException e) {
            System.out.println(e.getMessage());
            System.out.println("Проверяем состояние принтера и печатаем бирку заново!");
        } catch (InvalidPassengerNameException e) {
            System.out.println(e.getMessage());
        } catch (InvalidBaggageWeightException e) {
            System.out.println(e.getMessage());
        }
    }
}
