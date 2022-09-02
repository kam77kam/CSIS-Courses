/*Assignment: package a03;
Program: CodingBat
Created: Jan 23, 2019
Author: Kamdon Bird
*/
package a02;

/**
 * @author Kamdon Bird
 *
 */
public class CodingBat {

	/**
	 * @param str
	 * @return "result"
	 */
	public String zipZap(String str) {
		StringBuilder sb = new StringBuilder(str);
		for (int i = 0; i < sb.length() - 2; i++) {
			if (sb.charAt(i) == 'z' && sb.charAt(i + 2) == 'p') {
				sb.deleteCharAt(i + 1);
			}
		}

		String result = sb.toString();
		return result;
	}
}