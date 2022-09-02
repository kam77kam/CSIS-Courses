/*
Assignment: Final Code CSIS 1400
Name: Kamdon Bird
Date: 12/10/18
*/

//imports

//creating class DirectionApp
public class DirectionApp{
   //fields
   
   //constructors
   
   //methods
   //creating main method to test code
   public static void main(String[] args){
      
      //created an instance of Direction and printed the direction its facing
      Direction currentDirection = Direction.LEFT;
      System.out.println("currentDirection: " + currentDirection);
      
      //printing "UP - DOWN - LEFT - RIGHT"
      Direction nextDirection = currentDirection;
      System.out.println("nextDirection: " + nextDirection);
      for (Direction dir : Direction.values()) {
         System.out.print(dir + " - ");
      }
   }
}