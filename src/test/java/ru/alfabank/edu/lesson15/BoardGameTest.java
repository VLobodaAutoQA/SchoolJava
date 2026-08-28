package ru.alfabank.edu.lesson15;

// BoardGameTest.java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BoardGameTest {

    private BoardGame game;

    @BeforeEach
    void setUp() {
        game = new BoardGame("Monopoly", 8, 5);
    }

    @Test
    void shouldCreateGameWithValidParameters() {
        assertEquals("Monopoly", game.getName());
        assertEquals(8, game.getMinAge());
        assertEquals(5, game.getRentalCostPerDay());
        assertFalse(game.isRented());
    }

    @Test
    void shouldThrowExceptionWhenNameIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new BoardGame(null, 8, 5));
    }

    @Test
    void shouldThrowExceptionWhenNameIsEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> new BoardGame("", 8, 5));

        assertThrows(IllegalArgumentException.class,
                () -> new BoardGame("   ", 8, 5));
    }

    @Test
    void shouldThrowExceptionWhenMinAgeIsNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new BoardGame("Chess", -1, 5));
    }

    @Test
    void shouldThrowExceptionWhenRentalCostIsZeroOrNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new BoardGame("Chess", 8, 0));

        assertThrows(IllegalArgumentException.class,
                () -> new BoardGame("Chess", 8, -5));
    }

    @ParameterizedTest
    @CsvSource({
            "8, true",
            "10, true",
            "5, false",
            "0, false"
    })
    void shouldCheckIfCanBeRentedByAge(int customerAge, boolean expected) {
        BoardGame game = new BoardGame("Chess", 8, 5);
        assertEquals(expected, game.canBeRentedBy(customerAge));
    }

    @Test
    void shouldRentGame() {
        assertFalse(game.isRented());
        game.setRented(true);
        assertTrue(game.isRented());
    }
}