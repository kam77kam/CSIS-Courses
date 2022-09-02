package listvsset;

import java.awt.Color;
import java.io.Serializable;

/**
 * Test Client for class ListVsSetDemo
 * 
 * @author Margret Posch
 */
public class ListVsSetConsoleApp implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @param args
     */
    public static void main(String[] args) {

    	 //notice: I pass the individual elements, // because the constructor is implemented with varargs
    	ListVsSetDemo demo = new ListVsSetDemo( new ColoredSquare(14, Color.BLUE), new ColoredSquare(18, Color.RED),
    			new ColoredSquare(12, Color.YELLOW), new ColoredSquare(18, Color.RED), new ColoredSquare(16, Color.GREEN));

    	System.out.println("List:\n" + demo.getListElements()); 
    	System.out.println("Set:\n" + demo.getSetElements());

    	System.out.println("\nAdding a new element:"); 
    	demo.addElement(new ColoredSquare(10, Color.ORANGE));
    	System.out.println("List:\n" + demo.getListElements()); 
    	System.out.println("Set:\n" + demo.getSetElements());
 
    	System.out.println("\nAdding a duplicate element:"); 
    	demo.addElement(new ColoredSquare(10, Color.ORANGE));
    	System.out.println("List:\n" + demo.getListElements()); 
    	System.out.println("Set:\n" + demo.getSetElements());
         
    }
}