package m01;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * CSIS 2420 Moudle1 Test coding challenge.
 * 
 * @author starter code + Kamdon Bird
 *
 */
public class Module1Test {
	
	/**
	 * Creates an Iterable<Integer> that includes the numbers from 
	 * stack <code>stack</code> with the following modifications</p>
	 * 
	 * <ol type = "A">
	 * <li>Replaces numbers with more than one digit with 10.
	 *     (Numbers less than -9 or greater than 9 are replaced with 10) </li> 
	 * <li>Multiplies each number with 10. </li>
	 * <li>Reverses the order of the elements. </li>
	 * </ol>
	 * 
	 * Important:
	 * Calling the method challenge does NOT change the stack passed
	 * as an argument.
	 * 
	 * Examples: <br/>
	 * If stack includes 1 2 3 the method returns 30 20 10 <br/>
	 * If stack includes 10 234 -5678 99 the method returns 100 100 100 100 <br/>
	 * If stack includes 15 5 0 -3 -13 the method returns 100 -30 0 50 100 <br/>
	 * If stack includes 100 the method returns 100 <br/>
	 * If stack is empty the method returns an empty Iterable<Integer> <br/>
	 * 
	 * @param stack
	 * @return the Iterable<Integer> created based on the description
	 */
	public static Iterable<Integer> challenge(Stack<Integer> stack) {	
		Stack<Integer> s = new Stack<>();
		for (Integer e : stack) {
			if(Math.abs(e) < 9) {
				int i = e * 10;
				s.push(i);
			}else {
				s.push(100);
			}
		}
		return s;
		
	}

	/* = = = = = = = = = Test Client = = = = = = = = = */

	// The main method is for your own testing.
	// If you prefer to write JUnit tests to test your code, that's fine, too.
	
	public static void main(String[] args) {
		StdOut.println("Testing method challege(Stack<Integer> stack)");
		StdOut.println("---------------------------------------------");
		StdOut.println();
		StdOut.println("Creating new Stack and pushing items into stack");
		StdOut.println("15, 5, 0 , -3 , -13 added...");
		Stack<Integer> s = new Stack<>();
		s.push(15);
		s.push(5);
		s.push(0);
		s.push(-3);
		s.push(-13);
		StdOut.println("Current Stack: " + s);
		StdOut.println("Modified Stack: " + challenge(s));
		// expected output: -13 -3 0 5 15   => 100 50 0 -30 100
		StdOut.println();
		StdOut.println("Creating new Stack and adding nothing into stack");
		StdOut.println("nothing added...");
		Stack<Integer> s2 = new Stack<>();
		StdOut.println("Current Stack: " + s2);
		StdOut.println("Modified Stack: " + challenge(s2));
		// expected output:   =>   
		StdOut.println();
		StdOut.println("Creating new Stack and pushing items into stack");
		StdOut.println("1, -2, 3, -4, 5 added...");
		Stack<Integer> s3 = new Stack<>();
		s3.push(1);
		s3.push(-2);
		s3.push(3);
		s3.push(-4);
		s3.push(5);
		StdOut.println("Current Stack: " + s3);
		StdOut.println("Modified Stack: " + challenge(s3));
	}

}
