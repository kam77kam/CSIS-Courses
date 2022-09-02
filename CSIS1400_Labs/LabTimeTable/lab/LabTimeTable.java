package lab;

import java.util.Scanner;

class LabTimeTable{
   
   public static void main(String[] args){
   
      //Allowing keyboard input
      Scanner input = new Scanner(System.in);
      
      //prints
      System.out.println("Time Table: ");
      System.out.print("Number (1 - 10): ");
         
      //field or attributes
      int product = input.nextInt();
      System.out.println();

      //methods or behaviors
      for(int i = 1; i <=10; i ++){
         for(int userNumber = 1; userNumber<=10; userNumber++){
         int answerProduct = (userNumber * product);
         System.out.printf("%2d * %d = %d%n", userNumber, product, answerProduct);
         }
      input.close();
      }
   
   }
   
}