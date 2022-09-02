/*Assignment: package m01; 	
Program: Module01test
Created: Jan 31, 2019
Author: Kamdon Bird
*/
package tests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import m01.Module01;

public class Module01test {

	@Test
	void testWord1() {
		Module01 tester = new Module01();
		assertEquals("reBrAB_BArBer", tester.transform("barber"));
		System.out.println();
	}
	@Test
	void testWord2() {
		Module01 tester = new Module01();
		assertEquals("ABuYA_AYuBA", tester.transform("Ay--uba"));
		System.out.println();
	}
	@Test
	void testWord3() {
		Module01 tester = new Module01();
		assertEquals("YAlC_ClAY", tester.transform("Clay"));
		System.out.println();
	}
	@Test
	void testWord4() {
		Module01 tester = new Module01();
		assertEquals("ZZuB_BuZZ", tester.transform("buzz"));
		System.out.println();
	}
	@Test
	void testWord5() {
		Module01 tester = new Module01();
		assertEquals("null", tester.transform("null"));
		System.out.println();
	}
}
