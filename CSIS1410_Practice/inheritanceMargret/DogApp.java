package inheritanceMargret;

public class DogApp{
   public static void main(String[] args){
      Dog myDog = new Dog("Golden Retriever");
      displayDogInfo(myDog);
      
      SledDog mySledDog = new SledDog("Husky");
      displayDogInfo(mySledDog);
      
      CircusDog myCircusDog = new CircusDog("Spitz");
      displayDogInfo(myCircusDog);
   }
   
   private static void displayDogInfo(Dog dog){
      System.out.printf("Breed: %s%n", dog.getBreed());
      dog.communicate();
      dog.move();
      if (dog instanceof SledDog){
         SledDog sledDog = (SledDog)dog;
         sledDog.pullSled();
      }
      System.out.println();
   }
}