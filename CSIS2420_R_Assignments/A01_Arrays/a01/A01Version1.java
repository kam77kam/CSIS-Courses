package a01;

/**
 * Coding challenges for assignment A01 part1.
 * 
 * @author CSIS + Kamdon Bird
 *
 */
import java.util.Arrays;

public class A01Version1 {

	/**
	 * Returns a new array that includes every other number starting with the first.
	 * E.g., [10, 20, 30, 40, 50, 60] returns [10, 30, 50] E.g., [10] returns [10]
	 * <p>
	 * Boundary cases: If the array is empty, an empty array should be returned.
	 * 
	 * @param numbers original array of whole numbers
	 * @return array that includes every other number starting with the first
	 * @throws NullPointerException if the user passes null as an argument
	 */
	public static int[] everyOther(int[] numbers) {

		if (numbers.length < 0)
			throw new NullPointerException("numbers can't be less than 1");

		int cnt = 0;
		if (numbers.length % 2 == 1)
			cnt = 1;
		cnt = (cnt + numbers.length) / 2;
		int[] array = new int[cnt];
		cnt = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (i % 2 == 0) {
				array[cnt] = numbers[i];
				cnt++;
			}
		}
		return array;
	}

	/**
	 * Determines whether the order of the elements in the array from front to back
	 * is the same as the order of the elements from back to front. E.g., ['r', 'a',
	 * 'c', 'e', 'c', 'a', 'r'] returns true E.g., ['D', 'a', 'd'] returns false
	 * (case matters) E.g., [10, 20] returns false E.g., ["hello"] returns true (a
	 * single element is a palindrome)
	 * 
	 * @param array
	 * @return true if the array is a palindrome and false otherwise
	 * @throws IllegalArgumentException if the array includes no elements
	 * @throws NullPointerException     if the argument passed to the method is null
	 */
	public static <T> boolean isPalindrome(T[] array) {
		if(array == null)
			throw new NullPointerException("The array can not be null");
		if(array.length == 0)
			throw new IllegalArgumentException("Array can not be empty");
		for(int i = 0, j = array.length-1; i < j; i++, j--) {
			if(!array[i].equals(array[j]))
				return false;
		}
		return true;
	}

	/**
	 * Finds the maximum absolute value in a two-dimensional array of integers.
	 *
	 * @param arr The input 2D array.
	 * @return The maximum absolute value in the array. Returns 0 if the array is
	 *         empty. If the array contains duplicate maximum absolute values, the
	 *         method returns the first occurrence found.
	 */
	public static int findMaximumAbsoluteValue(int[][] arr) {
		if(arr.length == 0)
			return 0;
		int max = arr[0][0];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(Math.abs(arr[i][j]) > max) {
					max = Math.abs(arr[i][j]);
				}
			}
		}
		return max;
	}

	/**
	 * Calculates the sum of the elements in the secondary diagonal of a square
	 * matrix. This is the diagonal from the top-right to the bottom-left.
	 *
	 * @param matrix The square matrix represented as a 2D array of integers.
	 * @return The sum of the elements in both diagonals of the matrix.
	 * @throws IllegalArgumentException if the matrix is not square.
	 * @throws IllegalArgumentException if the matrix is empty.
	 * @throws NullPointerException     if the matrix is null.
	 */
	public static int diagonalSum(int[][] matrix) {
		if(matrix == null)
			throw new NullPointerException("The matrix can not be null");
		if(matrix.length == 0)
			throw new IllegalArgumentException("The matrix can not be empty");
		if(matrix.length != matrix[0].length)
			throw new IllegalArgumentException("The matrix is not square");
		int sum = 0;
		int n = matrix.length;
		for(int i = 0; i < n; i++) {
			sum += matrix[i][n-i-1];
		}
		return sum;
	}

	public static void main(String args[]) {
		int[] array = { 10, 20, 30, 40, 50, 50, 70 };
		System.out.println("Array: " + Arrays.toString(everyOther(array)));

	}

}
