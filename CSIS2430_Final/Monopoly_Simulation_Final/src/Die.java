package src;

import java.util.Random;

/**
 * This class represents a simple die with methods to roll it.
 */
public class Die {

    // Create a Random object for generating random numbers.
    public static Random generator = new Random();

    /**
     * Method to simulate rolling the die and return the result.
     * @return the result of rolling the die (a number between 1 and 6)
     */
    public int roll() {
        // Generate a random number between 1 and 6 (inclusive).
        return generator.nextInt(6) + 1;
    }
}
