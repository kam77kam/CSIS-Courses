package demo;

public class DemoBall
{
   public static void main(String[] args)
   {
      //First Ball Start
      Ball myBall = new Ball(6.0);
      
      System.out.println("myBall is " + myBall.getSize());
      myBall.setSize(7.0);
      System.out.println("myBall is " + myBall.getSize());
      myBall.bounce(10);
      
      //Second Ball Start
      Ball myBall2 = new Ball(7,true);
      System.out.println();
      System.out.println();
      System.out.println("myBall2 is " + myBall2.getSize() + " and isBlack is " + myBall2.getIsBlack());
      myBall2.bounce(8);
      
   }
}