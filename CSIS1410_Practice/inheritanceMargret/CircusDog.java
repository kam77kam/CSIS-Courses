package inheritanceMargret;

public class CircusDog extends Dog{
   public CircusDog(String b){
      super(b);
   }
   
   @Override
   public void move(){
      System.out.println("tight rope walking");
   }
}