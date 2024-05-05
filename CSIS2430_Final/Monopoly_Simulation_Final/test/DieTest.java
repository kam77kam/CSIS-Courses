package test;

import src.Die;
import static org.junit.Assert.*;
import org.junit.Test;

public class DieTest {

	// Test the roll method to ensure it returns a valid result.
	@Test
	public void roll_6SidedDie_ReturnNumberBetween1and6() {
		Die die = new Die();

		// Roll the die multiple times and ensure the result is between 1 and 6.
		for (int i = 0; i < 1000; i++) {
			int result = die.roll();
			assertTrue(result >= 1 && result <= 6);
		}
	}

	// Test until the die can roll a 1.
	@Test
	public void roll_CanReturn1() {
		Die die = new Die();

		int result = 0;
		while (result != 1) {
			result = die.roll();
		}
		assertEquals(1, result);
	}

	// Test until the die can roll a 6.
	@Test
	public void roll_CanReturn6() {
		Die die = new Die();

		int result = 0;
		while (result != 6) {
			result = die.roll();
		}
		assertEquals(6, result);
	}
}
