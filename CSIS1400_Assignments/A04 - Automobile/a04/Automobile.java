/*
Author: Kamdon Bird
Date: 
Assignment A04 - Automobile
*/
package a04;

public class Automobile{
   
   //fields
   private String make;
   private String model;
   private double mpg;
   
   //constructors
   public Automobile(String make, String model, double mpg){
      this.make = make;
      this.model = model;
      this.mpg = mpg;
   }
   //methods
   public String getMake(){
      return make;
   }
   public String getModel(){
      return model;
   }
   public double getMpg(){
      return mpg;
   }
   public double literPer100km(){
      double litersPer100km = (100 * 3.785411784) / (1.609344 * mpg);
      return litersPer100km;
   }
}