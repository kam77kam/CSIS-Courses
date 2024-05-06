package src;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a Monopoly board.
 */
public class MonopolyBoard {

	private final List<String> positions; // List of Positions/Properties
    private final CommunityCards communityCards; // Community cards deck
    private final ChanceCards chanceCards; // Chance cards deck

	/**
     * Constructor initializes the Monopoly board.
     */
	public MonopolyBoard() {
		// Adding spaces on Monopoly Board
		positions = new ArrayList<>();
		positions.add("Go");
		positions.add("Mediterranean Ave");
		positions.add("Comm Chest #1");
		positions.add("Baltic Ave");
		positions.add("Income Tax");
		positions.add("Reading Railroad");
		positions.add("Oriental Ave");
		positions.add("Chance #1");
		positions.add("Vermont Ave");
		positions.add("Connecticut Ave");
		positions.add("Jail");
		positions.add("St. Charles Place");
		positions.add("Electric Company");
		positions.add("States Ave");
		positions.add("Virginia Ave");
		positions.add("Pennsylvania Railroad");
		positions.add("St. James Pl");
		positions.add("Comm Chest #2");
		positions.add("Tennessee Ave");
		positions.add("New York Ave");
		positions.add("Free Parking");
		positions.add("Kentucky Ave");
		positions.add("Chance #2");
		positions.add("Indiana Ave");
		positions.add("Illinois Ave");
		positions.add("B&O Railroad");
		positions.add("Atlantic Ave");
		positions.add("Ventnor Ave");
		positions.add("Water Works");
		positions.add("Marvin Gardens");
		positions.add("Go to Jail");
		positions.add("Pacific Ave");
		positions.add("North Carolina Ave");
		positions.add("Comm. Chest #3");
		positions.add("Pennsylvania Ave");
		positions.add("Short Line Railroad");
		positions.add("Chance #3");
		positions.add("Park Place");
		positions.add("Luxury Tax");
		positions.add("Boardwalk");

		communityCards = new CommunityCards();

		chanceCards = new ChanceCards();
	}

	/**
     * Get the total number of spaces on the board.
     * @return the total number of spaces
     */
	public int getPositionCount() {
		return positions.size();
	}

	/**
     * Get the name of the space at a given index.
     * @param i the index of the space
     * @return the name of the space
     */
	public String getPositionName(int i) {
		return positions.get(i);
	}

	/**
     * Get the index of a space with a given name.
     * @param s the name of the space
     * @return the index of the space
     */
	public int getPositionIndex(String s) {
		return positions.indexOf(s);
	}

	/**
     * Draw a community card and perform its action for a player.
     * @param player the player to perform the action for
     */
	public void drawAndPeformCommunity(Player player) {
		String card = communityCards.drawCard();
		chanceCards.performChance(card, player);
	}

	/**
     * Draw a chance card and perform its action for a player.
     * @param player the player to perform the action for
     */
    public void drawAndPerformChance(Player player) {
        String card = chanceCards.drawCard();
        chanceCards.performChance(card, player);
    }
}
