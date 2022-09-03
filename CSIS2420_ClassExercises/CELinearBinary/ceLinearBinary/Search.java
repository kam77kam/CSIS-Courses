package ceLinearBinary;

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
		return 0; //TODO
	}
}