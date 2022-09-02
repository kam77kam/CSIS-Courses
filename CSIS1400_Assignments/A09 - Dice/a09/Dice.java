/*
Author: Kamdon Bird
Date: 11/14/2018
Assignment A09 - Dice
*/
package a09;

//imports
import java.util.Random;

//class LabDice
public class Dice{

   //methods
   //main method
   public static void main(String[] args){
   
      //fields
      int d1;
      int d2;
      int sum;
      int index = 0;
      
      //creating an object of random
      Random rand = new Random();
      
      //creating an array to be used
      int[] count = new int[11];
      
      //creating a loop to roll dice 36000 times
      for(int i = 0; i < 36000; i++){
         d1 = rand.nextInt(6) + 1;
         d2 = rand.nextInt(6) + 1;
         sum = d1 + d2;
         
         //creating switch (initiallizing the sum of both die to count array)
         switch(sum){
            case 2:
               count[0] += 1;
               break;
            case 3:
               count[1] += 1;
               break;
            case 4:
               count[2] += 1;
               break;
            case 5:
               count[3] += 1;
               break;
            case 6:
               count[4] += 1;
               break;
            case 7:
               count[5] += 1;
               break;
            case 8:
               count[6] += 1;
               break;
            case 9:
               count[7] += 1;
               break;
            case 10:
               count[8] += 1;
               break;
            case 11:
               count[9] += 1;
               break;
            case 12:
               count[10] += 1;
               break;
         }
            
      }
      
      //print statements
      //printint catergories names
      System.out.printf("Sum  Frequency  Percentage\n");

      //created a for-statement to display(print) the results of each 11 indexes with the Sum, Frequency, and Percentage
      for(int i = 2; i <= 12; i++){
         System.out.printf("%3d %10d %11.1f%%\n",i,count[index],((double) count[index] / 36000) * 100);
         index++;
      }
   }
}