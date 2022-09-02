package lab;

import java.util.Scanner;

public class CalculatorApp{
   public static void main(String[] args){
      Calculator calc = new Calculator();
      Scanner input = new Scanner(System.in);

      System.out.print("What is your first number? ");
      int firstNumber = input.nextInt();
      System.out.print("What is your Second number? ");
      int secondNumber = input.nextInt();
      System.out.println("Sum: " + calc.add(firstNumber, secondNumber));
      System.out.println("difference: " + calc.subtract(firstNumber, secondNumber));
      System.out.println("product: " + calc.multiply(firstNumber, secondNumber));
      input.close();
      
   }
}