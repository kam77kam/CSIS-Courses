package m02;

import java.util.Arrays;

import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.StdRandom;

/**
 * CSIS 2420 Midterm2 Challenge - Fall 2023.
 * 
 * @author CSIS Starter Code + Kamdon Bird
 *
 */
public class Module2 {

	public static void main(String[] args) {
		//getRandomNumberArray Test
		int elements = 5;
		System.out.println("Array that includes " + elements + " uniformly random numbers\n"
				+ "that are multiples of three and\n"
				+ "from the range [3,000,000, 900,000,000)");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		Integer[] array = getRandomNumberArray(elements);
		for(Integer el : array) {
			System.out.println(el);
		}
		System.out.println();
		
		
		//measureTime test
		measureTime();
		System.out.println();
		
		//displayTrees test
		displayTrees();

	}

	/**
	 * Creates an array of the specified size that is filled with uniformly
	 * random numbers that are only multiples of three from the range [3,000,000, 900,000,000).
	 * 
	 * @param n number of elements in the array
	 * @return array of random numbers that are multiples of three from the range [3,000,000, 900,000,000) 
	 * 
	 */
	private static Integer[] getRandomNumberArray(int n) {
		Integer[] numbers = new Integer[n];
		int tempInt;
		for (int i = 0; i < n; i++) {
			tempInt = StdRandom.uniformInt(3_000_000, 900_000_000);
			if(tempInt % 3 == 0) {
				numbers[i] = tempInt;
			}else {
				i -= 1;
			}
		}
		return numbers;
	}
	
	/**
	 * A series of 8 time measurements to determine the time complexity of the task 
	 * (of identifying the 7 smallest numbers and storing them in the array)
	 */
	private static void measureTime() {
		int BILLION = 1_000_000_000;
		int getLowestNumbers = 7;
		int n = 100_000;
		
		System.out.println("A series of 8 time measurements\n"
				+ "to determine the time complexity");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for(int i = 0; i < 8; i++) {
			Integer[] numbers = getRandomNumberArray(n);
			Integer[] smallestNumbers = new Integer[getLowestNumbers];
				
			long start = System.nanoTime();
			Heap.sort(numbers);
			for(int j = 0; j < smallestNumbers.length; j++) {
				smallestNumbers[j] = numbers[j];
			}
			double elapsedTime = System.nanoTime() - start;
			System.out.printf("n: %8d %7.4f s %n", n, (elapsedTime / BILLION));
		}
	}

	/**
	 * Displays trees in different orders
	 */
	private static void displayTrees() {
		Tree[] trees = {
				new Tree("Linden", 75), new Tree("GreenAsh", 60), new Tree("RedOak", 75), 
				new Tree("RedCedar", 38), new Tree("PinOak", 60), new Tree("Sassafras", 38), 
				new Tree("Hemlock", 60), new Tree("Walnut", 75), new Tree("Pear", 38),
				new Tree("Aspen", 38), new Tree("Sumac", 17)				
		};
		
		System.out.println("Displays trees in different orders");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		System.out.println("Trees:");
		for (Tree t : trees) {
			System.out.print(t + " \n");
		}
		System.out.println();
		
		System.out.println("Trees sorted by name:");
		Arrays.sort(trees);
		for (Tree t : trees) {
			System.out.print(t + " \n");
		}
		System.out.println();

		System.out.println("Trees sorted by height:");
		Arrays.sort(trees, Tree.BY_HEIGHT);
		for (Tree t : trees) {
			System.out.print(t + " \n");
		}
	}
}
