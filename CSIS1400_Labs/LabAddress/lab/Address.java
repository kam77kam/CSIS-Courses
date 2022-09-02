package lab;

/*************************************
*
* 
* Address Class describes the address
* of a person
*
*************************************/
public class Address{
   //fields
   private String street;
   private String city;
   private State state;
   private int zip;
   
   //ctors              
   public Address(String street, String city, State state, int zip){
      this.street = street;
      this.city = city;
      this.state = state;
      this.zip = zip;
   }
   //methods
   
   @Override
   public String toString(){
   
      return (street + " " + city + ", " + state + " " + zip);
   }
}