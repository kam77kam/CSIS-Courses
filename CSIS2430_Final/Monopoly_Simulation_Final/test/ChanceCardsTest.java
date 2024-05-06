package test;

import src.ChanceCards;
import src.Player;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChanceCardsTest {

    // Check if drawCard() returns a non-null value
    @Test
    public void drawCard_ReturnNotNull() {
        ChanceCards chanceCards = new ChanceCards();
        assertNotNull(chanceCards.drawCard());
    }

    // Check if player advances to Boardwalk when "ADVANCE_TO_BOARDWALK" card is drawn
    @Test
    public void performChance_AdvanceToBoardwalk() {
        Player player = new Player();
        ChanceCards chanceCards = new ChanceCards();
        chanceCards.performChance("ADVANCE_TO_BOARDWALK", player);
        assertEquals(39, player.getCurrentPosition());
    }

    // Check if player advances to Go when "ADVANCE_TO_GO (COLLECT $200)" card is drawn
    @Test
    public void performChance_AdvanceToGo() {
        Player player = new Player();
        player.updateCurrentPosition(20); // Set player position to Park Place
        ChanceCards chanceCards = new ChanceCards();
        chanceCards.performChance("ADVANCE_TO_GO (COLLECT $200)", player);
        assertEquals(0, player.getCurrentPosition());
    }

    // Check if player advances to Illinois Avenue when "ADVANCE_TO_ILLINOIS_AVENUE" card is drawn
    @Test
    public void performChance_AdvanceToIllinoisAvenue() {
        Player player = new Player();
        ChanceCards chanceCards = new ChanceCards();
        chanceCards.performChance("ADVANCE_TO_ILLINOIS_AVENUE", player);
        assertEquals(24, player.getCurrentPosition());
    }

    // Check if player advances to St. Charles Place when "ADVANCE_TO_ST_CHARLES_PLACE" card is drawn
    @Test
    public void performChance_AdvanceToStCharlesPlace() {
        Player player = new Player();
        ChanceCards chanceCards = new ChanceCards();
        chanceCards.performChance("ADVANCE_TO_ST_CHARLES_PLACE", player);
        assertEquals(11, player.getCurrentPosition());
    }

    // Check if player advances to the nearest railroad when "ADVANCE_TO_THE_NEAREST_RAILROAD" card is drawn
    @Test
    public void performChance_AdvanceToNearestRailroad() {
        Player player = new Player();
        player.updateCurrentPosition(6); // Set player position to Oriental Ave (position 6)
        ChanceCards chanceCards = new ChanceCards();
        chanceCards.performChance("ADVANCE_TO_THE_NEAREST_RAILROAD", player);
        assertEquals(5, player.getCurrentPosition()); // Nearest railroad is Reading Railroad (position 5)
    }

    // Check if player advances token to the nearest utility when "ADVANCE_TOKEN_TO_NEAREST_UTILITY" card is drawn
    @Test
    public void performChance_AdvanceTokenToNearestUtility() {
        Player player = new Player();
        player.updateCurrentPosition(6); // Set player position to Oriental Ave (position 6)
        ChanceCards chanceCards = new ChanceCards();
        chanceCards.performChance("ADVANCE_TOKEN_TO_NEAREST_UTILITY", player);
        assertEquals(12, player.getCurrentPosition()); // Nearest utility is Electric Company (position 12)
    }

    // Check if player gets a Get Out of Jail Free card when "GET_OUT_OF_JAIL_FREE" card is drawn
    @Test
    public void performChance_GetOutOfJailFree() {
        Player player = new Player();
        ChanceCards chanceCards = new ChanceCards();
        chanceCards.performChance("GET_OUT_OF_JAIL_FREE", player);
        assertTrue(player.hasGetOutOfJailCard()); // Player should have a Get Out of Jail Free card
    }

    // Check if player goes to Jail when "GO_TO_JAIL" card is drawn
    @Test
    public void performChance_GoToJail() {
        Player player = new Player();
        ChanceCards chanceCards = new ChanceCards();
        chanceCards.performChance("GO_TO_JAIL", player);
        assertEquals(10, player.getCurrentPosition()); // Player should be at Jail (position 10)
    }

    // Check if player takes a trip to Reading Railroad when "TAKE_A_TRIP_TO_READING_RAILROAD" card is drawn
    @Test
    public void performChance_TakeATripToReadingRailroad() {
        Player player = new Player();
        ChanceCards chanceCards = new ChanceCards();
        chanceCards.performChance("TAKE_A_TRIP_TO_READING_RAILROAD", player);
        assertEquals(5, player.getCurrentPosition()); // Player should be at Reading Railroad (position 5)
    }
}
