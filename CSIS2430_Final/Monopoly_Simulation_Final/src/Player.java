package src;

/**
 * Class representing a player.
 */
public class Player {
    private int currentPosition; // Player's current position on the board
    private int totalMoves; // Total number of moves made by the player
    private boolean getOutOfJailCard; // Indicates if the player has a Get Out of Jail Free card
    private boolean inJail; // Indicates if the player is in jail

    /**
     * Constructor for Player class.
     * Initializes the player's position, total moves, Get Out of Jail card status, and jail status.
     */
    public Player() {
        currentPosition = 0; // Start at Go
        totalMoves = 0; // Total amount of moves
        getOutOfJailCard = false; // Out Of Jail Free card
        inJail = false; // Not in jail
    }

    /**
     * Move the player by a specified number of steps.
     * @param steps the number of steps to move the player
     */
    public void move(int steps) {
        currentPosition = (currentPosition + steps) % 40; // Mod 40 because there are 40 spaces
        totalMoves++; // Increment total moves
        
        // Check if the player landed on the Go to Jail space
        if (currentPosition == 30) {
            goToJail();
        }
    }

    /**
     * Get the player's current position on the board.
     * @return the current position of the player
     */
    public int getCurrentPosition() {
        return currentPosition;
    }

    /**
     * Set the player's current position on the board.
     * @param newPosition the new position of the player
     */
    public void updateCurrentPosition(int newPosition) {
        currentPosition = newPosition;
    }

    /**
     * Get the total number of moves made by the player.
     * @return the total moves made by the player
     */
    public int getTotalMoves() {
        return totalMoves;
    }

    /**
     * Check if the player has a Get Out of Jail Free card.
     * @return true if the player has the card, false otherwise
     */
    public boolean hasGetOutOfJailCard() {
        return getOutOfJailCard;
    }
    
    /**
     * Check if the player is in jail.
     * @return true if the player is in jail, false otherwise
     */
    public boolean inJail() {
        return inJail;
    }

    /**
     * Send the player to jail.
     * If the player has a Get Out of Jail card, use it to get out.
     */
    public void goToJail() {
        currentPosition = 10; // Jail position
        inJail = true; // Player is now in jail
        // If player has Get Out Of Jail card, use it
        if (getOutOfJailCard) {
            getOutOfJailCard = false; // Player used the card
            inJail = false; // Player no longer in jail
        }
    }

    /**
     * Set the player's Get Out of Jail Free card status.
     * @param hasCard true if the player has the card, false otherwise
     */
    public void setGetOutOfJailCard(boolean hasCard) {
        getOutOfJailCard = hasCard;
    }

    /**
     * Release the player from jail.
     */
    public void outOfJail() {
        inJail = false; // Player is no longer in jail
    }
}
