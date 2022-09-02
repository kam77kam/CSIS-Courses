package lab;

//creating MartainApp and using class Martian
public class MartianApp{
   //creating main method
   public static void main(String[] args){
      //testing test method
      test();
      //creating unknownInvaders and make them doSomething method
      Martian[] unknownInvaders = Martian.invade();
      for(Martian el: unknownInvaders){
         el.doSomething();
      }
      //creating invaders and print them
      Martian[] invaders = Martian.invade(13);
      for(Martian el: invaders){
         System.out.print(el + " ");
      }
   }
   //creating test method
   public static void test(){
      Martian myMartian = new Martian();
      System.out.printf("%s%n", myMartian);
      Martian[] martians = {new Martian(), new Martian(), new Martian()};
      for(Martian el: martians){
         el.doSomething();
      }
   }
}