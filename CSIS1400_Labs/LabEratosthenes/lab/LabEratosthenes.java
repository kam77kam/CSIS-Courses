package lab;

public class LabEratosthenes{
   
   public static void main(String[] args){
      boolean[] primes = new boolean[120];
      initArray(primes);
      crossOutNonPrimes(primes);
      printPrimes(primes);
   }
   private static void initArray(boolean[] array){
      for(int i = 2; i < array.length; i++){
         array[i] = true;
      }
   }
   //Crossing out anything that is divisible by 2 and 3 and 5
   private static void crossOutNonPrimes(boolean[] array){
      for(int i = 2; i < array.length; i++){
         if(array[i])
            for(int j = i; i * j < array.length; j++){
               array[i*j] = false;
            }
      }
   }
   //Printing prime numbers
   private static void printPrimes(boolean[] array){
      System.out.println("Prime Numbers: ");
      for(int i = 2; i < array.length; i++){
         if(array[i]){
            System.out.printf("%d ", i);
         }
         if(i % 10 == 0){
            System.out.println();
         }
      }
   }
}