/*Assignment: package inheritance A04;
Course: CSIS-1410
Program: Circle
Created: Feb 7, 2019
Author: Kamdon Bird
*/
package interfaces;

/**
 * @author Kamdon Bird
 *
 */
public class Circle implements Shape{
	/**
	 * final radius
	 */
	private final int radius;
	
	/**
	 * @param radius
	 */
	public Circle(int radius) {
		this.radius = radius;
	}
	/**
	 * @return diameter
	 */
	public int getDiameter() {
		return 2 * radius;
	}
	/**
	 * @return circumference
	 */
	public double getCircumference() {
		 return 2 * Math.PI * radius;
	}
	/**
	 * @return radius
	 */
	public int getRadius() {
		return radius;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Circle(%d)", radius);
	}
	@Override
	public double perimeter() {
		return (2*Math.PI*getRadius());
	}
	@Override
	public double area() {
		return (Math.PI*Math.pow(radius, 2));
	}
}