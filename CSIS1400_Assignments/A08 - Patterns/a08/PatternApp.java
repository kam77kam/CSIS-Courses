/*
Author: Kamdon Bird
Date: 11/3/2018
Assignment A08 - PatternApp
*/
package a08;

//import Scanner for user input
import java.util.Scanner;
public class PatternApp{
   ////////////////Main method///////////////
   public static void main(String[] args){
      //new instance of scanner called input
      Scanner input = new Scanner(System.in);
      //inputPattern is assigned to 1 to run the while statement
      int inputPattern = 1;
      //checking that inputPattern is not 0
      while(inputPattern != 0){
         System.out.print("Choose a pattern(1-4) or 0 to quit: ");
         inputPattern = input.nextInt();
         //if inputPattern is between 1 - 4
         if(inputPattern > 0 && inputPattern < 5){
            System.out.print("Size: ");
            int inputSize = input.nextInt();
            //creating switch statement to be concise other than making a bunch of if statements
            switch(inputPattern){
               //Displays pattern1 with break
               case 1:
                  Pattern.pattern1(inputSize);
                     break;
               //Displays pattern2 with break
               case 2:
                  Pattern.pattern2(inputSize);
                     break;
               //Displays pattern3 with break
               case 3:
                  Pattern.pattern3(inputSize);
                     break;
               //Displays pattern4 with break
               case 4:
                  Pattern.pattern4(inputSize);
                     break;
            }
         }
      }
      //if user wants to quit program
      if (inputPattern == 0){
         System.out.println("Good Bye");
      }
      input.close();
   }
}