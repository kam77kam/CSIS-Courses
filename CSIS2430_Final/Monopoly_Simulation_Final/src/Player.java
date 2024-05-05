package src;

//Class representing a player
public class Player {
	private int currentPosition; // Player's current position on the board
	private int totalMoves; // Total number of moves made by the player
	private boolean inJail; // Player's current in Jail Status
	private boolean getOutOfJailCard; // Add a field to keep track of Get Out of Jail Free card

	public Player() {
		currentPosition = 0; // Start at Go
		totalMoves = 0; // Total Amount of Moves
		inJail = false; // Player Jail Status
		getOutOfJailCard = false; // Out Of Jail Free card

	}

	// Method to move the player
	public void move(int steps) {
		if (!inJail) {
			currentPosition = (currentPosition + steps) % 40; // Mod 40 because there are 40 spaces
		}
		// Puts Player In Jail
		if (currentPosition == 30) {
			currentPosition = 10;
			inJail = true;
			// Checks if Player has Out Of Jail Free card
			if (getOutOfJailCard) {
				getOutOfJailCard = false;
				inJail = false;
			}
		}
		totalMoves++; // Increment total moves
	}

	// Getter for current position
	public int getCurrentPosition() {
		return currentPosition;
	}

	// Getter for total moves
	public int getTotalMoves() {
		return totalMoves;
	}

	// Getter for Get Out Of Jail card
	public boolean getGetOutOfJailCard() {
		return getOutOfJailCard;
	}

	// Getter to check if Player in Jail
	public boolean getInJail() {
		return inJail;
	}

	// Set to remove player from Jail
	public void removePlayerInJail() {
		inJail = false;
	}
}
