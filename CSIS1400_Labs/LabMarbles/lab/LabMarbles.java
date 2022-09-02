package lab;

import java.util.Scanner;
public class LabMarbles{
   public static void main(String[] args){
   
      Scanner user = new Scanner(System.in);
      
      System.out.print("color: ");
      String color1;
      color1 = user.nextLine();
      System.out.print("number of " + color1 + " marbles: ");
      int number1;
      number1 = user.nextInt();
      user.nextLine();
      
      System.out.print("color: ");
      String color2;
      color2 = user.nextLine();
      System.out.print("number of " + color2 + " marbles: ");
      int number2;
      number2 = user.nextInt();
      user.nextLine();
      
      System.out.print("color: ");
      String color3;
      color3 = user.nextLine();
      System.out.print("number of " + color3 + " marbles: ");
      int number3;
      number3 = user.nextInt();
      user.nextLine();
      
      System.out.printf("%-12s", "Color");
      System.out.println("Number of Marbles");
      
         System.out.println("----------  -----------------");
         
            System.out.printf("%-12s", color1);
            System.out.printf("%-12d", number1);
            System.out.println();
            
               System.out.printf("%-12s", color2);
               System.out.printf("%-12d", number2);
               System.out.println();
               
                  System.out.printf("%-12s", color3);
                  System.out.printf("%-12d", number3);
                  System.out.println();
                  user.close();
   }
}