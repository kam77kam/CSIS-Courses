package a04;

/**
 * The MyFractal class demonstrates the creation of a custom fractal using
 * recursion and StdDraw. The fractal consists of filled rectangles arranged in
 * a tree-like structure.
 * 
 * @author Kamdon Bird
 */

public class MyFractal {

	/**
	 * Recursively draws a tree-like fractal made of filled rectangles.
	 *
	 * @param n    The order of the fractal (number of recursions)
	 * @param x    The x-coordinate of the current center of the rectangle.
	 * @param y    The y-coordinate of the current center of the rectangle.
	 * @param size The current size of the rectangle.
	 */
	public static void drawFractal(int n, double x, double y, double size) {
		if (n == 0) return;

		// Filled rectangle at (x, y) with given size
		StdDraw.filledRectangle(x, y, size / 2, size / 2);

		// Recursively drawing smaller rectangles
	    drawFractal(n - 1, x - size / 2, y + size, size / 2);
	    drawFractal(n - 1, x + size / 2, y + size, size / 2);
	    drawFractal(n - 1, x - size, y, size / 2);
	    drawFractal(n - 1, x + size, y, size / 2);
	    drawFractal(n - 1, x - size / 2, y - size, size / 2);
	    drawFractal(n - 1, x + size / 2, y - size, size / 2);
	}

//------------------TEST CLIENT-------------------//
	public static void main(String[] args) {

		for (int n = 1; n <= 6; n++) {
			// Drawing MyFractal
			StdDraw.setPenColor(StdDraw.BOOK_BLUE);
			drawFractal(n, 0.5, 0.5, 0.25);
			StdDraw.pause(3000);
		}
	}
}
