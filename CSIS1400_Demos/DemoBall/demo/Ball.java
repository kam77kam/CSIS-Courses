package demo;

public class Ball{

   //fields
   private double Size;
   private boolean isBlack;
   
   //ctors
   public Ball(double s){
      setSize(s);
   }
   
   //overloaded constructor
   public Ball(double s, boolean isBlack){
      setSize(s);
      this.isBlack = isBlack;
      
   }
   
   //methods
   public double getSize(){
      return Size;
   }
   public void setSize(double s){
      if(s >= 5)
         Size = s;
   }
   public void roll(){
      System.out.println("rolling...");
   }
   public void bounce (int numberOfBounces){
      System.out.printf("bouncing %d times", numberOfBounces);
   }
   public boolean getIsBlack(){
      return isBlack;
   }
}