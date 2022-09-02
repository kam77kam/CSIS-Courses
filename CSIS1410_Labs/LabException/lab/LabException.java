/*  Assignment: LabExceptionlabexception
 	Program: LabException
	Created: Apr 16, 2019
	Author: Kamdon Bird
*/
package lab;

import java.util.Scanner;

/**
 * @author Kamdon Bird
 *
 */
public class LabException {
	static Scanner input = new Scanner(System.in);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int digit = numberFromUser();
		int result = sevenModulusN(digit);
		System.out.printf("7 %% %d = %d", digit, result);
	}

	/**
	 * @return
	 */
	private static int numberFromUser() {
		boolean valid = false;
		int num = 0;
		do {
			try {
				System.out.print("number: ");
				num = input.nextInt();
				if (num == 0) {
					throw new IllegalArgumentException();
				}
				valid = true;
				return num;
			} catch (IllegalArgumentException e) {
				System.out.println("Cannot divide by zero yo!");
				// e.printStackTrace();
			} catch (Exception e) {
				System.out.println("Exception has been caught");
				// e.printStackTrace();
			} finally {
				System.out.println("finally block always runs");
				input.nextLine();
			}

		} while (!valid);
		return num;
	}

	/**
	 * @param number
	 * @return
	 */
	private static int sevenModulusN(int number) {
		return 7 % number;
	}
}
/*
Reading text from file
writing txt to file
motifing 
displaying txt to screen
serialize and deSerialize a list of random numbers
order in sequence and unorder(shuffle)
working with generics
create lists and removing certain items from list of type T
*/


