package ceQuick;

import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdRandom;

/**
 * A class that provides methods for generating arrays of random integers with a
 * specified number of digits and comparing the performance of selection sort
 * and quicksort algorithms on these arrays.
 *
 * This class contains methods for generating random integer arrays and
 * measuring the execution time of the selection sort and quicksort algorithms
 * on these arrays. It includes a test client in the `main` method that performs
 * performance comparisons and prints the results to the standard output.
 * 
 * @author Kamdon Bird
 */
public class SortComparison {

	/**
	 * Generates an array of random integers with a specified number of digits.
	 *
	 * This method generates an array of random integers, where each integer has a
	 * specified number of digits. The range of generated integers is determined by
	 * the number of digits, which should be between 1 and 10. The array size is
	 * specified by the 'arraySize' parameter.
	 *
	 * @param arraySize      The size of the array to be generated.
	 * @param numberOfDigits The number of digits for each generated integer
	 * @return An array of random integers with the specified number of digits.
	 * @throws IllegalArgumentException If the 'numberOfDigits' parameter is not
	 *                                  within the range of 1 to 10.
	 */
	private static Integer[] getRandomNumberArray(int arraySize, int numberOfDigits) {
		if (numberOfDigits < 0 || 10 < numberOfDigits)
			throw new IllegalArgumentException("The number of digits needs to be a value between 1 and 10");

		Integer[] array = new Integer[arraySize];
		int lowerBound = 1;
		int upperBound = 10;

		for (int i = 1; i < numberOfDigits; i++) {
			lowerBound *= 10;
			upperBound *= 10;
		}

		for (int i = 0; i < arraySize; i++) {
			array[i] = StdRandom.uniformInt(lowerBound, upperBound);
		}

		return array;
	}

	/**
	 * The main method that performs performance comparisons of selection sort and
	 * quicksort on arrays of random integers.
	 * This method generates random integer arrays of increasing sizes and measures
	 * the execution time of selection sort and quicksort on these arrays. The
	 * results are printed to the standard output.
	 *
	 * @param args The command-line arguments (not used in this program).
	 */
	public static void main(String[] args) {
		System.out.println("      n | Selection | Quick     |");
		System.out.println("--------------------------------|");
		int arraySize = 1000;
		long startTime, endTime;

		while (arraySize <= 512_000) {
			Comparable<Integer>[] arr = getRandomNumberArray(arraySize, 7);
			Comparable<Integer>[] arrCopy = arr;

			startTime = System.nanoTime();
			Selection.sort(arr);
			endTime = System.nanoTime();
			double selectionSortTime = (endTime - startTime) / 1e9;

			startTime = System.nanoTime();
			Quick.sort(arrCopy);
			endTime = System.nanoTime();
			double quickSortTime = (endTime - startTime) / 1e9;

			System.out.printf("%7d | %8.4fs | %.4fs", arraySize, selectionSortTime, quickSortTime);
			System.out.println("   |");

			arraySize *= 2;
		}
	}
}
