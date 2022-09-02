/*
Author: Kamdon Bird
Date: 
Assignment A04 - AutomobileApp
*/
package a04;

public class AutomobileApp{

   public static void main(String[] args){
   
      Automobile car1 = new Automobile("Audi", "A4", 26);
      Automobile car2 = new Automobile("Honda", "Accord", 31);
      Automobile car3 = new Automobile("Cadillac", "CTS", 21);
      
      System.out.printf("%-8s %-6s  %-5.2f mpg   %-4.2f  l%n", car1.getMake(), car1.getModel(), car1.getMpg(), car1.literPer100km());
      System.out.printf("%-8s %-6s  %-5.2f mpg   %-4.2f  l%n", car2.getMake(), car2.getModel(), car2.getMpg(), car2.literPer100km());
      System.out.printf("%-8s %-6s  %-5.2f mpg  %-4.2f  l%n", car3.getMake(), car3.getModel(), car3.getMpg(), car3.literPer100km());

   }
}