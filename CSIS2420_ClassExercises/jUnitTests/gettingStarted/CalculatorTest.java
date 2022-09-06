package gettingStarted;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void add_positiveNumbers() {
		assertEquals(
				"\nCalculator.add(2, 3) should return 5.",
				5, Calculator.add(2, 3));
	}
	
	@Test
	public void add_negativeNumbers() {
		assertEquals(
				"\nCalculator.add(-2, -4) should return -6.",
				-6, Calculator.add(-2, -4));
	}	
	
	@Test
	public void add_positiveAndNegativeNumbers() {
		assertEquals(
				"\nCalculator.add(2, -4) should return -2.",
				-2, Calculator.add(2, -4));
	}
	
	@Test
	public void add_zeros() {
		assertEquals(
				"\nCalculator.add(0, 0) should return 0.",
				0, Calculator.add(0, 0));
	}
	
	// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = 
			
	@Test
	public void subtract_positiveNumbers_positiveDifference() {
		assertEquals(
				"\nCalculator.subtract(12, 3) should return 9.",
				9, Calculator.subtract(12, 3));
	}
	
	@Test
	public void subtract_positiveNumbers_negativeDifference() {
	assertEquals(
			"\nCalculator.subtract(2, 3) should return -1.",
			-1, Calculator.subtract(2, 3));
	}

	@Test
	public void subtract_negativeNumbers_positiveDifference() {
		assertEquals(
				"\nCalculator.subtract(-2, -4) should return 2.",
				2, Calculator.subtract(-2, -4));
	}	

	@Test
	public void subtract_negativeNumbers_negativeDifference() {
		assertEquals(
				"\nCalculator.subtract(-7, -4) should return -3.",
				-3, Calculator.subtract(-7, -4));
	}
	
	@Test
	public void subtract_equalArguments_zeroDifference() {
		assertEquals(
				"\nCalculator.subtract(2, 2) should return 0.",
				0, Calculator.subtract(2, 2));
	}
	
	@Test
	public void subtract_zeros() {
		assertEquals( 
				"\nCalculator.subtract(0, 0) should return 0.",
				0, Calculator.subtract(0, 0));
	}
	
	// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = 

	@Test
	public void abs_positiveNumber() {
		assertEquals(
				"\nThe absolute value of 5 should be 5.",
				5, Calculator.abs(5));
	}

	@Test
	public void abs_negativeNumber() {
		assertEquals(
				"\nThe absolute value of -15 should be 15.",
				15, Calculator.abs(-15));
	}

	@Test
	public void abs_zero() {
		assertEquals(
				"\nThe absolute value of 0 should be 0.",
				0, Calculator.abs(0));
	}
}
