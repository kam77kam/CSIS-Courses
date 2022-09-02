/*Assignment: package inheritance A04;
Course: CSIS-1410
Program: InheritanceApp
Created: Feb 7, 2019
Author: Kamdon Bird
*/
package inheritance;

import java.util.ArrayList;

/**
 * @author Kamdon Bird
 *
 */
public class InheritanceApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//creating objects
		Rectangle myRectangle = new Rectangle(4,5);
		Square mySquare = new Square(4);
		IsoscelesRightTriangle myIsoselesRightTriangle = new IsoscelesRightTriangle(5);
		Circle myCircle = new Circle(4);
		//printing objects
		System.out.println(myRectangle);
		System.out.printf("Length: %d\nWidth: %d\n\n", myRectangle.getLength(), myRectangle.getWidth());
		
		System.out.println(mySquare);
		System.out.printf("Side: %d\n\n", mySquare.getSide());
		
		System.out.println(myIsoselesRightTriangle);
		System.out.printf("Leg: %d\nHypotenuse: %.1f\n\n", myIsoselesRightTriangle.getLeg(), myIsoselesRightTriangle.getHypotenuse());
		
		System.out.println(myCircle);
		System.out.printf("Diameter: %d\nCircumference: %.1f\nRadius: %d\n\n", myCircle.getDiameter(), myCircle.getCircumference(), myCircle.getRadius());
		
		Rectangle rectangle2 = mySquare;
		System.out.println("rectangle2:\n-----------");
		System.out.printf("Square (%d)\nLength: %d\nWidth: %d\n\n", mySquare.getSide(),rectangle2.getLength(),rectangle2.getWidth());
		
		System.out.println("Rectangle Array:\n----------------");
		ArrayList<Rectangle> rectangles = new ArrayList<>();
		rectangles.add(rectangle2);
		rectangles.add(mySquare);
		rectangles.add(myRectangle);
		for(Rectangle el: rectangles){
			System.out.println(el.toString());
			System.out.print("Length: ");
			System.out.println(el.getLength());
			System.out.print("Width: ");
			System.out.println(el.getWidth());
			System.out.println();
		}
	}

}
