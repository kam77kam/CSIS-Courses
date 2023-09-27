package ceMerge;

import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.StdRandom;

public class MergeComparison {

	/*
	 * Creates an array that has a size specified by the user and is initialized
	 * with random 6-digit numbers
	 * 
	 * @param size
	 * 
	 * @return array of random numbers
	 */
	private static Integer[] getNumbers(int size) {
		Integer[] numbers = new Integer[size];
		for (int i = 0; i < size; i++) {
			numbers[i] = StdRandom.uniform(100_000, 1_000_000);
		}
		return numbers;
	}

	public static void main(String[] args) {
		final double BILLION = 1_000_000_000;
		int n = 50_000; // number of elements in the array

		System.out.println("Merge.sort");
		System.out.println("==========");
		// print header
		System.out.printf("%-8s  %s %n", "n", "duration");
		System.out.printf("%-8s  %s %n", "-".repeat(8), "-".repeat(8));

		// print time measurements
		for (int i = 0; i < 8; i++) {
			Integer[] numbers = getNumbers(n);

			long start = System.nanoTime();
			Merge.sort(numbers);
			double duration = (System.nanoTime() - start) / BILLION;
			System.out.printf("%-8d  %.4fs%n", n, duration);

			n *= 2;
		}
		System.out.println();
		n = 50_000; //reset n
		
		System.out.println("MergeSlow.sort");
		System.out.println("==============");
		System.out.println();
		// print header
		System.out.printf("%-8s  %s %n", "n", "duration");
		System.out.printf("%-8s  %s %n", "-".repeat(8), "-".repeat(8));

		// print time measurements
		for (int i = 0; i < 8; i++) {
			Integer[] numbers = getNumbers(n);

			long start = System.nanoTime();
			MergeSlow.sort(numbers);
			double duration = (System.nanoTime() - start) / BILLION;
			System.out.printf("%-8d  %.4fs%n", n, duration);

			n *= 2;
		}
		System.out.println("Done!!!");

	}

}
