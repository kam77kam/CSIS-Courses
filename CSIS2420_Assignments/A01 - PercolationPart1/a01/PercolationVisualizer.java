package a01;

import java.awt.Font;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

public class PercolationVisualizer {

    // delay in milliseconds (controls animation speed)
    private final static int DELAY = 0; // 100;
	private static final int DELAY_BETWEEN_FILES = 5000;

    // draw N-by-N percolation system
    public static void draw(a01.Percolation perc, int N) {
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setXscale(-.05*N, 1.05*N);
        StdDraw.setYscale(-.05*N, 1.05*N);   // leave a border to write text
        StdDraw.filledSquare(N/2.0, N/2.0, N/2.0);

        // draw N-by-N grid
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (perc.isFull(row, col)) {
                    StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                }
                else if (perc.isOpen(row, col)) {
                    StdDraw.setPenColor(StdDraw.WHITE);
                }
                else {
                    StdDraw.setPenColor(StdDraw.BLACK);
                }
                StdDraw.filledSquare(col + 0.5, N - row - 0.5, 0.45);
            }
        }

        // write status text
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 12));
        StdDraw.setPenColor(StdDraw.BLACK);
        //StdDraw.text(.25*N, -N*.025, perc.numberOfOpenSites() + " open sites");
        if (perc.percolates()) StdDraw.text(.75*N, -N*.025, "percolates");
        else                   StdDraw.text(.75*N, -N*.025, "does not percolate");

    }

    private static void simulateFromFile(String filename) {
        In in = new In(filename);
        int N = in.readInt();
        Percolation perc = new Percolation(N);

        // turn on animation mode
        StdDraw.enableDoubleBuffering();

        // repeatedly read in sites to open and draw resulting system
        draw(perc, N);
        StdDraw.show();
        StdDraw.pause(DELAY);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
            draw(perc, N);
            StdDraw.show();
            StdDraw.pause(DELAY);
        }
        StdDraw.pause(DELAY_BETWEEN_FILES);
    }

    public static void main(String[] args) throws InterruptedException {
        String[] fileNames = {
           // TODO add input files to test with - e.g. Input10.txt
        };
        
        for (String filename : fileNames) {
        	simulateFromFile(filename);
        	StdDraw.pause(1000); // pause for 2 seconds
        }
        
        System.out.println("done");
    }
}