package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class representing a deck of community cards
 */
public class CommunityCards {
    private List<String> cards;

    /**
     * Constructor initializes the community cards
     */
    public CommunityCards() {
        cards = new ArrayList<>();
        // Add community cards to the deck
        cards.add("ADVANCE_TO_GO");
        cards.add("BANK_ERROR");
        cards.add("DOCTORS_FEE");
        cards.add("SALE_OF_STOCK");
        cards.add("GET_OUT_OF_JAIL");
        cards.add("GO_TO_JAIL");
        cards.add("HOLIDAY_FUND");
        cards.add("INCOME_TAX_REFUND");
        cards.add("BIRTHDAY");
        cards.add("LIFE_INSURANCE");
        cards.add("HOSPITAL_FEES");
        cards.add("SCHOOL_FEES");
        cards.add("CONSULTANCY_FEE");
        cards.add("STREET_REPAIR");
        cards.add("BEAUTY_CONTEST");
        cards.add("INHERITANCE");
        shuffle();
    }

    /**
     * Method to shuffle the community cards
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Draw the top card from the deck and move it to the bottom
     * @return top card drawn from the deck
     */
    public String drawCard() {
        // If the deck is empty, return null
        if (cards.isEmpty()) {
            return null;
        }
        String topCard = cards.remove(0); // Remove the first card
        cards.add(topCard); // Add the card to the bottom
        return topCard;
    }

    /**
     * Method to perform action based on the drawn card
     * @param card drawn card
     * @param player player performing the action
     */
    public void performCommunity(String card, Player player) {
        switch (card) {
            case "ADVANCE_TO_GO (COLLECT $200)":
                player.updateCurrentPosition(0);
                break;
            case "GET_OUT_OF_JAIL":
                player.setGetOutOfJailCard(true);
                break;
            case "GO_TO_JAIL":
                player.goToJail();
                break;
        }
    }
}
