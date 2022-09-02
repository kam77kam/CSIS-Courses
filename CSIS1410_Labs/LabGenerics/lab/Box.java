package lab;

import java.util.*;

/**
 * CLASS  Box - 
 *
 * @author mgunder3 - Mark Gunderson
 *
 * @param <T>
 */
public class Box<T> extends ArrayList<T> {
    // T stands for "Type"
    /**
     * FIELD - T t
     */
    private T t;

    /**
     * METHOD - void set - 
     *
     * @param t
     */
    public void set(T t) { this.t = t; }
    /**
     * METHOD - T get - 
     *
     * @return
     */
    public T get() { return t; }
    
    /* (non-Javadoc)
     * @see java.util.ArrayList#clear()
     */
    public void clear() {
     
    }
    
    /**
     * METHOD - void retainAll - 
     *
     * @param box
     */
    public void retainAll(Box<T> box) {
		
     
    }
    
    /**
     * METHOD - void main - 
     *
     * @param args
     */
    public static void main(String[] args) {
    	
    	Box<String> sBox = new Box<>();
    	Box<Integer> iBox = new Box<>();  
        Box<Double> dBox = new Box<>();
        Box<Character> cBox = new Box<>();
        Box<Number> nBox = new Box<>();
        Box<Object> oBox = new Box<>();

      
      sBox.add("String 1");
      sBox.add("String 2");
      iBox.add(12345);
      iBox.add(54321);
      dBox.add(123.45);
      dBox.add(543.21);
      cBox.add('a');
      cBox.add('b');
      nBox.add(12345);
      nBox.add(543.21);
      oBox.add("object1");
      oBox.add("object2");
      
      System.out.println(sBox);
      System.out.println(iBox);
      System.out.println(dBox);
      System.out.println(cBox);
      System.out.println(nBox);
      System.out.println(oBox);
      
      System.out.println();
      
      sBox.displayBox(sBox);
      iBox.displayBox(iBox);
      dBox.displayBox(dBox);
      cBox.displayBox(cBox);
      nBox.displayBox(nBox);
      oBox.displayBox(oBox);
      
      sBox.sumBox(sBox);
      iBox.sumBox(iBox);
      dBox.sumBox(dBox);
      cBox.sumBox(cBox);
      nBox.sumBox(nBox);
      oBox.sumBox(oBox);
    }

    /**
     * METHOD - Box displayBox - 
     *
     * @param box
     * @return
     */
    private Box displayBox(Box<?> box) {
    	for (Object b : box) {
    		System.out.println(b);
    	}
    	System.out.println();
    	return box;
    }
   
    /**
     * METHOD - Box sumBox - 
     *
     * @param box
     * @return
     */
    private Box sumBox(Box<?> box) {
    	Object sum = null;
    	for (Object b : box) {
    		if(b instanceof Double) 
    			sum = 0.0;
    		else if(b instanceof Integer) 
    			sum = 0.0;
    		else if (b instanceof String)
    			sum = "";
    		else if (b instanceof Character)
    			sum = "";
    		else if (b instanceof Object)
    			sum = "";
    	}
    	
    	for (Object b : box) {
    		System.out.println(b.getClass().getSimpleName());
    		if(b instanceof Integer) {
    			sum = (Double)sum + (Integer)b;
    		} else if(b instanceof Double) {
    			sum = (Double)sum + (Double)b; 
    		}  else {
    			sum = (String)sum + (String)b.toString();
    		}
    		System.out.println(sum);
    	}
    	System.out.println();
    	return box;
    }
}