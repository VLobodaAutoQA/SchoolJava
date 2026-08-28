package ru.alfabank.edu.lesson15;

// GameRental.java
import java.util.*;

public class GameRental {
    private final Map<String, BoardGame> catalog;

    public GameRental() {
        this.catalog = new HashMap<>();
    }

    public void addGame(BoardGame game) {
        if (game == null) {
            throw new IllegalArgumentException("Game cannot be null");
        }
        if (catalog.containsKey(game.getName().toLowerCase())) {
            throw new IllegalArgumentException("Game with this name already exists");
        }
        catalog.put(game.getName().toLowerCase(), game);
    }

    public BoardGame findGame(String name) {
        if (name == null) {
            return null;
        }
        return catalog.get(name.toLowerCase());
    }

    // Часть 2
    public boolean rentGame(String name, int customerAge) {
        BoardGame game = findGame(name);
        if (game == null) {
            throw new IllegalArgumentException("Game not found");
        }

        if (!game.canBeRentedBy(customerAge)) {
            return false;
        }

        if (game.isRented()) {
            return false;
        }

        game.setRented(true);
        return true;
    }

    public boolean returnGame(String name) {
        BoardGame game = findGame(name);
        if (game == null) {
            return false;
        }

        if (!game.isRented()) {
            return false;
        }

        game.setRented(false);
        return true;
    }

    //Часть 3
    public int calculateCost(String name, int days) {
        BoardGame game = findGame(name);
        if (game == null) {
            throw new IllegalArgumentException("Game not found");
        }
        if (days <= 0) {
            throw new IllegalArgumentException("Days must be positive");
        }

        return game.getRentalCostPerDay() * days;
    }

    public void reset() {
        for (BoardGame game : catalog.values()) {
            game.setRented(false);
        }
    }
}
