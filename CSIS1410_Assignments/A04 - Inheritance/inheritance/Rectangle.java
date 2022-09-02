/*Assignment: package inheritance A04;
Course: CSIS-1410
Program: Rectangle
Created: Feb 7, 2019
Author: Kamdon Bird
*/
package inheritance;

/**
 * @author Kamdon Bird
 *
 */
public class Rectangle {
	
	/**
	 * side of a rectangle called width
	 */
	private final int width;
	/**
	 * side of a rectangle called length
	 */
	private final int length;
	
	/**
	 * @param width
	 * @param length
	 */
	public Rectangle (int width, int length) {
		this.width = width;
		this.length = length;
	}

	/**
	 * @return width of Rectangle
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return length of Rectangle
	 */
	public int getLength() {
		return length;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Rectangle(" + length + "x" + width + ")";
	}
	
	
}
