package lab;

public class AddressApp{

   static Address myAddress = new Address("123 Main Street","Salt Lake City", State.UT,  84123);
   static Friend myFriend = new Friend("Mike",myAddress);
   
   public static void main (String[] args){
      testEnum();
      System.out.println();
//       testAddress();
//       testFriend(); 
 
   }
//    private static void testFriend(){
//       System.out.println(myFriend);
//    }
//    
//    private static void testAddress(){
//       System.out.println(myAddress);
//    }
   
   private static void testEnum(){
      //create enum
     
      int count = 0;
      for (State s : State.values()){    //why this works we'll study soon
         count++;
            System.out.print(s + " ");
            if (count % 5 == 0){
               System.out.println();
            }
      }
   }
}