package practice;

///////////////
//Kamdon Bird//
////12/4/18////
///////////////

///////////////GOAL OF THIS CLASS///////////////////////
//Practicing how to make methods and call them in main//
////////////////////////////////////////////////////////

//created class Methods
public class Methods{
   
   //fields
   private String name;
   private int age;
   //constructors
   public Methods(String tempName){
      name = tempName;
   }
   //methods
   //created simpleText method
   public void simpleText(){
      System.out.println("simpleText() Works!");
      System.out.println("--------------------");
   }
   //creating setName method
   public void setName(String tempName){
      name = tempName;
   }
   //creating setAge method
   public void setAge(int tempAge){
      age = tempAge;
   }

   //creating methodReturnString
   public String methodReturnString(){
      return name;
   }
   
   //creating methodReturnInt
   public int methodReturnInt(){
      return age;
   }
   //creating methodOne method
   public void methodOne(){
      System.out.printf("Name: %s\nsetName Method Works!\nmethodReturnString Works!\nmethodOne Works!\n",methodReturnString());
      printLine();
   }
   //creating methodTwo method
   public void methodTwo(){
      System.out.printf("Age: %d\nsetAge Method Works!\nmethodReturnInt Works!\nmethodTwo Works!\n",methodReturnInt());
      printLine();
   }
   //creating methodOneAndTwo method
   public void methodOneAndTwo(String name, int age){
      System.out.printf("%s is %d years old, methodOneAndTwo Works!\n", name, age);
      printLine();
   }   
   //creating printLine method
   public void printLine(){
      System.out.println("--------------------");
   }
}