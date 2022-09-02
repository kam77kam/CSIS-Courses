/*
Author: Kamdon Bird
Date: 
Assignment A05 - WageCalulator
*/
package a05;

class WageCalculator{

   // fields
   private double baseRate = 0;
   private double overtimeMultiplier = 1.5;
   private int hours = 0;
   
   //constructors initialize fields
   public WageCalculator(double baseRate, int hours)
   {
      if(baseRate < 7.25)
      {
         throw new IllegalArgumentException();
      }
      else
      {
         this.baseRate = baseRate;
      }
      
      if(hours >= 0)
      {
         this.hours = hours;
      }
      else
      {
         throw new IllegalArgumentException();
      }

   }
   
   // overloaded constructor
   public WageCalculator(double baseRate, double overtimeMultiplier, int hours)
   {
      this(baseRate,hours);
      this.overtimeMultiplier = overtimeMultiplier;
   }
   
   // methods
   public double baseWage(){
      if(hours <= 40)
         return baseRate * hours; 
      else
         return baseRate * 40;
   }
   
   public double overtimeWage(){
      if(hours > 40)
         return overtimeMultiplier * (hours - 40) * baseRate;
      else
         return 0;
   }
   
   public double totalWage(){
      return baseWage() + overtimeWage();
   }
   
   public String toString(){
      return String.format("baseRate: %.2f, hours: %d,overtimeMultiplier: %.1f",baseRate,hours,overtimeMultiplier);
   }
}