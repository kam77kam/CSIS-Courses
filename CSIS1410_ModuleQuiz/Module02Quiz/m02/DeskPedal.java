/*Assignment: package module02;
Program: DeskPedal
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
public class DeskPedal {
	/**
	 * String color for pedal
	 */
	private String color;
	
	/**
	 * @param color
	 */
	public DeskPedal(String color) {
		this.color = color;
	}
	
	/**
	 * @return color of pedal
	 */
	public String getColor() {
		return color;
	}
	/**
	 * 
	 */
	public void pedal() {
		System.out.println("pedaling..");
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return color + " " + super.getClass().getSimpleName();
	}
	
}
