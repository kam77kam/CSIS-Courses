/*
Author: Kamdon Bird
Date: 12/10/2018
Assignment: DemoArray (Final)
*/
package fin;

//imports
import java.util.Arrays;

//creating class DemoArray
public class DemoArray{
   //fields
   
   //constructors
   
   //methods
   //creating main method to test code
   public static void main(String[] args){
      //created an array of type string and named it words
      String[] words = {"one","two","thre","four","thre","two","one"};
      //print out words array with brackets
      System.out.printf("Words: %s\n", Arrays.toString(words));
      
      /*removing the word "thre" and changing it to "three" and
      creating for each loop to access array words*/
      for(int i = 0; i< words.length; i++){
         if (words[i] == "thre"){
            words[i] = "three";
         }
      }
      //printing out words array without brackets using a loop
      System.out.print("Words: ");
      for(int i = 0; i< words.length; i++){
         System.out.printf("%s ", words[i]);
      }
   }
}