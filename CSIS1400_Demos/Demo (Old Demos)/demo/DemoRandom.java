package demo;

import java.util.Random;

class DemoRandom{

   public static void main(String[] args){
   
      Random rand = new Random();
      char letter1;
      char letter2;
      char letter3;
      
      for(int i = 1; i <= 10; i++){
         int num = rand.nextInt(980);
         letter1 = (char)(rand.nextInt(26) + 'A');
         letter2 = (char)(rand.nextInt(26) + 'a');
         letter3 = (char)(rand.nextInt(26) + 'A');
         
         System.out.printf("License Plate #: %d %c%c%C%n",num,letter1,letter2,letter3);
      }
   }
}