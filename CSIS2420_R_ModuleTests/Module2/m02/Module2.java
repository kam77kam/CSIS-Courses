package m02;

import java.util.Arrays;

import edu.princeton.cs.algs4.Knuth;
import edu.princeton.cs.algs4.StdRandom;

/**
 * CSIS 2420 Midterm2 Challenge - Fall 2023.
 * 
 * @author CSIS Starter Code + Kamdon Bird
 *
 */
public class Module2 {

	public static void main(String[] args) {
		measureTime();
		System.out.println();
		
		displayTrees();

	}

	/**
	 * Creates an array of the specified size that is filled with uniformly
	 * random numbers from the range [1,000, 50,000).
	 * 
	 * @param n number of elements in the array
	 * @return array of random numbers from the range [1,000, 50,000).
	 */
	private static Integer[] getRandomNumberArray(int n) {
		Integer[] numbers = new Integer[n];

		for (int i = 0; i < n; i++) {
			numbers[i] = StdRandom.uniformInt(1_000, 50_000);
		}
		return numbers;
	}
	
	/**
	 * Measures the time it takes to shuffle.
	 */
	private static void measureTime() {
		int BILLION = 1_000_000_000;

		System.out.println("Measure Time");
		System.out.println("~~~~~~~~~~~~");

		int n = 100_000;
		Integer[] numbers = getRandomNumberArray(n);
			
		// measure time to shuffle the array
		long start = System.nanoTime();
		Knuth.shuffle(numbers);
		double elapsedTime = System.nanoTime() - start;
		System.out.printf("n: %8d %7.4f s %n", n, (elapsedTime / BILLION));		
	}

	/**
	 * Displays trees in different orders.
	 */
	private static void displayTrees() {
		Tree[] trees = {
				new Tree("Linden", 75), new Tree("GreenAsh", 60), new Tree("RedOak", 75), 
				new Tree("RedCedar", 38), new Tree("PinOak", 60), new Tree("Sassafras", 38), 
				new Tree("Hemlock", 60), new Tree("Walnut", 75), new Tree("Pear", 38),
				new Tree("Aspen", 38), new Tree("Sumac", 17)				
		};
		
		System.out.println("Display Trees");
		System.out.println("~~~~~~~~~~~~~");
		
		System.out.println("Trees:");
		for (Tree t : trees) {
			System.out.print(t + " ");
		}
		System.out.println("\n");

		System.out.println("Trees sorted by name:");
		Arrays.sort(trees);
		System.out.println();

		System.out.println("Trees sorted by height:");
		System.out.println();

	}
}
