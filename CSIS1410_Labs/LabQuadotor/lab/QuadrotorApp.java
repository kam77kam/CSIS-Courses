/*Assignment: LabQuadrotor
Program: QuadrotorApp
Created: Mar 12, 2019
Author: Kamdon Bird
*/
package lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrotorApp {

	public static void main(String[] args) {
		
		Quadrotor searchItem = new Quadrotor(4, 6, 4);
		//array rotor is promoted to arraylist type
		List<Quadrotor> rotors = new ArrayList<>(Arrays.asList(
				new Quadrotor(2, 4, 2), 
				new Quadrotor(3, 4, 4), 
				new Quadrotor(4, 4, 6),    
				new Quadrotor(5, 4, 2), 
				new Quadrotor(6, 4, 4), 
				new Quadrotor(7, 4, 6)));
		System.out.println(rotors);
		
		//changes values and prints the new rotors
		changeOrientation(rotors);
		System.out.println(rotors);
		
		//compares rotors element object to searchItem parameters
		System.out.printf("rotors does %scontain %s%n", rotors.contains(searchItem) ? "" : "not ", searchItem);
		System.out.printf("Number of rotors %s%n", rotors.size());
		
		//removed searchItem and print
		rotors.remove(searchItem);
		System.out.println(rotors);
		//removed index 0
		rotors.remove(0);
		System.out.println(rotors);
	}
	public static void changeOrientation(List<Quadrotor> list) {
		for(Quadrotor q: list) {
			int temp = q.getX();
			q.setX(q.getY());
			q.setY(temp);
		}
	}
	
}
