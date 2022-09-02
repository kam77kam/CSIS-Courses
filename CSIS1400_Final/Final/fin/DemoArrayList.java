package fin;
/*
Assignment: Final Code CSIS 1400
Name: Kamdon Bird
Date: 12/10/18
*/

//imports
import java.util.ArrayList;
import java.lang.Integer;

//creating class DemoArrayList
public class DemoArrayList{
   //fields
   
   //constructors
   
   //methods
   //creating main method to test code
   public static void main(String[] args){
      //creating an arrayList called numbers and printing them with label
      ArrayList<Integer> numbers = new ArrayList<>() {{add(2); add(4); add(8);}};
      System.out.print("numbers: ");
      System.out.println(numbers);
      
      //printing number of elements in the ArrayList numbers
      System.out.println("Number of elements: " + numbers.size());
      
      //removing index 2 and adding 6 to the ArrayList numbers
      numbers.remove(2);
      numbers.add(6);
      System.out.println("updated numbers: " + numbers);
      
      //creating a loop to print the numbers backwards
      for(int i = numbers.size(); i >= 1; i--){
         System.out.print(i + " ");
      }
   }
}
