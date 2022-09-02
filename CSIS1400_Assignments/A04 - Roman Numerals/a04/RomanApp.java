/*
Author: Kamdon Bird
Date: 10/15/2018
Assignment A04 - RomanApp
*/
package a04;

import java.util.Random;

public class RomanApp{
   public static void main(String[] arg){
      //Calling Summary
      Roman.summary();
      //Calling printNumeral
      for (int i = 0; i < 41; i++)
      {
         Roman.printNumeral(i);
      }
      Random rand = new Random();
      
      System.out.println("\n3 random numbers between 10 and 20");
      for (int i = 0; i < 3; i++)
      {
         Roman.printNumeral(rand.nextInt(10) + 10);
      }
   }
}