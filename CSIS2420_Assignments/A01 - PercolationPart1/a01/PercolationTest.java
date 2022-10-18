/*
 * @author Kamdon Bird
 * Class: CSIS 2420
 * Created: 9/12/2022
 * Assignment: A01 - Percolation
 */

package a01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PercolationTest {

	@Test
	void testPercolationConstructor() {
		a01.Percolation p2 = new a01.Percolation(2);
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				assertFalse(p2.isOpen(i, j));
			}
		}
	}
//	@Test
//	void () {
//		fail("Not yet implemented");
//	}
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

}
