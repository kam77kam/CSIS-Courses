package demo;

import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber{
   public static void main(String[] args){
   
      Random rand = new Random();
      Scanner input = new Scanner(System.in);
      
      int secretNumber = rand.nextInt(50) + 1;

      int guessNumber;
      do
      {
      System.out.print("Guess (1 - 50): ");
      guessNumber = input.nextInt();
      if (guessNumber < secretNumber)
         System.out.println("too small");
      if (guessNumber > secretNumber)
         System.out.println("too high");
      }while (guessNumber != secretNumber);
      
      System.out.printf("You got it -- the number was %d%n",secretNumber);
      input.close();
   }
}