/*Assignment: package inheritance A04;
Course: CSIS-1410
Program: IsoscelesRightTriangle
Created: Feb 7, 2019
Author: Kamdon Bird
 */
package interfaces;

/**
 * @author Kamdon Bird
 *
 */
public class IsoscelesRightTriangle implements Shape, Printable{

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
	@Override
	public void print() {
		for(int i = 0; i < leg; i++) {
			for(int j = 0; j < leg; j++) {
				if(j == 0 || i == leg - 1 || i == j)
					System.out.print("o ");
				else
					System.out.print("  ");
			}
			System.out.println("");
		}
	}
	@Override
	public double perimeter() {
		return (getLeg() + getLeg() + getHypotenuse());
	}
	@Override
	public double area() {
		return (Math.pow(getLeg(), 2)/2);
	}
}