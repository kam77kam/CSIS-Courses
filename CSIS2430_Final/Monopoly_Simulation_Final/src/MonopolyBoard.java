package src;

import java.util.ArrayList;
import java.util.List;

//Class representing a Monopoly board
public class MonopolyBoard {

	private final List<String> positions; // List of Positions/Properties,

	// Constructor initializes the spaces
	public MonopolyBoard() {
		positions = new ArrayList<>();
		// Adding spaces on Monopoly Board
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
	}

	// Method to get the total number of spaces on the board
	public int getPositionCount() {
		return positions.size();
	}

	// Method to get the name of the space at a given index
	public String getPositionName(int i) {
		return positions.get(i);
	}

	// Method to get the index of a space with a given name
	public int getPositionIndex(String s) {
		return positions.indexOf(s);
	}

//	public List<String> getProperties() {
//		return spaces;
//	}

}
