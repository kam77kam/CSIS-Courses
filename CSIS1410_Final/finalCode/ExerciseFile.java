/*Assignment: package finalCode;
Program: ExerciseFile
Created: Apr 30, 2019
Author: Kamdon Bird
*/
/**
 * 
 */
package finalCode;

import java.io.*;
import java.util.*;

/**
 * @author Kamdon Bird
 *
 */
public class ExerciseFile {
	// FIELDS
	/**
	 * static list created to hold the contents of path
	 */
	static List<String> list = new ArrayList<String>();
	/**
	 * Scanneer for input character
	 */
	static Scanner input = new Scanner(System.in);
	/**
	 * location where to find src file
	 */
	static File path = new File("Diamond.txt");

	// CONSTRUCTORS

	// METHODS

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner dir = new Scanner(path)) {
			while (dir.hasNextLine()) {
				list.add(dir.nextLine());
			}
			System.out.println("Enter a Character:");
			// to hold the character and or string
			String temp = input.nextLine();
			RandomAccessFile raf = new RandomAccessFile("Diamond2.txt", "rw");
			for (String el : list) {
				StringBuilder sb = new StringBuilder(el); // converting el of list into StringBuilder
				int nTemp = 0;
				// while index doesn't have an 'x' after updating after the current 'x', x will be changed to whatever input(yourself) wants
				while (sb.indexOf("x", nTemp) != -1) {
					nTemp = sb.indexOf("x");
					sb.deleteCharAt(nTemp);
					sb.insert(nTemp, temp);
					nTemp++;
				}
				String TextInfo = sb.toString() + "\n";
				// need byte array to get the bytes needed to print into a text document
				byte[] buff = TextInfo.getBytes();
				raf.write(buff);
			}
			input.close(); // for closing input leak
			raf.close(); // for closing raf leak
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
