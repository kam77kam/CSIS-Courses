/**
 * 
 */
package ceQuick;

import java.util.Arrays;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Kamdon Bird
 */
public class SortComparison {

	private static int[] getRandomNumberArray(int arraySize, int numberOfDigits) {
		int[] array = new int[arraySize];
		int lowerBound = 1;
		int upperBound = 10;
		for(int i = 1; i < numberOfDigits; i++) {
			lowerBound = lowerBound * 10;
			upperBound = upperBound * 10;
		}
		for (int i = 0; i < arraySize; i++) {
			array[i] = StdRandom.uniform(lowerBound, upperBound);
		}
		return array;
	}

//=================TEST CLIENT=================
	public static void main(String[] args) {
		int[] array = getRandomNumberArray(10, 7);
//		for(int a: array) {
//			System.out.println(a);
//		}
		System.out.println(Arrays.toString(array));
	}

}
