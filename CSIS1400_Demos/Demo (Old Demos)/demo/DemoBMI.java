package demo;

import java.util.Scanner;
/************************
*Kamdon Bird
*Calculates the bmi of an individual, from user inputs
*using formula mass/height(2) * 703
*********************************/
public class DemoBMI{

   public static void main(String[] args){
   
      Scanner input = new Scanner(System.in);
      
      System.out.print("What is your weight (lbs)?: ");
      double weight = input.nextDouble();
      System.out.print("What is your height (inches)?: ");
      double height= input.nextDouble();
      
      double bmi = (weight / (height * height)) * 703;
      
      if (bmi < 18.5)
         System.out.println("You are underweight");
      else
         if (bmi < 25)
            System.out.println("You are just right");
         else
            if (bmi < 30)
               System.out.println("You are overweight");
            else
               System.out.println("You are obese");
    input.close();           
   }

}