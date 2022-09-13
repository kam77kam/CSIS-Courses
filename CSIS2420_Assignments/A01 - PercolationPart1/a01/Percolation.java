/*
 * @author Kamdon Bird & Jaykant Chaudhary-Lekhi 
 * Class: CSIS 2420
 * Created: 9/12/2022
 * Assignment: A01 - Percolation
 */

package a01;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation{
	int area, top, bottom;
	boolean[][] grid;
	WeightedQuickUnionUF uf;
	
	/* Percolation class sets the N x N grid with all sites blocked
	 * @param n*/
	public Percolation(int n) {
		//Throws exception if value is below 0
		if (n <= 0) throw new java.lang.IllegalArgumentException();
		//Created size of percolation example 4*4=16 sites
		area = n * n;
		/*Grid created to have corresponding index 
		row and index column to the sites*/
		grid = new boolean[n][n];
		/*Initializes an empty union–find data structure 
		with n sites 0 through n-1 */
		uf = new WeightedQuickUnionUF(area + 1);
		
		top = area;
		bottom = top - 1;
		/*nested for loop to initialize each index of the grid
		to have set true */
		for(int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = true;
			}
		}
	}
	/*Opens site, if not already open (row i, column j)
	 * @param i
	 * @param j*/
	public void open(int i, int j) {
		if (verifyRange(i,j)) {
			if (!isOpen(i,j)) {
				grid[i][j] = false;
			}
		}
	}
	/*Determines if site is open (row i, column j)
	 * @param i
	 * @param j
	 * @return boolean*/
	public boolean isOpen(int i, int j) {
		if(verifyRange(i,j)) {
			if(grid[i][j] == false) {
				return true;
			}
		}
		return false;
	}
	/*Determines if site is full (row i, column j)
	 * @param i
	 * @param j
	 * @return boolean*/
	public boolean isFull(int i, int j) {
		if(verifyRange(i,j)) {
			return uf.connected(i, j);
		}
		return true;
	}
	/*Determines if site percolates
	 * @return boolean*/
	public boolean percolates() {
		return uf.connected(top, bottom);
	}
	/*Determines if range of values are valid (row i, column j)
	 * @param i
	 * @param j
	 * @return boolean*/
	public boolean verifyRange(int i, int j) {
		if (i <= 0 || j <= 0) throw new java.lang.IllegalArgumentException();
		else return true;
	}
}
