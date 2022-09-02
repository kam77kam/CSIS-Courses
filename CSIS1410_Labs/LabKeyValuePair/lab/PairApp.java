/*Assignment: package labkeyvaluepair;
Program: PairApp
Created: Mar 28, 2019
Author: Kamdon Bird
 */
/**
 * 
 */
package lab;

/**
 * @author Kamdon Bird
 *
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PairApp {

	public static void main(String[] args) {
		LabKeyValuePair p1 = new LabKeyValuePair("SLC", 189899);
		LabKeyValuePair p2 = new LabKeyValuePair("NY", 8244910);
		LabKeyValuePair p3 = new LabKeyValuePair("LA", 3819702);
		LabKeyValuePair p4 = new LabKeyValuePair("SF", 812826);

		List<LabKeyValuePair> cities = new ArrayList<>();
		cities.add(p1);
		cities.add(p2);
		cities.add(p3);
		cities.add(p4);

		System.out.println("p1:" + p1);
		System.out.println("p2:" + p2);
		System.out.print("p1.equals(p2)): " + p1.equals(p2));
		
		p1 = p2;
		System.out.println("\np1: " + p1);
		System.out.println("\np1: " + p1);
		System.out.print("p1.equals(p2)): " + p1.equals(p2));
	}
}