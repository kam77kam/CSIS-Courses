package m03;

import edu.princeton.cs.algs4.BinarySearchST;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Module3 CODE Challenge Fall 2023.
 * 
 * @author CS Starter Code + Kamdon Bird
 */
public class Module3 {

	public static void main(String[] args) {
		// CHALLENGE 4A:
		// Uncomment the following code to test the methods createSymbolTable
		// and demoSymbolTable.
//
//		RedBlackBST<Integer, Plane> st = createSymbolTable(12);
//		demoSymbolTable(st);
//		System.out.println();

		// CHALLENGE 4B:
		// Write a block comment that compares BinarySearchST and ST
		/**
		 * Binary Search Tree - This implementation uses a sorted array. The put and
		 * remove operations take O(n) time in the worst case. The contains, ceiling,
		 * floor, and rank operations take O(log n) time in the worst case. The size,
		 * is-empty, minimum, maximum, and select operations take O(1) time.
		 * Construction takes O(1) time.
		 */
		/**
		 * Binary ST - This implementation uses a red-black BST. The put, get, contains,
		 * remove, minimum, maximum, ceiling, and floor operations each take O(log n)
		 * time in the worst case, where n is the number of key-value pairs in the
		 * symbol table. The size and is-empty operations take O(1) time. Construction
		 * takes O(1) time.
		 */
		// For each implementation determine the underlying data structure
		// and the time complexity of adding n elements (not just one element).
		// https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/BinarySearchST.java.html
		// https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/ST.java.html

		// CHALLENGE 4C:
		// Create a time series to determine the time complexity of adding
		// n random numbers to BinarySearchST. The keys are 7-digit numbers,
		// the associated values are string representations of the key.
		// E.g., the key 1234567 is associated with the value "1234567"
		// Print the results in straight columns and include labels when you
		// display the results of your time measurements.
		
		final double BILLION = 1_000_000_000;
		int size = 1_000_000;
		System.out.println("--------------------------------");
		System.out.printf("|%-15s|%-14s|\n", "# of n (keys)", "duration (sec)");
		long start;
		for(int i = 0; i < 10; i++) {
			start = System.nanoTime();
			for (int j = 0; j < size; j++) {
				BinarySearchST<Integer, String> bst = new BinarySearchST<>();
				bst.put(StdRandom.uniformInt(1000000, 10000000), String.valueOf(StdRandom.uniformInt(1000000, 10000000)));
			}
			size += size;
			double duration = (System.nanoTime() - start) / BILLION;
			System.out.printf("|%-15d|%-14.4f|\n", size, duration);
			
		}
		System.out.println("--------------------------------");
		System.out.println();
		

		// = = = = = = Use the area below for your own testing (optional) = = = = =

	}

	/**
	 * Formats the Planes by creating columns for the Keys and the Plane Model provided
	 * by the RedBlackBST.
	 * 
	 * @param key   The Integer key from the RedBlackBST.
	 * @param model The planes model by the RedBlackBST.
	 */
	private static void planeFormat(Integer key, Plane plane) {
		System.out.printf("|%4s|%-19s|%-10s|\n", key, plane.getModel(), plane.getPassengerCount());
	}
	
	

	/**
	 * Creates a random number that corresponds to a military time. In military
	 * time, the first two digits correspond to the hour of the day 0 - 23 and the
	 * third and fourth digits correspond to the minutes 0 - 59 Since leading zeros
	 * are ignored, the returned number can have 1 to 4 digits.
	 * 
	 * Examples: 8:30 AM is represented as 830 (0830 but leading 0 is ignored) 12:45
	 * PM is represented as 1245 1:20 PM is represented as 1320 5:15 PM is
	 * represented as 1715 11:59 PM is represented as 2359 12:00 AM is represented
	 * as 0 (0000 but leading 0s are ignored) 12:07 AM is represented as 7 (0007 but
	 * leading 0s are ignored)
	 * 
	 * @return a random number corresponding to a military time.
	 */
	public static int getRandomTime() {
		return StdRandom.uniformInt(0, 2400);
	}

	/**
	 * Creates a symbol table and fills it with the specified number of key value
	 * pairs.
	 * 
	 * The keys are random numbers representing a military time. The associated
	 * values are random planes. The size of the symbol table is restricted to the
	 * following range: [1, 1440].
	 * 
	 * The symbol table data simulates information about planes that landed at a
	 * given airport at a given day over the span of 24 hours.
	 * 
	 * @param size number of key-value pairs in the symbol table
	 * @return a symbol table with the specified number of key-value pairs
	 * @throws IllegalArgumentException if size is less than 1 or greater than 1440
	 * 
	 * @param size number of key-value pairs in the symbol table
	 * @return a symbol table with the specified number of key-value pairs
	 * @throws IllegalArgumentException if size is less than 1 or greater than 1440
	 */
	public static RedBlackBST<Integer, Plane> createSymbolTable(int size) {
		if (size < 1 || size > 1440)
			throw new IllegalArgumentException("Size can't be less than 1 or greater than 1440");
		RedBlackBST<Integer, Plane> redBlackBst = new RedBlackBST<>();
		for (int i = 0; i < size; i++) {
			redBlackBst.put(getRandomTime(), new Plane());
		}
		return redBlackBst;
	}

	/**
	 * Demonstrates the usefulness of methods from class RedBlackBST in the context
	 * of planes landing at an airport.
	 */
	public static void demoSymbolTable(RedBlackBST<Integer, Plane> st) {
		// CHALLENGE 3 Use methods from class RedBlackBST to complete the following four
		// challenges.

		// 3A:
		// List all keys and their associated values in straight columns.
		// The keys should be right-aligned in a column of width 4. The values should be
		// left-aligned.
		// One or more blanks separate the keys from the values.
		System.out.println("3a) All Key-Value Pairs");
		System.out.println("-------------------------------------");
		System.out.println("|Keys|Plane Models       |Passengers|");
		System.out.println("|----|-------------------|----------|");
		for (Integer key : st.keys()) {
			Plane plane = st.get(key);
			planeFormat(key, plane);
		}
		System.out.println("-------------------------------------");
		System.out.println();

		// 3B:
		// Print the last plane that landed at the given day.
		// Include the time of the landing in military time.
		System.out.println("3b) Last plane");
		System.out.println("-------------------------------------");
		System.out.println("| Key|Plane Model        |Passengers|");
		System.out.println("|----|-------------------|----------|");
		planeFormat(st.max(), st.get(st.max()));
		System.out.println("-------------------------------------");
		System.out.println();

		// 3C:
		// Print how many planes landed before 10 am.
		System.out.println("3c) How many planes landed before 10 am.");
		System.out.println("----------------------------------------");
		System.out.println(st.size(0, 1000) + " planes made landing");
		System.out.println("-------------------------------------");
		System.out.println();

		// 3D:
		// Print the first plane that landed after noon.
		// Include the time of the landing in military time.
		System.out.println("3d) First plane after noon");
		System.out.println("-------------------------------------");
		System.out.println("|Keys|Plane Models       |Passengers|");
		System.out.println("|----|-------------------|----------|");
		planeFormat(st.ceiling(1200), st.get(st.ceiling(1200)));
		System.out.println("-------------------------------------");
		System.out.println();
	}

}
