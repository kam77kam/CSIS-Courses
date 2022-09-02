/*
Author: Kamdon Bird
Date: 
Assignment A05 - WageCalulatorApp
*/
package a05;
 
import java.util.Scanner;

public class WageCalculatorApp {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Base rate: ");
		double baseRate = input.nextDouble();		
		System.out.print("Hours: ");
		int hours = input.nextInt();	
      input.nextLine(); // clean up newline
      double multiplier = 0;
      
		System.out.print("Would you like to enter an overtime multiplier (yes/no)? ");
		String provideMultiplier = input.nextLine();
		
      WageCalculator calculator;
		if (provideMultiplier.equalsIgnoreCase("yes")){
			System.out.print("Enter Multiplier: ");
			multiplier = input.nextDouble();
		   calculator = new WageCalculator(baseRate, multiplier, hours);
		}
      else {
			calculator = new WageCalculator(baseRate, hours);
		}
     
      System.out.printf("\nBase Wage: %.1f\nOvertime Wage: %.1f\nTotal Wage: %.1f\n",
		   calculator.baseWage(), calculator.overtimeWage(), calculator.totalWage());
      input.close();
   }
}