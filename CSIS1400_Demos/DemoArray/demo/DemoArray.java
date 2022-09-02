package demo;

public class DemoArray
{

   public static void main(String[] args)
   {
      
      String[] array = new String[4];
      array[0] = "first";
      array[1] = "second";
      array[2] = "third";
      printArray(array); 
//       for(String el : array){
//          System.out.printf("%s ", el);          //THIS WORKS BUT I MADE A METHOD TO DO THIS
//       }

      array[3] = "forth";
      printArray(array);
//       for(String el : array){
//          System.out.printf("%s ", el);          //THIS WORKS BUT I MADE A METHOD TO DO THIS
//       }

      int[] numbers = new int[20];
      for(int i = 0; i < numbers.length; i++){
         numbers[i] = i * 2;
         System.out.print(numbers[i] + " ");
      }
      printArray(array);
      
//       for(int el : numbers){
//          System.out.printf("%d%n", el);          //THIS WORKS BUT I MADE A METHOD TO DO THIS
//       }
      
      }/***********************************CLOSED MAIN METHOD***********************************/
      
//      private static void printArray(int[] a){
//         for(int el : a){
//            System.out.printf("%d%n ", el);
//         }
//      }
        
      private static void printArray(String[] a){
         for(String el : a){
            System.out.printf("%s%n ", el);
         }
      }
}