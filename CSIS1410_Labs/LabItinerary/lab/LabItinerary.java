/*Assignment: package labItinerary;
Program: LabItinerary
Created: Jan 15, 2019
Author: %{user}
*/
/**
 * 
 */
package lab;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Kamdon Bird
 *
 */
class LabItinerary {
	public static void main(String args[]) {
		//creating an arraylist named itinerary
		ArrayList<String> itinerary = new ArrayList<>();
		//creating user input for user
		Scanner input = new Scanner(System.in);
		boolean done = false;
		String dest = null;
		while(!done) {
			System.out.print("Destination: ");
			dest = input.nextLine();
			if (dest.equalsIgnoreCase("done")) {
				done = true;
			} else {
				itinerary.add(dest);
			}

		}
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for(String s : itinerary) {
			if(!first) {
				sb.append(" to ").append(s.toUpperCase());
			} else {
				sb.append(s.toUpperCase());
				first = false;
			}
		}
		String travelRoute = sb.toString();
		
		System.out.println("travel route:");
		System.out.println(travelRoute);
	}

	
}
