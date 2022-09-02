	/*Assignment: package labPrintTimeTables;
Program: LabPrintTimeTables
Created: Apr 18, 2019
Author: Kamdon Bird
 */
package lab;

import java.io.*;

public class LabPrintTimeTables {

	public static void main(String[] args) {
		String filename = "TimeTables.txt";
		try (PrintWriter writer = new PrintWriter(new File(filename))) {
			writer.println("Time Tables:");
			writer.println();
			for(int i = 1; i < 11; i+=2) {
				for(int j = 1; j < 11; j++) {
					writer.printf("%2d * %2d = %-3d", j, i, j*i);
					writer.printf("\t%2d * %2d = %-3d%n", j, i+1, j*(i+1));
				}
				writer.println();
			}

		} catch (FileNotFoundException e) {
			System.err.println("File does not exist");
		}
	}
}