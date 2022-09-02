/*Assignment: package inheritance A04;
Course: CSIS-1410
Program: Square
Created: Feb 7, 2019
Author: Kamdon Bird
*/
package inheritance;

/**
 * @author Kamdon Bird
 *
 */
public class Square extends Rectangle {

	/**
	 * @param length
	 */
	public Square(int length) {
		super(length, length);
	}
	/**
	 * @return length
	 */
	public int getSide() {
		return super.getLength();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Square(" + super.getLength() + ")";
	}
	

}
