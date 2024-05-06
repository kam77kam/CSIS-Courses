package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class representing a deck of chance cards
 */
public class ChanceCards {
    private List<String> cards;

    /**
     * Constructor initializes the chance cards
     */
    public ChanceCards() {
        cards = new ArrayList<>();
        // Add chance cards to the deck
        cards.add("ADVANCE_TO_BOARDWALK");
        cards.add("ADVANCE_TO_GO (COLLECT $200)");
        cards.add("ADVANCE_TO_ILLINOIS_AVENUE");
        cards.add("ADVANCE_TO_ST_CHARLES_PLACE");
        cards.add("ADVANCE_TO_THE_NEAREST_RAILROAD");
        cards.add("ADVANCE_TO_THE_NEAREST_RAILROAD");
        cards.add("ADVANCE_TOKEN_TO_NEAREST_UTILITY");
        cards.add("BANK_PAYS_YOU_DIVIDEND_OF_$50");
        cards.add("GET_OUT_OF_JAIL_FREE");
        cards.add("GO_BACK_3_SPACES");
        cards.add("GO_TO_JAIL");
        cards.add("MAKE_GENERAL_REPAIRS_ON_ALL_YOUR_PROPERTY");
        cards.add("SPEEDING_FINE_$15");
        cards.add("TAKE_A_TRIP_TO_READING_RAILROAD");
        cards.add("YOU_HAVE_BEEN_ELECTED_CHAIRMAN_OF_THE_BOARD");
        cards.add("YOUR_BUILDING_LOAN_MATURES");
        shuffle();
    }

    /**
     * Method to shuffle the chance cards
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
     * Method to find the nearest railroad position
     * @param currentPosition current position of the player
     * @return nearest railroad position
     */
    public int findNearestRailroad(int currentPosition) {
        int[] railroadPositions = {5, 15, 25, 35}; // Positions of railroads

        int nearestRailroad = railroadPositions[0];
        int minDistance = Math.abs(railroadPositions[0] - currentPosition);

        // Find the nearest railroad position
        for (int position : railroadPositions) {
            int distance = Math.abs(position - currentPosition);
            if (distance < minDistance) {
                minDistance = distance;
                nearestRailroad = position;
            }
        }

        return nearestRailroad;
    }

    /**
     * Method to find the nearest utility position
     * @param currentPosition current position of the player
     * @return nearest utility position
     */
    public int findNearestUtility(int currentPosition) {
        int[] utilityPositions = {12, 28}; // Positions of utility companies

        int nearestUtility = utilityPositions[0];
        int minDistance = Math.abs(utilityPositions[0] - currentPosition);

        // Find the nearest utility position
        for (int position : utilityPositions) {
            int distance = Math.abs(position - currentPosition);
            if (distance < minDistance) {
                minDistance = distance;
                nearestUtility = position;
            }
        }

        return nearestUtility;
    }

    /**
     * Method to perform action based on the drawn card
     * @param card drawn card
     * @param player player performing the action
     */
    public void performChance(String card, Player player) {
        switch (card) {
            case "ADVANCE_TO_BOARDWALK":
                player.updateCurrentPosition(39);
                break;
            case "ADVANCE_TO_GO (COLLECT $200)":
                player.updateCurrentPosition(0);
                break;
            case "ADVANCE_TO_ILLINOIS_AVENUE":
                player.updateCurrentPosition(24);
                break;
            case "ADVANCE_TO_ST_CHARLES_PLACE":
                player.updateCurrentPosition(11);
                break;
            case "ADVANCE_TO_THE_NEAREST_RAILROAD":
                int nearestRailroad = findNearestRailroad(player.getCurrentPosition());
                player.updateCurrentPosition(nearestRailroad);
                break;
            case "ADVANCE_TOKEN_TO_NEAREST_UTILITY":
                int nearestUtility = findNearestUtility(player.getCurrentPosition());
                player.updateCurrentPosition(nearestUtility);
                break;
            case "GET_OUT_OF_JAIL_FREE":
                player.setGetOutOfJailCard(true);
                break;
            case "GO_TO_JAIL":
                player.goToJail();
                break;
            case "TAKE_A_TRIP_TO_READING_RAILROAD":
                player.updateCurrentPosition(5);
                break;
        }
    }
}