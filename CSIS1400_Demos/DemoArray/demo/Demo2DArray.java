package demo;

public class Demo2DArray{
   
      public static void main(String[] args){
            
            //declare array1 as a retangular 2-dim int array
            int [][] array1 = {{1,2,3},{4,5,6}};
            
            //declare array2 as jagged array
            int [][] array2 = {{9,8,7},{2,4},{7,5,3,1}};
            
            //write a method outputArray (with a foreach loop)
            System.out.println("Array 1: ");
            outputArray(array1);
            System.out.println("Array 2: ");
            outputArray(array2);
      }
   private static void outputArray(int [][] array){
      //for each loop
      for (int [] row:array){
         for(int el:row){
            System.out.printf("%3d ", el);
         }
         System.out.println();
      }
      
      //using foor loops
      System.out.println("using for loops");
      for (int row = 0; row < array.length; row++){
         for (int col = 0; col < array[row].length; col++){
            System.out.printf("%3d ", array[row][col]);
         }
         System.out.println();
      }
   }
}