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
		for (int i = 0; i < arraySize; i++) {
			array[i] = StdRandom.uniform(1_000_000, 10_000_000);
		}

		return array;
	}

//=================TEST CLIENT=================
	public static void main(String[] args) {
		int[] array = getRandomNumberArray(10, 7);
		System.out.println(Arrays.toString(array));
	}

}
