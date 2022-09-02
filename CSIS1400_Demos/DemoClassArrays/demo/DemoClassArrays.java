package demo;

import java.util.Arrays;

public class DemoClassArrays{
   public static void main(String[] args){
      //Declare a character array and initialize it with a z b y m
      char[] letters = {'a', 'z', 'b', 'y', 'm'};
      
      //sort the array
      Arrays.sort(letters);
      
      //print the array
      System.out.println(Arrays.toString(letters));
      
      //search for the letter 'c' amd print the value returned, expected output: index of c .. -3
      int index = Arrays.binarySearch(letters, 'c');
      System.out.printf("index of c .. %d%n", index);
      //Same Print Statement but doesnt have a variable of index
      //System.out.printf("index of c .. %d%n", Arrays.binarySearch(letters, 'c'));
      
      //use a foreach loop to search for all the elements in letters
      //print the values returned -  one line at a time
      for (char el :  letters){
         System.out.printf("index of %c ... %d%n", el, Arrays.binarySearch(letters, el));
      }
      
      //create a copy of letters and save it in a variable called letters1
      char[] letters1 = Arrays.copyOf(letters, letters.length);
      
      //fll the array letters with the letters 'e'
      Arrays.fill(letters, 'e');
      
      //print both letters and letters1 on 2 separate lines
      System.out.printf("letters: %s%n", Arrays.toString(letters));
      System.out.printf("letters1: %s%n", Arrays.toString(letters1));
   }
}