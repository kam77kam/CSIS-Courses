package a01;

import java.io.FileNotFoundException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {

	private int N;
	private int T;
	int grid;
	final private double[] thresholds;
	
	public PercolationStats(int N, int T) // perform T independent experiments on an N­by­N grid
	{
		if(N <= 0 || T <= 0) {
			throw new IllegalArgumentException();
			
		}
		this.N = N;
		this.T = T;
		thresholds = new double[this.T];
		int row, col;
		grid = N*N;
		
		for(int i=0; i<T; i++) {
			Percolation p = new Percolation(N);
			
			int openCnt = 0;
			
			while(!p.percolates()){
				row = StdRandom.uniform(0, this.N);
				col = StdRandom.uniform(0, this.N);
				if(!p.isOpen(row, col) && !p.isFull(row, col)) {
					p.open(row, col);
				}
			}
			
			thresholds[i] = (double) openCnt / (double) grid;
		}
		
		
	}
	
	public double mean() // sample mean of percolation threshold
	{
		return StdStats.mean(thresholds);
		
	}
	public double stddev() // sample standard deviation of percolation threshold
	{
		
		return StdStats.stddev(thresholds);
		
	}
	public double confidenceLow() // low endpoint of 95% confidence interval
	{
		return mean() - ((1.96 * stddev())/ Math.sqrt(T));
		
	}
	public double confidenceHigh()
	{
		return mean() + ((1.96 * stddev())/ Math.sqrt(T));
		
	}
	private void opnenRandomSites(Percolation p) {
		boolean openSite = true;
		int row = 0;
		int col =0;
		
		while(openSite) {
			row = StdRandom.uniform(1, N +1);
			col = StdRandom.uniform(1, N +1);
			
			openSite = p.isOpen(row, col);
		}
		
		p.open(row, col);
		
	}
	public static void main(String[] args)  {
		
		PercolationStats ps = new PercolationStats(100, 200);

		

	}

}
