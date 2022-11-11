/**
 * @author Kamdon Bird 
 * Class: CSIS 2420
 * Created: 9/19/2022
 * Assignment: A01 - PercolationStats
 */

package a01;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats{
	double[] averages;

	/**Performs T experiments on an N x N grid.
	 * @param N @param T*/
	public PercolationStats(int N, int T){
		if (N <= 0 || T <= 0)throw new IllegalArgumentException();
		else{
			this.averages = new double[T];
			startPercolation(N, T);
		}
	}

	/**Performs the percolation from class Percolation.
	 * @param n @param t
	 * @return double[]*/
	private double[] startPercolation(int N, int T){
		double index = 0;
		for (int i = 0; i < T; i++){
			Percolation percolation = new Percolation(N);
			while (!percolation.percolates()){
				int r = StdRandom.uniform(0, N);
				int c = StdRandom.uniform(0, N);
				if (!percolation.isOpen(r, c)){
					percolation.open(r, c);
					index++;
				}
			}
			averages[i] = index / (N * N);
			index = 0;
		}
		return averages;
	}

	/**Samples the mean of the percolation threshold.
	 * @return double*/
	public double percolationMean(){
		return StdStats.mean(averages);

	}

	/** Samples the standard deviation of the percolation threshold.
	 * @return double*/
	public double standarDeviation(){
		return StdStats.stddev(averages);
	}

	/**
	 * Formula for the half value needed for the 95% low and high confidence
	 * levels.
	 * @return double*/
	private double calculateHalf(){
		return 1.96 * standarDeviation() / Math.sqrt(averages.length);
	}

	/**Provides the low end point of 95% confidence interval.
	 * @return double*/
	public double confidenceLow(){
		return percolationMean() - calculateHalf();
	}

	/**Provides the high end point of 95% confidence interval. 
	 * @return double*/
	public double confidenceHigh(){
		return percolationMean() + calculateHalf();
	}

	public static void main(String[] args) {
		PercolationStats ps = new PercolationStats(200, 100);
		StdOut.println("Test Results: ");
		StdOut.printf("%-20s %.5f\n", "Mean:", ps.percolationMean());
		StdOut.printf("%-20s %.5f\n", "Standard Deviation:", ps.standarDeviation());
		StdOut.printf("%-20s %.5f\n", "Confidence Low:", ps.confidenceLow());
		StdOut.printf("%-20s %.5f\n", "Confidence High:", ps.confidenceHigh());
	}
}