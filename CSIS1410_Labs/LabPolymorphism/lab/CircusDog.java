package lab;

/**
 * @author Kamdon Bird
 *
 */
public class CircusDog extends Dog
{
    /**
     * @param b
     */
    public CircusDog(String b)
    {
        super(b);
    }

    @Override
    public void move()
    {
        System.out.println("tightrope walking");
    }
}
