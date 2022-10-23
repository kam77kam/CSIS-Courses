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
		int count = 0;
		Percolation p2 = new Percolation(2);
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				if(!p2.isOpen(i, j)) count++;
			}
		}
		assertEquals(4, count);
	}
	
	@Test
	void testOpen() {
		int count = 0;
		Percolation p2 = new Percolation(2);
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				p2.open(i, j);
				if(p2.isOpen(i, j)) count++;
			}
		}
		assertEquals(4, count);
	}
	
	@Test
	void testOutOfRangeGridSize() {
		Percolation p2 = new Percolation(2);
		assertThrows(Exception.class, () -> {
			p2.isOpen(2 + 1, 2 + 1);
		}
		);
	}
	
	@Test
	void testIsOpen() {
		Percolation p2 = new Percolation(2);
		assertFalse(p2.isOpen(0, 0));
		p2.open(0, 0);
		assertTrue(p2.isOpen(0, 0));
	}
	@Test
	void testVerifyRange() {
		Percolation p2 = new Percolation(2);
		assertThrows(java.lang.IllegalArgumentException.class,() -> {
			p2.verifyRange(-1, -1);
		});
	}
	
	@Test
	void testIsFull_00() {
		Percolation p4 = new Percolation(4);
		p4.open(0, 0);
		assertTrue(p4.isFull(0, 0));
	}
	
	@Test
	void testPercolationWithNoSitesOpened() {
		Percolation p2 = new Percolation(2);
		assertFalse(p2.percolates());
	}
	
	@Test
	void testPercolates() {
		Percolation p2 = new Percolation(2);
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				p2.open(i, j);
			}
		}
		assertTrue(p2.percolates());
	}
	
	@Test
	void testIsNotFull() {
		Percolation p2 = new Percolation(2);
		assertFalse(p2.isFull(0, 0));
	}
	
	@Test
	void testIsNotOpen() {
		Percolation p2 = new Percolation(2);
		assertFalse(p2.isOpen(0, 0));
	}
	
}