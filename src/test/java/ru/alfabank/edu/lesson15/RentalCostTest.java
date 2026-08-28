package ru.alfabank.edu.lesson15;

// RentalCostTest.java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RentalCostTest {

    private GameRental rental;

    @BeforeEach
    void setUp() {
        rental = new GameRental();
        rental.addGame(new BoardGame("Monopoly", 8, 5));
        rental.addGame(new BoardGame("Chess", 6, 3));
    }

    @Test
    void shouldCalculateCostCorrectly() {
        assertEquals(15, rental.calculateCost("Monopoly", 3));
        assertEquals(30, rental.calculateCost("Monopoly", 6));
        assertEquals(6, rental.calculateCost("Chess", 2));
    }

    @Test
    void shouldThrowExceptionWhenGameNotFound() {
        assertThrows(IllegalArgumentException.class,
                () -> rental.calculateCost("NonExistent", 3));
    }

    @Test
    void shouldThrowExceptionWhenDaysIsZeroOrNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> rental.calculateCost("Monopoly", 0));
        assertThrows(IllegalArgumentException.class,
                () -> rental.calculateCost("Monopoly", -5));
    }

    @ParameterizedTest
    @CsvSource({
            "Monopoly, 1, 5",
            "Monopoly, 2, 10",
            "Monopoly, 5, 25",
            "Chess, 1, 3",
            "Chess, 4, 12"
    })
    void shouldCalculateCostForDifferentGamesAndDays(String gameName, int days, int expectedCost) {
        assertEquals(expectedCost, rental.calculateCost(gameName, days));
    }

    @Test
    void shouldResetAllGamesToAvailable() {
        rental.rentGame("Monopoly", 10);
        rental.rentGame("Chess", 10);

        assertTrue(rental.findGame("Monopoly").isRented());
        assertTrue(rental.findGame("Chess").isRented());

        rental.reset();

        assertFalse(rental.findGame("Monopoly").isRented());
        assertFalse(rental.findGame("Chess").isRented());
    }
}
