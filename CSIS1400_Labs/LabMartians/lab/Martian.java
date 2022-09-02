package lab;

//imports
import java.util.Random;
//creating class Martian
public class Martian{
   
   //fields
   private String name;
   private static int count;
   private static Random rand = new Random();
   //end of fields
   
   //constructors
   public Martian(){
      getRandomName();
      count++;
   }
   
   //methods
   public String getRandomName(){
      char c = (char)(rand.nextInt(26) + 'A');
      int n = rand.nextInt(90) + 10;
      name = " " + c + n;
      return name;
   }
   //creating method doSomething
   public void doSomething(){
      if(count < 5){
         System.out.println(name + " is hiding");
      }
      else
         System.out.println("ATTACK!");
   }
   //creating method invade to create invaders
   public static Martian[] invade(int num){
      Martian[] invaders = new Martian[num];
      
      for(int i = 0; i < num; i++){
         invaders[i] = new Martian();
      }
      return invaders;
   }
   //creating method invade
   public static Martian[] invade(){
   
      int num = rand.nextInt(8) + 2;
      Martian[] invaders = new Martian[num];
      
      for(int i = 0; i < invaders.length; i++){
         invaders[i] = new Martian();
      }
      return invaders;
   }
   
   @Override
   public String toString(){
      return (name + "\\" + count);
   }
}