/* Assignment: package m05;
Program: Module05
Created: Apr 23, 2019
Author: Kamdon Bird */

// package m05
package m05;

// Imports
import java.util.*;
import java.io.*;

/** @author Kamdon Bird **/
// class Module05
public class Module05 {

	// Fields
	/** creating a List of type String storing data from Pattern.txt named list */
	static List<String> list = new ArrayList<String>();
	/** creating an path of type File to access Pattern.txt named path */
	static File path;
	/** for creating new txt documents */
	static RandomAccessFile raf;
	// Constructors
	// no constructor(s)

	// Methods
	/**
	 * @param str
	 * @return String reversed on the xAxis
	 */
	public static String xAxis(String str) {
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		sb.append('\n');
		return sb.toString();
	}

	// Main method
	/** @param args **/
	public static void main(String[] args) {
		// collecting info from txt document and saving it to an arraylist
		path = new File("C:\\Users\\Kamdon Bird\\Desktop\\CSIS1410\\Module 05 Quiz\\src\\m05\\Pattern.txt");
		String TextInfo = "Test";
		byte[] buff = null;
		try (Scanner input = new Scanner(path)) {
			while (input.hasNextLine()) {
				list.add(input.nextLine());
			}
			// creating pattern1.txt file and reflection across the x-axis
			raf = new RandomAccessFile("Pattern1.txt", "rw");
			for (String el : list) {
				TextInfo = el.toString() + xAxis(el).toString();
				buff = TextInfo.getBytes();
				raf.write(buff);
			}
			// Creating pattern2.txt file and reflection across the y-axis
			raf = new RandomAccessFile("Pattern2.txt", "rw");
			for (String el : list) {
				TextInfo = el.toString() + "\n";
				buff = TextInfo.getBytes();
				raf.write(buff);
			}
			for (int i = list.size() - 1; i >= 0; i--) {
				TextInfo = list.get(i).toString() + "\n";
				buff = TextInfo.getBytes();
				raf.write(buff);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
