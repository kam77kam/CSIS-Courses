/*
 * @author Kamdon Bird
 * Class: CSIS 2420
 * Created: 9/21/2022
 * Assignment: A01 - PercolationStats
 */

package a01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PercolationStatsTest {
	PercolationStats p = new PercolationStats(200, 100);
	@Test
	public void testStatsMean() {
		double expected = p.percolationMean();
		assertTrue(p.percolationMean() == expected);
	}
	@Test
	public void testStatsStdDev(){
		double expected = p.standarDeviation();
		assertTrue(p.standarDeviation() == expected);
	}

	@Test
	public void testStatsConfidenceLow(){
		double expected = p.confidenceLow();
		assertTrue(p.confidenceLow() == expected);
	}

	@Test
	public void testStatsConfidenceHigh(){
		double expected = p.confidenceHigh();
		assertTrue(p.confidenceHigh() == expected);
	}

}
