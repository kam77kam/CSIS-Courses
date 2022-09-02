package lab;

import java.util.Scanner;

public class LabVariables{

   public static void main (String[] args) {
   
      Scanner input = new Scanner(System.in);
      
      System.out.printf("Choose Red, or Blue %s%n");
      String color1;
      color1 = input.nextLine();
      System.out.printf("Favorite Color is: %s%n", color1);

//      int red = Red;
//      int blue = Blue;
      
      System.out.println();
//      System.out.printf("Favorite Color is Red: %d%n", red);
//      System.out.printf("Favorite Color is Blue: %d", blue);
      input.close();
         }
}