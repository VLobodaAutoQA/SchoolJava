package ru.alfabank.edu.lesson15;

// BoardGame.java
public class BoardGame {
    private final String name;
    private final int minAge;
    private final int rentalCostPerDay;
    private boolean isRented;

    public BoardGame(String name, int minAge, int rentalCostPerDay) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (minAge < 0) {
            throw new IllegalArgumentException("Minimum age cannot be negative");
        }
        if (rentalCostPerDay <= 0) {
            throw new IllegalArgumentException("Rental cost must be positive");
        }

        this.name = name;
        this.minAge = minAge;
        this.rentalCostPerDay = rentalCostPerDay;
        this.isRented = false;
    }

    public String getName() {
        return name;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getRentalCostPerDay() {
        return rentalCostPerDay;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public boolean canBeRentedBy(int age) {
        return age >= minAge;
    }
}