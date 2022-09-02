package mid;

public class Eagle {

   // Instance Fields/ Attributes
   private int mouseCount;
       
   //Constructor
   public Eagle(int count){
   mouseCount = count;
   
   }
   
   //Methods
   public void catchMouse(){
      mouseCount = mouseCount + 1;
      
   }
   
   public void fly(){
      System.out.print("flying....");
   }
   
}