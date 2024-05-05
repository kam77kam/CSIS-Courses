package src;

public class SimulatorRunner {

	public static void main(String[] args) {
		MonopolyBoard mb = new MonopolyBoard();
		Player p = new Player();
		Die d = new Die();

		int[] turns = { 1000, 10000, 100000, 1000000 }; // Different numbers of turns

		simulationA(mb, p, d, turns);
		System.out.println();
		System.out.println();
		System.out.println();
//		simulationB(mb, p, d, turns);

	}

	private static void simulationA(MonopolyBoard mb, Player p, Die d, int[] turns) {
		System.out.printf("%75s", "Strategy A Simulation\n");
		printTableHeader(turns); // Print the table header
		// Iterate over each property
		for (int i = 0; i < mb.getPositionCount(); i++) {
			String propertyName = mb.getPositionName(i);
			int[] counts = new int[turns.length];
			double[] percentages = new double[turns.length];

			// Run simulation for each number of turns
			for (int j = 0; j < turns.length; j++) {
				int totalTurns = turns[j];
				int[] spaceCounts = runSimulation(mb, p, d, totalTurns);
				counts[j] = spaceCounts[i];
				percentages[j] = (double) spaceCounts[i] / totalTurns * 100;
			}

			// Print the property's data
			printPropertyData(propertyName, counts, percentages);
		}
		System.out.println("****************************************************************"
				+ "******************************************************************");
	}

	private static void simulationB(MonopolyBoard mb, Player p, Die d, int[] turns) {
		System.out.printf("%75s", "Strategy B Simulation\n");
		printTableHeader(turns); // Print the table header
		// Iterate over each property
		for (int i = 0; i < mb.getPositionCount(); i++) {
			String propertyName = mb.getPositionName(i);
			int[] counts = new int[turns.length];
			double[] percentages = new double[turns.length];

			// Run simulation for each number of turns
			for (int j = 0; j < turns.length; j++) {
				int totalTurns = turns[j];
				int[] spaceCounts = runSimulation(mb, p, d, totalTurns);
				if(p.getInJail()) {
					p.removePlayerInJail();
				}
				counts[j] = spaceCounts[i];
				percentages[j] = (double) spaceCounts[i] / totalTurns * 100;
			}

			// Print the property's data
			printPropertyData(propertyName, counts, percentages);
		}
		System.out.println("****************************************************************"
				+ "******************************************************************");
	}

	// Method to run the simulation and return space counts
	public static int[] runSimulation(MonopolyBoard mb, Player p, Die d, int totalTurns) {
		int[] spaceCounts = new int[mb.getPositionCount()]; // Array to store how many times each space is landed on

		// Main game loop
		for (int turn = 0; turn < totalTurns; turn++) {
			// Roll the dice
			int dice1 = d.roll();
			int dice2 = d.roll();
			int steps = dice1 + dice2;
			
			// Move the player
			p.move(steps);

			// Update space counts
			spaceCounts[p.getCurrentPosition()]++;

			// Handle special cases like Chance, Community Chest, Jail, etc.
			// Implement these as needed
		}

		return spaceCounts;
	}

	// Method to print the table header
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
		for (int turn : turns) {
			System.out.printf("| %-10s | %-11s", "Count", "%");
		}
		System.out.println("|");
		System.out.printf("%-25s", "");
		System.out.println(
				"|------------|------------|------------|------------|------------|------------|------------|------------|");
	}

	// Method to print property data for each number of turns
	public static void printPropertyData(String propertyName, int[] counts, double[] percentages) {
		System.out.printf("%-25s", propertyName);
		for (int i = 0; i < counts.length; i++) {
			System.out.printf("| %-10d | %%%-10.2f", counts[i], percentages[i]);
		}
		System.out.println("|");
	}

}