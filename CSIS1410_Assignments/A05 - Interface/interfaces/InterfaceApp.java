	/*Assignment: package interfaces;
Program: InterfaceApp
Created: Feb 12, 2019
Author: Kamdon Bird
*/
/**
 * 
 */
package interfaces;

/**
 * @author Kamdon Bird
 *
 */
public class InterfaceApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//creating two instances of each shape
		Rectangle rect = new Rectangle(6,3);
		Rectangle rect2 = new Rectangle(5,4);
		Square sqr = new Square(4);
		Square sqr2 = new Square(3);
		IsoscelesRightTriangle irt = new IsoscelesRightTriangle(5);
		IsoscelesRightTriangle irt2 = new IsoscelesRightTriangle(3);
		Circle cir = new Circle(7);
		Circle cir2 = new Circle(2);
		//created an array of type shape and print
		//print Perimeter and Area of each shape
		Shape[] shapes = {rect, rect2, sqr, sqr2, irt, irt2, cir, cir2};
		for(Shape el: shapes) {
			System.out.println(el);
			//printing Perimeter
			System.out.println("Perimeter: " + (String.format("%.1f", el.perimeter())));
			//printing Area
			System.out.println("Area: " + (String.format("%.1f", el.area())));
			//if shapes is an instance of Printable then print
			if(el instanceof Printable) {
				((Printable) el).print();
			}
			System.out.println("");	
		}
		
	}

}