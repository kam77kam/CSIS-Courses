/******************************************************
* Name: Kamdon Bird
* Date: 10/24/2018
* Assignment: MIDTERM2 -Exercise2-
*
******************************************************/
package mid;

public class Exercise2{
   public static void main(String[] args){
      //VARIABLES//
      int k = 0;//----------------------------|Variable "k" will be used as an increment value
                                            //|for the "X"s in the pattern.
                                            
      //---------------------------MAIN FOR LOOP THAT DEFINES THE ROWS---------------------------------------//
      for(int i = 0; i<5; i++){
         
         //-----Nested For Loops that defines the pattern on each row-----//
         for(int j = 0; j<1 + i; j +=1){
            System.out.print("@ @ ");
         }
         for(int j = -1; j<2; j += 2){
            System.out.print(". ");
         }
         for(int j = 9; j>0 +k; j--){
            System.out.print("X ");
         }
         //---------------------------------------------------------------//
         
      k +=2;//---------------------------------|Increment "k" by 2 at the end of the main For Loop.
      
         System.out.println();//---------------|Set a new line at the end of each run in the
      }                                      //|main For Loop.
      //-----------------------------------------------------------------------------------------------------//
   }
}