package lab;

import java.util.Arrays;
public class LabArraysClass 
{
	public static void main(String[] args)
	{
		int[] iArray1 = {6, 12, 3, 9};
		int[] iArray2 = new int[5];
		
		// fill iArray2 with 7	
		Arrays.fill(iArray2, 7);
		// print iArray1 and iArray2 (toString)
		System.out.println("iArray1: " + Arrays.toString(iArray1));
      System.out.println("iArray2: " + Arrays.toString(iArray2));
		// search for number 9 in iArray1 and print the value returned:
      System.out.println("9 in iArray1: " + Arrays.binarySearch(iArray1, 9));
		// sort iArray1 and print it
      Arrays.sort(iArray1);
      System.out.printf("iArray1 sorted: %s%n", Arrays.toString(iArray1));
		// search for number 9 in iArray1 and print the value returned:
		System.out.println("9 in iArray1: " + Arrays.binarySearch(iArray1, 9));
		// create iArray3 and assign it the first 3 elements of iArray1; print it
	   int[] iArray3 = Arrays.copyOf(iArray1, 3);
      System.out.println("iArray3: " + Arrays.toString(iArray3));
		// test equality of new int[] {3, 6, 9} and iArray3; print result
		System.out.println("iArray3 equals " + 
         Arrays.toString(iArray3) + ": " + Arrays.equals(new int[] {3, 6, 9}, iArray3));
      //Reason Why 
      System.out.println("Reason: When 9 was searched the first time we hadn't Sorted the elements yet");
	}
}