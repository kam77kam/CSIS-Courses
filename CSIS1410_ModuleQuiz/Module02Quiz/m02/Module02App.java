/*Assignment: package module02;
Program: Module02App
Created: Feb 26, 2019
Author: Kamdon Bird
*/
/**
 * 
 */
package m02;

/**
 * @author Kamdon Bird
 *
 */
public class Module02App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//creating instance of DeskPedal called deskPedal1
		DeskPedal deskPedal1 = new DeskPedal("blue");
		System.out.println("deskPedal1: " + deskPedal1.toString());
		deskPedal1.pedal();
		System.out.println();
		
		//creating instance of DeskPedalPlus called deskPedal2
		DeskPedalPlus deskPedal2 = new DeskPedalPlus("blue");
		System.out.println("deskPedal2: " + deskPedal2.toString());
		deskPedal2.printReport();
		//adding 60 minutes then reprint
		deskPedal2.pedal();
		deskPedal2.pedal();
		deskPedal2.pedal();
		deskPedal2.pedal();
		System.out.println("deskPedal2: " + deskPedal2.toString());
		deskPedal2.printReport();
		deskPedal2.pedal();
		//adding 15 minutes then reprint
		System.out.println("deskPedal2: " + deskPedal2.toString());
		deskPedal2.printReport();
		//reset to time to zero then print
		deskPedal2.reset();
		System.out.println("deskPedal2: " + deskPedal2.toString());
		
	}

}
