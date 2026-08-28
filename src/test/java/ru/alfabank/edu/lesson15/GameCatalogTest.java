package ru.alfabank.edu.lesson15;

// GameCatalogTest.java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameCatalogTest {

    private GameRental rental;
    private BoardGame game1;
    private BoardGame game2;

    @BeforeEach
    void setUp() {
        rental = new GameRental();
        game1 = new BoardGame("Monopoly", 8, 5);
        game2 = new BoardGame("Chess", 6, 3);
    }

    @Test
    void shouldAddGameSuccessfully() {
        rental.addGame(game1);
        BoardGame found = rental.findGame("Monopoly");
        assertNotNull(found);
        assertEquals("Monopoly", found.getName());
    }

    @Test
    void shouldThrowExceptionWhenAddingNullGame() {
        assertThrows(IllegalArgumentException.class,
                () -> rental.addGame(null));
    }

    @Test
    void shouldThrowExceptionWhenAddingDuplicateGame() {
        rental.addGame(game1);
        assertThrows(IllegalArgumentException.class,
                () -> rental.addGame(new BoardGame("Monopoly", 10, 7)));
    }

    @Test
    void shouldFindExistingGame() {
        rental.addGame(game1);
        BoardGame found = rental.findGame("Monopoly");
        assertNotNull(found);
        assertEquals("Monopoly", found.getName());
    }

    @Test
    void shouldReturnNullWhenGameNotFound() {
        assertNull(rental.findGame("NonExistentGame"));
    }

    @Test
    void shouldFindGameCaseInsensitively() {
        rental.addGame(game1);
        BoardGame found = rental.findGame("monopoly");
        assertNotNull(found);
        assertEquals("Monopoly", found.getName());
    }
}
