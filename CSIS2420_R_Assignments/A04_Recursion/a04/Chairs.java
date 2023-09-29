package a04;

import edu.princeton.cs.algs4.StdDraw;

/**
 * @author Kamdon Bird
 * This is a simulation of a Fractal tree generator
 * Plots an order n h-tree. "h" = 2d image of a chair
 */
public class Chairs {

	// plot an h, centered on (x, y) of the given side length
	public static void drawLowerCaseH(double x, double y, double size) {

		// compute the coordinates of the 4 needed tips of the h (in this case, its a
		// capital h. "H")
		double x0 = x - size / 2;
		double x1 = x + size / 2;
		double y0 = y - size / 2;
		double y1 = y + size / 2;

		// draw the 3 line segments of the h
		StdDraw.line(x0, y0, x0, y1); // left vertical segment of the h
		StdDraw.line(x1, y0, x1, y); // right vertical segment of the h
		StdDraw.line(x0, y, x1, y); // connect the two vertical segments of the h
	}

	// plot an order n H-tree, centered on (x, y) of the given side length
	public static void draw(int n, double x, double y, double size) {
		if (n == 0) return;
		drawLowerCaseH(x, y, size);

		// compute x- and y-coordinates of the 4 half-size H-trees
		double x0 = x - size / 2;
		double x1 = x + size / 2;
		double y0 = y - size / 2;
		double y1 = y + size / 2;

		// recursively draw 4 half-size H-trees of order n-1
		draw(n - 1, x0, y0, size / 2); // lower left H-tree
		draw(n - 1, x0, y1, size / 2); // upper left H-tree
		draw(n - 1, x1, y0, size / 2); // lower right H-tree
		draw(n - 1, x1, y1, size / 2); // upper right H-tree
	}

	// reads an integer command-line argument n and plots an order n H-tree
	public static void main(String[] args) {

		double x = 0.5, y = 0.5; // center of H-tree
		double size = 0.5; // side length of H-tree

		for (int n = 0; n <= 3; n++) {
			draw(n, x, y, size);
			StdDraw.pause(2000);
		}
	}
}
