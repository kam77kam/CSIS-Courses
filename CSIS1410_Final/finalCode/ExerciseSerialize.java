/*Assignment: package finalCode;
Program: ExerciseSerialize
Created: Apr 30, 2019
Author: %{user}
*/
/**
 * 
 */
package finalCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

/**
 * @author Kamdon Bird
 *
 */
public class ExerciseSerialize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Random rand = new Random();
		for (int j = 1; j <= 2; j++) {
			for (int i = 0; i < 10; i++) {
				int temp = rand.nextInt(i+1) * 5 + 10;
				list.add(temp);
			}
		}
		System.out.println("numbers : " + list);
		Collections.sort(list);
		System.out.println("numbers2: " + list);
		File path = new File("NumberList.ser");
		String TextInfo = "";
		byte[] buff = null;
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile(path, "rw");
			for (Integer el : list) {
				TextInfo = el.toString() + "\n";
				buff = TextInfo.getBytes();
				raf.write(buff);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
