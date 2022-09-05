package ceLinearBinary;

//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;

public class Search {
	
	public static int linear(int[] numbers, int key) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == key)
                return i;
        }
        return -1;
	}
	//Binary Search
	public static int binary(int[] numbers, int key) {
//		if (numbers.length >= 1) {
//			int mid = (numbers.length - 1) / 2;
//			if (numbers[mid] == key) {
//				return mid;
//			}
//			if (numbers[mid] > key) {
//				
//				mid = (numbers.length - mid)/2;
//				
//			}
			return -1;
		}
//		//Initialize numbers to be in a ArrayList to be sorted
//		List<Integer> numArray = new ArrayList<Integer>();
//		for (int value : numbers) {
//			numArray.add(value);
//		}
//		Collections.sort(numArray);
//		//Logic for Binary Search
//		if(numArray.size() >= 1) {
//			int mid = (numArray.size()/2);
//			if (numArray[mid] == ) {
//				return mid;
//			}
//			if ()
//		}
//		return -1;
//	}
}