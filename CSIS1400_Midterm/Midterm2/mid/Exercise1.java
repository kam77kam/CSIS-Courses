package mid;

import java.util.Random;

public class Exercise1
{
   
   public static void main(String[] args)
   {
      //creating a instance of Random
      Random rand = new Random();
      
      //generating numbers between 11 and 25 inclusive
      int randNumber = rand.nextInt(25) + 11;
      while (randNumber != 13){
    	  System.out.println();
      }
      System.out.println("all done");
      while (randNumber == 20){
         System.out.println("$$");
      }
      System.out.print(randNumber);
   }
}
