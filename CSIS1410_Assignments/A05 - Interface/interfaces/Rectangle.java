/*Assignment: package inheritance A04;
Course: CSIS-1410
Program: Rectangle
Created: Feb 7, 2019
Author: Kamdon Bird
*/
package interfaces;

/**
 * @author Kamdon Bird
 *
 */
public class Rectangle implements Shape, Printable {
	
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
	public Rectangle (int length, int width) {
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

	@Override
	public void print() {
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < length; j++) {
				if(i == 0 || i == width - 1 || j == 0 || j ==length-1) {
					System.out.print("o ");
				}else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

	@Override
	public double perimeter() {
		return ((getLength()*2)+ getWidth()*2);
	}

	@Override
	public double area() {
		return (getLength()*getWidth());
	}	
}