/*Assignment: package m04;
Program: Module04
Created: Apr 11, 2019
Author: Kamdon Bird
*/
package m04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Kamdon Bird
 *
 */
public class Module04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		demoCollection();
	}

	/**
	 * 
	 */
	private static void demoCollection() {
		List<Double> numbers = new ArrayList<Double>();
		//numbers
		numbers.add((double) 1 / 5);
		numbers.add((double) 2 / 5);
		numbers.add((double) 3 / 5);
		numbers.add((double) 1 / 4);
		numbers.add((double) 1 / 2);
		numbers.add((double) 3 / 4);
		System.out.println("numbers: " + numbers);

		numbers.add((double) 2 * 1 / 5);
		numbers.add((double) 2 * 2 / 5);
		numbers.add((double) 2 * 3 / 5);
		numbers.add((double) 2 * 1 / 4);
		numbers.add((double) 2 * 1 / 2);
		numbers.add((double) 2 * 3 / 4);
		Collections.sort(numbers);   //found on zybooks
		System.out.println("numbers: " + numbers);
		
		for(int i = 0; i < numbers.size(); i++) {
			numbers.set(i, numbers.get(i)*100);
		}
		System.out.println("numbers: " + numbers);
		System.out.println();
		
		//hexNumbers
		List<String> hexNumbers = new ArrayList<String>(); 
		for(int i = 0; i < numbers.size(); i++) {
			hexNumbers.add(numbers.get(i).toHexString(numbers.get(i)));
		}
		System.out.println("hexNumbers: " + hexNumbers);
		
		//remove duplicated values
		Set<String> hexSet = new HashSet<>();
		for(int i = 0; i < hexNumbers.size(); i++) {
			hexSet.add(hexNumbers.get(i));
		}
		System.out.println("hexNumbers: " + hexSet);
		System.out.println();
	}
}
