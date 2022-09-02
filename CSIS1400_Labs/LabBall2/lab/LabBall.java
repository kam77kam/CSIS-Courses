package lab;

public class LabBall{

   //fields
   private double Size;
   
   //overloaded constructor
   public LabBall(double s, boolean isBlack)
   {
   
   }
   //ctors
   public LabBall(double s)
   {
      setSize(s);
   }
   //methods
   public double getSize()
   {
      return Size;
   }
   public void setSize(double s)
   {
      if(s >= 0)
         Size = s;
   }
   public void roll()
   {
      System.out.println("rolling...");
   }
   public void bounce (int numberOfBounces)
   {
      System.out.printf("bouncing %d times", numberOfBounces);
   }
}