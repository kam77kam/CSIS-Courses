package src;

import java.io.*;

public class SimulatorRunner {

	 /**
     * The main method starts the simulator.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        String logFilePath = "console_log.txt";
        // Redirect console output to a file
        try {
            // Create a file writer
            FileOutputStream fos = new FileOutputStream(new File(logFilePath));
            // Create a print stream to write to the file
            PrintStream ps = new PrintStream(fos);
            // Redirect standard output stream to the print stream
            System.setOut(ps);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        MonopolyBoard mb = new MonopolyBoard();
        Player p = new Player();
        Die d = new Die();
        final int dataSets = 10; // Different number of replayed game instances
        final int[] turns = { 1000, 10000, 100000, 1000000 }; // Different numbers of turns

        // Run simulation A
        for (int i = 1; i <= dataSets; i++) {
            System.out.printf("%75s", "Strategy A Simulation");
            System.out.print(" " + i + "\n");
            simulationA(mb, p, d, turns);
        }

        // Run simulation B
        for (int i = 1; i <= dataSets; i++) {
            System.out.printf("%75s", "Strategy B Simulation");
            System.out.print(" " + i + "\n");
            simulationB(mb, p, d, turns);
        }
    }

    /**
     * Simulate Strategy A.
     * @param mb the Monopoly board
     * @param p the player
     * @param d the die
     * @param turns the number of turns
     */
    public static void simulationA(MonopolyBoard mb, Player p, Die d, int[] turns) {
        printTableHeader(turns); // Print the table header
        // Iterate over each property
        for (int i = 0; i < mb.getPositionCount(); i++) {
            String propertyName = mb.getPositionName(i);
            int[] counts = new int[turns.length];
            double[] percentages = new double[turns.length];

            // Run simulation for each number of turns
            for (int j = 0; j < turns.length; j++) {
                int totalTurns = turns[j];
                int[] spaceCounts = new int[mb.getPositionCount()]; // Array to store how many times each space is landed on

                // Main game loop
                for (int turn = 0; turn < totalTurns; turn++) {
                    // Roll the dice
                    int dice1 = d.roll();
                    int dice2 = d.roll();
                    int steps = dice1 + dice2;

                    // Move the player
                    if (p.getCurrentPosition() + steps == 30) {
                        spaceCounts[30]++;
                    }
                    p.move(steps);

                    // Update space counts
                    spaceCounts[p.getCurrentPosition()]++;

                }
                counts[j] = spaceCounts[i];
                percentages[j] = (double) spaceCounts[i] / totalTurns * 100;
            }

            // Print the property's data
            printPropertyData(propertyName, counts, percentages);
        }
        System.out.println("****************************************************************"
                + "******************************************************************");
        System.out.println();
        System.out.println();
        System.out.println();
    }

    /**
     * Simulate Strategy B.
     * @param mb the Monopoly board
     * @param p the player
     * @param d the die
     * @param turns the number of turns
     */
    public static void simulationB(MonopolyBoard mb, Player p, Die d, int[] turns) {
        printTableHeader(turns); // Print the table header
        // Iterate over each property
        for (int i = 0; i < mb.getPositionCount(); i++) {
            String propertyName = mb.getPositionName(i);
            int[] counts = new int[turns.length];
            double[] percentages = new double[turns.length];
            int jailCounter = 1;

            // Run simulation for each number of turns
            for (int j = 0; j < turns.length; j++) {
                int totalTurns = turns[j];
                int[] spaceCounts = new int[mb.getPositionCount()]; // Array to store how many times each space is landed on

                // Main game loop
                for (int turn = 0; turn < totalTurns; turn++) {
                    // Roll the dice
                    int dice1 = d.roll();
                    int dice2 = d.roll();
                    int steps = dice1 + dice2;

                    // Check if player is in jail
                    if (p.inJail()) {
                        // If player is in jail and rolls doubles or is the , release them from jail
                        if (dice1 == dice2 || jailCounter % 4 == 0) {
                            p.outOfJail(); // Player rolls doubles, they can leave jail
                            spaceCounts[p.getCurrentPosition()]++; // Update space counts
                            jailCounter = 1; // Reset jail counter
                        } else {
                        	jailCounter++;
                            p.move(0); // Player stays in jail, no movement
                            spaceCounts[p.getCurrentPosition()]++; // Update space counts
                        }
                    } else {
                        // Move the player
                        if (p.getCurrentPosition() + steps == 30) {
                            spaceCounts[30]++; // Player lands on "Go to Jail" position
                        }
                        p.move(steps);

                        // Update space counts
                        spaceCounts[p.getCurrentPosition()]++;
                    }

                }
                counts[j] = spaceCounts[i];
                percentages[j] = (double) spaceCounts[i] / totalTurns * 100;
            }

            // Print the property's data
            printPropertyData(propertyName, counts, percentages);
        }
        System.out.println("****************************************************************"
                + "******************************************************************");
        System.out.println();
        System.out.println();
        System.out.println();
    }

    /**
     * Print the table header.
     * @param turns the number of turns
     */
    public static void printTableHeader(int[] turns) {
        System.out.println("****************************************************************"
                + "******************************************************************");
        System.out.printf("%-25s", "");
        for (int turn : turns) {
            System.out.printf("| n=%-22s", turn);
        }
        System.out.println("|");
        System.out.printf("%-25s", "");
        System.out.println(
                "|-------------------------|-------------------------|-------------------------|-------------------------|");
        System.out.printf("%-25s", "");
        for (int i = 0; i < turns.length; i++) {
            System.out.printf("| %-10s | %-11s", "Count", "%");
        }
        System.out.println("|");
        System.out.printf("%-25s", "");
        System.out.println(
                "|------------|------------|------------|------------|------------|------------|------------|------------|");
    }

    /**
     * Print property data for each number of turns.
     * @param propertyName the name of the property
     * @param counts the number of times the property was landed on
     * @param percentages the percentage of times the property was landed on
     */
    public static void printPropertyData(String propertyName, int[] counts, double[] percentages) {
        System.out.printf("%-25s", propertyName);
        for (int i = 0; i < counts.length; i++) {
            System.out.printf("| %-10d | %%%-10.2f", counts[i], percentages[i]);
        }
        System.out.println("|");
    }

}
