package a01;
/*
 * @author Kamdon Bird 
 * Class: CSIS 2420
 * Created: 9/19/2022
 * Assignment: A01 - PercolationStats
 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats2 {

	final private double[] thresholds;
	final private double n;
	final private double t;
	
	// perform T independent experiments on an N�by�N grid
	public PercolationStats2(int N, int T) 
	
	{
		if(N <= 0 || T <= 0) {
			// Hold up, N & T have to be > 0 
			throw new java.lang.IllegalArgumentException();
		}
		
		thresholds = new double[T];
		n = N;
		t = T;
		
		for(int i=0; i<T; ++i) {
			Percolation p = new Percolation(N);
			
			int openCnt = 0;
			
			while(!p.percolates()){
				openRandomSities(p);
					openCnt++;
				}
			thresholds[i] = (double) openCnt / (N*N);
			}		
		}
	
	// sample mean of percolation threshold
	public double mean() 
	{
		return StdStats.mean(thresholds);
		
	}
	// sample standard deviation of percolation threshold
	public double stddev() 
	{
		
		return StdStats.stddev(thresholds);
		
	}
	// low endpoint of 95% confidence interval
	public double confidenceLow() 
	{
		return mean()-((1.96*stddev())/Math.sqrt(t));
		
	}
	public double confidenceHigh()
	{
		return mean()+((1.96*stddev())/Math.sqrt(t));
		
	}
	private void openRandomSities(Percolation p) {
		boolean opneNode = true;
		//  
		int i =0;
		int j =0;
		
		while(opneNode) {
			i = (int) StdRandom.uniform(1, n+1);
			j = (int) StdRandom.uniform(1, n+1);
			
			opneNode = p.isOpen(i, j);
			
		}
		p.open(i, j);
		
		
	}

	public static void main(String[] args)  {
	
		
		PercolationStats2 ps = new PercolationStats2(200, 100);
		
		System.out.println("mean()\t\t\t=" + ps.mean());
		System.out.println("stddev()\t\t=" + ps.stddev());
		System.out.println("confidenceLow()\t\t=" + ps.confidenceLow());	
		System.out.println("confidenceHigh()\t=" + ps.confidenceHigh());
	}
	

}
