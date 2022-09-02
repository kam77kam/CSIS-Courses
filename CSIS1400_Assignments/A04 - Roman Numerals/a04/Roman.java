/*
Author: Kamdon Bird
Date: 10/15/2018
Assignment A04 - Roman Numerals
*/
package a04;

public class Roman
{
   //Displays Roman Numeral Conversions
   public static void summary()
   {
      //Prints all Conversions
      System.out.println("I = 1");
      System.out.printf("%-14s %-8s%n", "V = 5", "IV = 4");
      System.out.printf("%-14s %-8s%n", "X = 10", "IX = 10");
      System.out.printf("%-14s %-8s%n", "L = 50", "XL = 40");
      System.out.printf("%-14s %-8s%n", "C = 100", "XC = 90");
      System.out.printf("%-14s %-8s%n", "D = 500", "CD = 400");
      System.out.printf("%-14s %-8s%n%n", "M = 1000", "CM = 900");
   }
   
   public static void printNumeral(int number)
   {
      //Declaring Variable
      String n = "";
      //Allowing Only Numbers Between 1 - 39
      if (number < 1 || number >= 40)
      {
         System.out.print("Valid Number Range 1 - 39\n");
      }
      else{
          // "X" is added for every "10"
          while (number >= 10) {
              n += "X";
              number -= 10;
          }
          // "IX" is added for every "9" 
          while (number >= 9) {
              n += "IX";
              number -= 9;
          }
          // "V" is added for every "5" 
          while (number >= 5) {
              n += "V";
              number -= 5;
          }
          // "IV" is added for every "4"
          while (number >= 4) {
              n += "IV";
              number -= 4;
          }
          // "I" is added for every "1"
          while (number >= 1) {
              n += "I";
              number -= 1;
          }
          // Print out all Roman Numerals
          System.out.println(n);
      } 
   }   
}