/*Author: Kamdon Bird
 *Date: 9/5/2022
 ClassExercise: CELinearBinary
 */

package ceLinearBinary;
////only import if Easy way is needed
//import java.util.LinkedList;
import java.util.Collections;
import java.util.List;

public class Search {
	
	public static int linear(int[] numbers, int key) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == key) {
            	return i;
            }
        }
        return -1;
	}
	//Binary Search
	public static int binary(int[] numbers, int key) {
		int low = 0;
		int high = numbers.length;
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if(key < numbers[mid]) high = mid - 1;
			else if (key > numbers[mid]) low = mid + 1;
			else return mid;
		}
		return -1;
////The Easy way
////		Initialize numbers to be in a ArrayList to be sorted
//		List<Integer> numArray = new LinkedList<Integer>();
//		for (int value : numbers) {
//			numArray.add(value);
//			}
//		Collections.sort(numArray);
//		return Collections.binarySearch(numArray, key);
	}
}	