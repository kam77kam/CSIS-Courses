package src;

//Class representing a player
public class Player {
	private int currentPosition; // Player's current position on the board
	private int totalMoves; // Total number of moves made by the player
	private boolean getOutOfJailCard; // Add a field to keep track of Get Out of Jail Free card
	

	public Player() {
		currentPosition = 0; // Start at Go
		totalMoves = 0; // Total Amount of Moves
		getOutOfJailCard = false; // Out Of Jail Free card

	}

	// Method to move the player
	public void move(int steps) {
		currentPosition = (currentPosition + steps) % 40; // Mod 40 because there are 40 spaces
		totalMoves++; // Increment total moves
	}

	// Getter for current position
	public int getCurrentPosition() {
		return currentPosition;
	}

	// Setter for current position
	public void updateCurrentPosition(int newPosition) {
		currentPosition = newPosition;
	}

	// Getter for total moves
	public int getTotalMoves() {
		return totalMoves;
	}

	// Getter for Get Out Of Jail card
	public boolean hasGetOutOfJailCard() {
		return getOutOfJailCard;
	}

	public void goToJail() {
		currentPosition = 10; // Jail position
	    // If player has Get Out Of Jail card, use it
	    if (getOutOfJailCard) {
	        getOutOfJailCard = false; // Player used the card
	    }
	}

	// Setter for Get Out Of Jail card
	public void setGetOutOfJailCard(boolean hasCard) {
	    getOutOfJailCard = hasCard;
	}
}