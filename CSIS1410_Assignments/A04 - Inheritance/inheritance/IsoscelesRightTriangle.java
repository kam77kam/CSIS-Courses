/*Assignment: package inheritance A04;
Course: CSIS-1410
Program: IsoscelesRightTriangle
Created: Feb 7, 2019
Author: Kamdon Bird
*/
package inheritance;

/**
 * @author Kamdon Bird
 *
 */
public class IsoscelesRightTriangle {
	
	/**
	 * initalizes leg for hypotenuse
	 */
	private int leg;
	
	/**
	 * @param leg
	 */
	public IsoscelesRightTriangle(int leg) {
		this.leg = leg;
	}
	/**
	 * @return leg
	 */
	public double getHypotenuse () {
		return Math.sqrt(2*Math.pow(leg, 2));
	}
	/**
	 * @return leg
	 */
	public int getLeg() {
		return leg;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IsoscelesRightTriangle(" + leg + ")";
	}
}
