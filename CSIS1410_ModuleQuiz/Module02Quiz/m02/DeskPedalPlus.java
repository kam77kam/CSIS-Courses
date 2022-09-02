/*Assignment: package module02;
Program: DeskPedalPlus
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
public class DeskPedalPlus extends DeskPedal{
	
	/**
	 * counting the number of minutes
	 */
	private int counter;
	/**
	 * int time for pedal
	 */
	private int time;
	
	/**
	 * @param color
	 */
	 public DeskPedalPlus(String color) {
		super(color);
	}
	
	/**
	 * 
	 */
	public void pedal() {
		super.pedal();
		time = time + 15;
	}
	
	/**
	 * 
	 */
	public void reset() {
		time = 0;	
	}
	
	/**
	 * 
	 */
	public void printReport(){
		System.out.print("Total time pedaled: ");
		if(time > 59) {
			System.out.print(time/60 + "\' ");
			counter = time%60;
			if(counter != 0) {
				System.out.print(counter + "\"");
			}
		}else if(counter == 0) {
				System.out.print("0\"");
			} 
		System.out.println();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.getColor() + " " + super.getClass().getSimpleName() + " " + time + " min";
	}
}