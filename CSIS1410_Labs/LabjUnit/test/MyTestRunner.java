/*Assignment: package labjUnit;
Program: MyTestRunner
Created: Jan 17, 2019
Author: Kamdon Bird
*/

/**
 * 
 */
package test;

/**
 * @author Kamdon Bird
 *
 */
import org.junit.runner.JUnitCore; 
import org.junit.runner.Result; 
import org.junit.runner.notification.Failure; 

public class MyTestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(AllTests.class);
		for(Failure failure : result.getFailures()) { 
			System.out.println(failure.toString()); 
		}
		System.out.printf("Number of tests run: %d%n", result.getRunCount());
		System.out.printf("Number of tests failed: %d%n", result.getFailureCount());
		System.out.printf("Number of tests passed %d%n", result.getRunCount() - result.getFailureCount());
		System.out.printf("Number of tests successful: %b%n", result.wasSuccessful());
	}
}