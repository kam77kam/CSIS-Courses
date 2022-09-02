package lab;

import java.util.Scanner;
class LabWhile{

   public static void main(String[] args){
      multiplyNumbers();
   }
   
   public static void multiplyNumbers(){
      int product = 1;
      int number;
      
      Scanner input = new Scanner(System.in);
      System.out.print("Enter a number or 0 to quit: ");
      number = input.nextInt();
      
      while(number != 0){
         product *= number;
         System.out.print("Enter a number or 0 to quit: ");
         number = input.nextInt();
      }
      System.out.print("Product is: ");
      System.out.printf("%d", product);
      input.close();
   }
}