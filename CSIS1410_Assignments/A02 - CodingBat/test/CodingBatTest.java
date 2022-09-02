/*Assignment: package test;
Program: CodingBatTest
Created: Jan 24, 2019
Author: Kamdon Bird
*/
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import a02.CodingBat;

/**
 * @author Kamdon Bird
 *
 */
class CodingBatTest {

	/**
	 * 
	 */
	CodingBat tester = new CodingBat();
	
	/**
	 * 
	 */
	@Test
	void test() {
		assertEquals("zpXzp", tester.zipZap("zipXzap"));
	}
	/**
	 * 
	 */
	@Test
	void test2() {
		assertEquals("zpzp", tester.zipZap("zopzop"));
	}
	/**
	 * 
	 */
	@Test
	void test3() {
		assertEquals("zzzpzp", tester.zipZap("zzzopzop"));
	}
	/**
	 * 
	 */
	@Test
	void test4() {
		assertEquals("zibzp", tester.zipZap("zibzap"));
	}
	/**
	 * 
	 */
	@Test
	void test5() {
		assertEquals("zp", tester.zipZap("zip"));
	}
	/**
	 * 
	 */
	@Test
	void test6() {
		assertEquals("zi", tester.zipZap("zi"));
	}
	/**
	 * 
	 */
	@Test
	void test7() {
		assertEquals("z", tester.zipZap("z"));
	}
	/**
	 * 
	 */
	@Test
	void test8() {
		assertEquals("", tester.zipZap(""));
	}
	/**
	 * 
	 */
	@Test
	void test9() {
		assertEquals("zp", tester.zipZap("zzp"));
	}
	/**
	 * 
	 */
	@Test
	void test10() {
		assertEquals("abcppp", tester.zipZap("abcppp"));
	}
	/**
	 * 
	 */
	@Test
	void test11() {
		assertEquals("azbcppp", tester.zipZap("azbcppp"));
	}
	/**
	 * 
	 */
	@Test
	void test12() {
		assertEquals("azbcpzp", tester.zipZap("azbcpzpp"));
	}
	
}
