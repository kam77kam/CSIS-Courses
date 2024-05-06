package src;

//Class representing a player
public class Player {
	private int currentPosition; // Player's current position on the board
	private int totalMoves; // Total number of moves made by the player
	private boolean getOutOfJailCard; // Add a field to keep track of Get Out of Jail Free card
	private boolean inJail; // 
	

	public Player() {
		currentPosition = 0; // Start at Go
		totalMoves = 0; // Total Amount of Moves
		getOutOfJailCard = false; // Out Of Jail Free card
		inJail = false;

	}

	// Method to move the player
	public void move(int steps) {
		currentPosition = (currentPosition + steps) % 40; // Mod 40 because there are 40 spaces
		totalMoves++; // Increment total moves
		
		// Check if the player landed on the Go to Jail space
	    if (currentPosition == 30) {
	        goToJail();
	    }
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
	
	// Getter for In Jail status
		public boolean inJail() {
			return inJail;
		}

	public void goToJail() {
		currentPosition = 10; // Jail position
		inJail = true;
	    // If player has Get Out Of Jail card, use it
	    if (getOutOfJailCard) {
	        getOutOfJailCard = false; // Player used the card
	        inJail = false; //Player no longer in jail
	    }
	}

	// Setter for Get Out Of Jail card
	public void setGetOutOfJailCard(boolean hasCard) {
	    getOutOfJailCard = hasCard;
	}

	public void OutOfJail() {
		inJail = false;
		
	}
}