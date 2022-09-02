/*Assignment: package finalCode;
Program: ExerciseGeneric
Created: Apr 30, 2019
Author: %{user}
*/
package finalCode;

import java.util.*;

/**
 * @author Kamdon Bird
 *
 */
public class ExerciseGeneric {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Orginal lists:");
		List<Double> n = new ArrayList<Double>();
		n.add(1.1);
		n.add(2.2);
		n.add(3.3);
		n.add(4.4);
		n.add(5.5);
		n.add(6.6);
		System.out.println("number : " + n);
		List<Character> c = new ArrayList<Character>();
		c.add('a');
		c.add('b');
		c.add('c');
		c.add('d');
		c.add('e');
		c.add('f');
		c.add('g');
		System.out.println("letters: " + c);
		System.out.println("After removing");
		removeEveryOtherElement(n);
		removeEveryOtherElement(c);

	}

	// Methods
	/**
	 * @param list
	 */
	public static <T> void removeEveryOtherElement(List<T> list) {
		list.remove(1);
		list.remove(2);
		list.remove(3);
		System.out.println(list);
	}
}
