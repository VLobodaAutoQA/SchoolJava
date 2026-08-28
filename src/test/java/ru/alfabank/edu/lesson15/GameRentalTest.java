package ru.alfabank.edu.lesson15;

// GameRentalTest.java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameRentalTest {

    private GameRental rental;
    private BoardGame monopoly;
    private BoardGame chess;

    @BeforeEach
    void setUp() {
        rental = new GameRental();
        monopoly = new BoardGame("Monopoly", 8, 5);
        chess = new BoardGame("Chess", 6, 3);

        rental.addGame(monopoly);
        rental.addGame(chess);
    }

    @Test
    void shouldRentGameSuccessfully() {
        assertTrue(rental.rentGame("Monopoly", 10));
        assertTrue(monopoly.isRented());
    }

    @Test
    void shouldNotRentGameWhenAgeIsTooLow() {
        assertFalse(rental.rentGame("Monopoly", 5));
        assertFalse(monopoly.isRented());
    }

    @Test
    void shouldNotRentGameWhenAlreadyRented() {
        rental.rentGame("Monopoly", 10);
        assertFalse(rental.rentGame("Monopoly", 12));
        assertTrue(monopoly.isRented());
    }

    @Test
    void shouldThrowExceptionWhenRentingNonExistentGame() {
        assertThrows(IllegalArgumentException.class,
                () -> rental.rentGame("NonExistent", 10));
    }

    @Test
    void shouldReturnGameSuccessfully() {
        rental.rentGame("Monopoly", 10);
        assertTrue(rental.returnGame("Monopoly"));
        assertFalse(monopoly.isRented());
    }

    @Test
    void shouldReturnFalseWhenReturningNonExistentGame() {
        assertFalse(rental.returnGame("NonExistent"));
    }

    @Test
    void shouldReturnFalseWhenReturningNotRentedGame() {
        assertFalse(rental.returnGame("Monopoly"));
    }

    @ParameterizedTest
    @MethodSource("rentalTestData")
    void shouldHandleVariousRentalScenarios(String gameName, int age, boolean expectedResult) {
        assertEquals(expectedResult, rental.rentGame(gameName, age));
        if (expectedResult) {
            BoardGame game = rental.findGame(gameName);
            assertTrue(game.isRented());
        }
    }

    private static Stream<org.junit.jupiter.params.provider.Arguments> rentalTestData() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of("Monopoly", 8, true),
                org.junit.jupiter.params.provider.Arguments.of("Monopoly", 7, false),
                org.junit.jupiter.params.provider.Arguments.of("Chess", 6, true),
                org.junit.jupiter.params.provider.Arguments.of("Chess", 5, false)
        );
    }
}
