package lab;

import java.util.Scanner;
public class MinMax{
   public static void main(String[] args){
   
      Scanner input = new Scanner(System.in);
      
      System.out.print("number1: ");
      int number1;
      number1 = input.nextInt();
      input.nextLine();
      
      System.out.print("number2: ");
      int number2;
      number2 = input.nextInt();
      input.nextLine();
         
      if (number1 < number2){
         System.out.printf("%d is less than %d", number1, number2);
         }
      if (number1 > number2){
         System.out.printf("%d is greater than %d", number1, number2);
         }
      if (number1 == number2){
         System.out.printf("%d is equal to %d", number1, number2);
         }
      input.close();
   }
}