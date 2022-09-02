package lab;

import java.util.Random;
public class LabRandom
{
   public static void main(String[] args)
   {
      Random rand = new Random();
      int number;
      //1nd loop
      for(int i = 1; i <= 100; i++)
      {
         number = rand.nextInt(25) + 1;
            System.out.printf("%5d", number);
         if (i % 10 == 0)
            System.out.println();
      }
//       //2nd loop
//       System.out.println();
//       
//       for(int i = 1; i <= 100; i++)
//       {
//          number = (rand.nextInt(9) + 1) * 10;
//             System.out.printf("%5d", number);
//          if (i % 10 == 0)
//             System.out.println();
//       }
//       //3rd loop
//       System.out.println();
//       for(int i = 1; i <= 100; i++)
//       {
//          number = (rand.nextInt(99) + 901) ;
//             System.out.printf("%5d", number);
//          if (i % 10 == 0)
//             System.out.println();
//       }
      
   }
}