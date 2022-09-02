package lab;

/**
 * @author Kamdon Bird
 *
 */
public class Dog
{
    /**
     * 
     */
    private final String breed;

    /**
     * @param b
     */
    public Dog(String b)
    {
        breed = b;
    }

    /**
     * 
     */
    public void communicate()
    {
        System.out.println("bark bark");
    }

    /**
     * 
     */
    public void move()
    {
        System.out.println("run");
    }

    /**
     * @return breed of dog
     */
    public String getBreed()
    {
        return breed;
    }
    public String toString() {
    	return String.format("%s: %s", this.getClass().getSimpleName(), this.getBreed());
    }
}
