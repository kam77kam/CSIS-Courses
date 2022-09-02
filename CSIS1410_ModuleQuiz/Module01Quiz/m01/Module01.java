/*Assignment: package m01;
Program: Module01
Created: Jan 31, 2019
Author: Kamdon Bird
*/

/**
 * 
 */
package m01;

/**
 * @author Kamdon Bird
 *
 */
public class Module01 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	/**
	 * @param word
	 * @return word if null or blank string if neither returns sb1
	 */
	public static String transform(String word) {
		StringBuilder sb1 = new StringBuilder();
		if(word == "null" || word == "") {
			return word;
		}else {
			String newWord1 = word.replace("'", "");
			String newWord2 = newWord1.replace("-", "");
			String newWord3 = newWord2.replace("a", "A");
			String newWord4 = newWord3.replace("b", "B");
			String newWord5 = newWord4.replace("y", "Y");
			String newWord6 = newWord5.replace("z", "Z");
			StringBuilder sb = new StringBuilder(newWord6);
			sb1 = new StringBuilder(sb);
			sb1.reverse();
			sb1.append("_" + sb);
			 	
			}
		
		return sb1.toString();
	}
}
