/*Assignment: package labjUnit;
Program: LabjUnitTest
Created: Jan 17, 2019
Author: Kamdon Bird
*/
package test;

import static org.junit.Assert.*;
import org.junit.Test;

public class LabjUnitTest {

	@Test
	public void testMultiply() {
		lab.LabjUnit tester = new lab.LabjUnit();
		assertEquals("Result", 50, tester.multiply(10,5));
	}
}
