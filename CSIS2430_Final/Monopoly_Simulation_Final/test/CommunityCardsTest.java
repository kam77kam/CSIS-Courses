package test;

import src.CommunityCards;
import src.Player;
import org.junit.Test;
import static org.junit.Assert.*;

// The CommunityCardsTest class contains unit tests for the CommunityCards class.
public class CommunityCardsTest {

    // Check if drawCard() returns a non-null value.
    @Test
    public void drawCard_ReturnsNotNull() {
        CommunityCards communityCards = new CommunityCards();
        assertNotNull(communityCards.drawCard());
    }

    // Check if performCommunity() correctly advances player to Go and adds $200.
    @Test
    public void performCommunity_AdvanceToGo() {
        Player player = new Player();
        player.updateCurrentPosition(20); // Set player position to Park Place
        CommunityCards communityCards = new CommunityCards();
        communityCards.performCommunity("ADVANCE_TO_GO (COLLECT $200)", player);
        assertEquals(0, player.getCurrentPosition()); // Player should be at Go
    }

    // Check if performCommunity() correctly gives player a Get Out Of Jail card.
    @Test
    public void performCommunity_GetOutOfJail() {
        Player player = new Player();
        CommunityCards communityCards = new CommunityCards();
        communityCards.performCommunity("GET_OUT_OF_JAIL", player);
        assertTrue(player.hasGetOutOfJailCard()); // Player should have a Get Out of Jail Free card
    }

    // Check if performCommunity() correctly moves player to Jail.
    @Test
    public void performCommunity_GoToJail() {
        Player player = new Player();
        player.updateCurrentPosition(7); // Set player position to position 7
        CommunityCards communityCards = new CommunityCards();
        communityCards.performCommunity("GO_TO_JAIL", player);
        assertEquals(10, player.getCurrentPosition()); // Player should be at Jail
    }
}

