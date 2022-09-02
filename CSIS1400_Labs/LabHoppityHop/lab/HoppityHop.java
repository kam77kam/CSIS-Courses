package lab;

public class HoppityHop{

   public static void main(String[] args){

      for(int i = 1; i <= 25; i++){
         if(i%3 == 0 && i%5 == 0){
            System.out.println("Hoppity Hop");
               }
         else
            if(i%3 == 0){
               System.out.println("Hoppity");
            }
         
         else
            if(i%5 == 0){
               System.out.println("Hop");
            }
         
         else{
            System.out.printf("%d\n", i);
         }
      }
   }
} 