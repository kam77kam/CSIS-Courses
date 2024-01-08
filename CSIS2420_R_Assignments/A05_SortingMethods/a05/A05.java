package a05;

import java.util.Arrays;
import java.util.Random;

import static a05.Mystery.*;

/**
 * @author Kamdon Bird, Haiyang Liu
 */
public class A05 {

	/**
	 * Generates a random array of integers with the specified size and number of
	 * digits.
	 *
	 * @param arraySize      The size of the array to generate.
	 * @param numberOfDigits The number of digits for each element in the array.
	 * @return A random integer array.
	 * @throws IllegalArgumentException if numberOfDigits is not between 1 and 10.
	 */
	private static Integer[] getRandomNumberArray(int arraySize, int numberOfDigits) {
		if (numberOfDigits > 10 || numberOfDigits < 1) {
			throw new IllegalArgumentException("The number of digits needs to be a value between 1 and 10.");
		}

		Integer[] arr = new Integer[arraySize];
		Random r = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(10) + 1;
		}

		return arr;
	}

	/**
	 * Generates a sorted array of integers with the specified size and number of
	 * digits.
	 *
	 * @param arraySize      The size of the array to generate.
	 * @param numberOfDigits The number of digits for each element in the array.
	 * @return A sorted integer array.
	 */
	private static Integer[] getSortedArray(int arraySize, int numberOfDigits) {
		Integer[] arr = new Integer[arraySize];
		Random r = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt();
		}

		Arrays.sort(arr);
		return arr;
	}

	/**
	 * Generates a reversed sorted array of integers with the specified size and
	 * number of digits.
	 *
	 * @param arraySize      The size of the array to generate.
	 * @param numberOfDigits The number of digits for each element in the array.
	 * @return A reversed sorted integer array.
	 */
	private static Integer[] getReversedArray(int arraySize, int numberOfDigits) {
		Integer[] arr = new Integer[arraySize];
		Random r = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt();
		}

		Arrays.sort(arr);

		for (int i = 0; i < arr.length / 2; i++) {
			int j = arr.length - 1 - i;
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}

		return arr;
	}

	// =========================================TEST CLIENT======================================================
	public static void main(String[] args) {
		//Random number array to test all sorts of Mystery.
		System.out.println("Random Number Array: ");
		System.out.println("        n | sort1      | sort2      | sort3      | sort4      |");
		System.out.println("----------|------------|------------|------------|------------|");

		int n = 1000;

		for (int i = 0; i < 7; i++) {
			Integer[] sort1 = getRandomNumberArray(n, 7);
			Integer[] sort2 = getRandomNumberArray(n, 7);
			Integer[] sort3 = getRandomNumberArray(n, 7);
			Integer[] sort4 = getRandomNumberArray(n, 7);

			long start = System.nanoTime();
			sort1(sort1);
			double sort1Time = (System.nanoTime() - start) / 1e9;

			start = System.nanoTime();
			sort2(sort2);
			double sort2Time = (System.nanoTime() - start) / 1e9;

			start = System.nanoTime();
			sort3(sort3);
			double sort3Time = (System.nanoTime() - start) / 1e9;

			start = System.nanoTime();
			sort4(sort4);
			double sort4Time = (System.nanoTime() - start) / 1e9;

			System.out.printf("%9d | %8.4fs  | %8.4fs  | %8.4fs  | %8.4fs  | \n", n, sort1Time, sort2Time, sort3Time,
					sort4Time);
			n *= 2;
		}
		System.out.println();
		//Sorted number array to test all sorts of Mystery.
		System.out.println("Sorted Number Array: ");
		System.out.println("        n | sort1      | sort2      | sort3      | sort4      |");
		System.out.println("----------|------------|------------|------------|------------|");

		n = 1000;

		for (int i = 0; i < 7; i++) {
			Integer[] sort1 = getSortedArray(n, 7);
			Integer[] sort2 = getSortedArray(n, 7);
			Integer[] sort3 = getSortedArray(n, 7);
			Integer[] sort4 = getSortedArray(n, 7);

			long start = System.nanoTime();
			sort1(sort1);
			double sort1Time = (System.nanoTime() - start) / 1e9;

			start = System.nanoTime();
			sort2(sort2);
			double sort2Time = (System.nanoTime() - start) / 1e9;

			start = System.nanoTime();
			sort3(sort3);
			double sort3Time = (System.nanoTime() - start) / 1e9;

			start = System.nanoTime();
			sort4(sort4);
			double sort4Time = (System.nanoTime() - start) / 1e9;

			System.out.printf("%9d | %8.4fs  | %8.4fs  | %8.4fs  | %8.4fs  | \n", n, sort1Time, sort2Time, sort3Time,
					sort4Time);
			n *= 2;
		}
		System.out.println();
		//Reversed number array to test all sorts of Mystery.
		System.out.println("Reversed Sorted Number Array: ");
		System.out.println("        n | sort1      | sort2      | sort3      | sort4      |");
		System.out.println("----------|------------|------------|------------|------------|");

		n = 1000;

		for (int i = 0; i < 7; i++) {
			Integer[] sort1 = getReversedArray(n, 7);
			Integer[] sort2 = getReversedArray(n, 7);
			Integer[] sort3 = getReversedArray(n, 7);
			Integer[] sort4 = getReversedArray(n, 7);

			long start = System.nanoTime();
			sort1(sort1);
			double sort1Time = (System.nanoTime() - start) / 1e9;

			start = System.nanoTime();
			sort2(sort2);
			double sort2Time = (System.nanoTime() - start) / 1e9;

			start = System.nanoTime();
			sort3(sort3);
			double sort3Time = (System.nanoTime() - start) / 1e9;

			start = System.nanoTime();
			sort4(sort4);
			double sort4Time = (System.nanoTime() - start) / 1e9;

			System.out.printf("%9d | %8.4fs  | %8.4fs  | %8.4fs  | %8.4fs  | \n", n, sort1Time, sort2Time, sort3Time,
					sort4Time);
			n *= 2;
		}
		System.out.println();
		//Large number array to test all sorts 2 and 3 of Mystery.
		System.out.println("Large Array: ");
		System.out.println("        n | sort2      | sort3      |");
		System.out.println("----------|------------|------------|");

		int n3 = 1_000_000;

		for (int j = 0; j < 7; j++) {

			Integer[] arr1 = new Integer[n3];
			Integer[] arr2 = new Integer[n3];
			Random r = new Random();

			for (int i = 0; i < arr1.length; i++) {
				arr1[i] = r.nextInt();
			}

			for (int i = 0; i < arr2.length; i++) {
				arr2[i] = r.nextInt();
			}

			long start = System.nanoTime();
			sort2(arr1);
			double sort2Time = (System.nanoTime() - start) / 1e9;

			start = System.nanoTime();
			sort3(arr2);
			double sort3Time = (System.nanoTime() - start) / 1e9;

			System.out.printf("%9d | %8.4fs  | %8.4fs  | \n", n3, sort2Time, sort3Time);
			
			n3 *= 2;
		}
		System.out.println();
	}

}