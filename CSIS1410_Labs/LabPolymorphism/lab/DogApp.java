package lab;

/**
 * @author Kamdon Bird
 *
 */
public class DogApp
{
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        Dog myDog = new Dog("Greyhound");
        System.out.println(myDog.toString());
        actAsDog(myDog);

        SledDog mySledDog = new SledDog("Husky");
        System.out.println(mySledDog.toString());
        actAsDog(mySledDog);

        CircusDog myCircusDog = new CircusDog("Terrier");
        System.out.println(myCircusDog.toString());
        actAsDog(myCircusDog);
        
        Dog[] dogs = {myDog, mySledDog, myCircusDog};
        
        System.out.println("Using an array: \n");
        
        for(Dog d : dogs) {
        	System.out.println(d.toString());
        	if (d instanceof SledDog) {
        		((SledDog) d).pullSled();
        	}
        	actAsDog(d);
        }
    }

    /**
     * @param d
     */
    private static void actAsDog(Dog d)
    {
        d.communicate();
        d.move();
        System.out.println();
    }
}
