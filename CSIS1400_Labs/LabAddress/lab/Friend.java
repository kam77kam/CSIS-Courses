package lab;

public class Friend {
   //fields
   String name;
   Address address;
   
   //ctors
   public Friend(String name, Address address){
      this.name = name;
      this.address = address;
   }
   
   //methods
   @Override
   public String toString(){
   
      return (name + " " + address);
   }
  
}