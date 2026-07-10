package ru.alfabank.edu.lesson12;

public class BaggageTicket {
    private String namePassenger;
    private String flightNumber;
    private int baggageWeight;

    public BaggageTicket(String namePassenger, String flightNumber, int baggageWeight) {
        this.namePassenger = namePassenger;
        this.flightNumber = flightNumber;
        this.baggageWeight = baggageWeight;
    }

    public String getNamePassenger() {
        return namePassenger;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public int getBaggageWeight() {
        return baggageWeight;
    }

    @Override
    public String toString() {
        return "BaggageTicket{" +
                "namePassenger='" + namePassenger + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", baggageWeight=" + baggageWeight +
                '}';
    }
}
