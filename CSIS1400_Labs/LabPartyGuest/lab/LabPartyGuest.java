package lab;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class LabPartyGuest{
   
   public static void main(String[] args){
      //intiallizing variables, creating instances, and an array list
      int numberOfGuests = 4;
      Scanner input = new Scanner(System.in);
      Random rand = new Random();
      ArrayList<String> guestList = new ArrayList<String>();
      
      //prompting user for names of guests
      System.out.printf("Please enter %d guests: %n", numberOfGuests);
      int control = 1;
      while(control < numberOfGuests + 1){
         System.out.printf("guest%d: ", control);
         guestList.add(input.nextLine());
         input.close();
         control++;
      }
      //Guest List
      System.out.println("\nGuest List: " + guestList);
      String updated = guestList.get(rand.nextInt(guestList.size()));
      System.out.println(updated + " can't come");
      guestList.remove(updated);
      System.out.println("Updated guest list: " + guestList);
   }
}