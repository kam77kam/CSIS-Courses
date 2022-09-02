package demo;

public class DemoChar{

   public static void main(String[] args){
   
      char c1 = 'b';
      System.out.println("c1: " + c1);
      
      //hexacode for 1/4
      char c2 = 188;
      System.out.println("c2: " + c2);
      
      //unicode for 1/4
      char c3 = '\u00bc';
      System.out.println("c3: " + c3);
      
      System.out.printf("c3: %c %d %04X%n", c3,(int)c3,(int)c3);
   }
}