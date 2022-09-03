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
	public static void main(String[] args) {
		int list[] = {5,10,15,20,25,30,35,40,45,50,55,60,65,70,75};
		int key = list.length-1;
		int result = ceLinearBinary.Search.linear(list, list[key]);
		System.out.print(list[result]);
		
	}
}