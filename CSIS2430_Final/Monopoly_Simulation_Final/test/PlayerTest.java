package test;

import src.Player;
import org.junit.Test;
import static org.junit.Assert.*;

// The PlayerTest class contains unit tests for the Player class.
public class PlayerTest {

    // Check if the player's initial position is 0 (Go).
    @Test
    public void initialPosition_IsZero() {
        Player player = new Player();
        assertEquals(0, player.getCurrentPosition());
    }

    // Check if the player's initial total moves is 0.
    @Test
    public void initialTotalMoves_IsZero() {
        Player player = new Player();
        assertEquals(0, player.getTotalMoves());
    }

    // Check if the player's initial Get Out Of Jail card status is false.
    @Test
    public void initialGetOutOfJailCardStatus_IsFalse() {
        Player player = new Player();
        assertFalse(player.hasGetOutOfJailCard());
    }

    // Check if the player's position updates correctly after moving.
    @Test
    public void move_CorrectlyUpdatesPosition() {
        Player player = new Player();
        player.move(5); // Move player 5 steps
        assertEquals(5, player.getCurrentPosition());
    }

    // Check if the player's position wraps around correctly after moving beyond the board's limit.
    @Test
    public void move_PositionWrapsAround() {
        Player player = new Player();
        player.move(42); // Move player 42 steps (beyond the board's limit)
        assertEquals(2, player.getCurrentPosition()); // Player should be at position 2
    }

    // Check if the player's total moves increases correctly after moving.
    @Test
    public void move_CorrectlyUpdatesTotalMoves() {
        Player player = new Player();
        player.move(3); // Move player 3 steps
        assertEquals(1, player.getTotalMoves());
    }

    // Check if the player's position updates correctly when explicitly set.
    @Test
    public void updateCurrentPosition_CorrectlyUpdatesPosition() {
        Player player = new Player();
        player.updateCurrentPosition(20); // Set player position to 20
        assertEquals(20, player.getCurrentPosition());
    }

    // Check if the player goes to jail correctly.
    @Test
    public void goToJail_CorrectlyMovesToJail() {
        Player player = new Player();
        player.updateCurrentPosition(7); // Set player position to position 7
        player.goToJail(); // Player should go to Jail (position 10)
        assertEquals(10, player.getCurrentPosition());
    }

    // Check if the player has a Get Out Of Jail card after setting it.
    @Test
    public void setGetOutOfJailCard_CorrectlySetsCard() {
        Player player = new Player();
        player.setGetOutOfJailCard(true); // Set player's Get Out Of Jail card to true
        assertTrue(player.hasGetOutOfJailCard());
    }

    // Check if the player's Get Out Of Jail card status updates correctly after using it.
    @Test
    public void goToJail_UsesGetOutOfJailCard() {
        Player player = new Player();
        player.setGetOutOfJailCard(true); // Set player's Get Out Of Jail card to true
        player.goToJail(); // Player should go to Jail (position 10) and use the card
        assertFalse(player.hasGetOutOfJailCard());
    }
}
