/* @author Kamdon Bird
 * Class: CSIS 2420
 * Created: 9/12/2022
 * Assignment: A01 - Percolation*/
package a01;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class Percolation{
	int vTop, area, vBottom, n, openSites;
	boolean[][] grid;
	WeightedQuickUnionUF uf;
	/** Percolation class sets the N x N grid with all sites closed
	 * @param N*/
	public Percolation(int N) {
		n = N;
		if (n <= 0) throw new java.lang.IllegalArgumentException();
		area = n * n;
		/*Grid created to have corresponding index row and index column to the sites*/
		grid = new boolean[n][n];
		/*Initializes an empty union–find data structure with n sites 0 through n-1 */
		uf = new WeightedQuickUnionUF(area + 2);
		//creating virtual "top" to connect to top row of grid to help percolation
		vTop = area;
		//creating virtual "bottom" to connect to bottom row of grid to help percolation
		vBottom = area + 1; 
		for(int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = true;
			}
		}
	}
	/** Opens site, if not already open (row i, column j)
	 * @param i @param j*/
	public void open(int i, int j) {
		if (verifyRange(i,j)) {
			if (!isOpen(i,j)) {
				grid[i][j] = false;
				unionNeighbors(i,j);
				openSites++;
			}
		}
	}
	/** Determines if site is open (row i, column j)
	 * @param i @param j @return boolean*/
	public boolean isOpen(int i, int j) {
		if(verifyRange(i,j)) {
			if(grid[i][j] == false) {
				return true;
			}
		}
		return false;
	}
	/** Determines if site is full (row i, column j)
	 * @param i @param j @return boolean*/
	public boolean isFull(int i, int j) {
		if(verifyRange(i,j)) {
			return uf.connected(siteID(i , j),vTop);
		}
		return true;
	}
	/** Determines if site percolates
	 * @return boolean*/
	public boolean percolates() {
		return uf.connected(vTop, vBottom);
	}
	/** Determines if range of values are valid (row i, column j)
	 * @param i @param j @return boolean*/
	public boolean verifyRange(int i, int j) {
		if (i < 0 || j < 0) throw new java.lang.IllegalArgumentException();
		else return true;
	}
	/** Returns a unique id for site (i=row, j=column)
	 * @param i @param j*/
	private int siteID(int i, int j) {
		return (i * n) + (j);
	}
	/** Unions all neighboring sites (row i, column j)
	 * @param i @param j*/
	public void unionNeighbors(int i, int j) {
		if (j != 0){
			if (isOpen(i, j - 1)) {
				uf.union((siteID(i, j)), siteID(i, j - 1)); //checks left of site
			}
		}
		if (j != (n-1)){
			if (isOpen(i, j + 1)) {
				uf.union((siteID(i, j)), siteID(i, j + 1));//checks right of site
			}
		}
		if (i != 0){
			if (isOpen(i - 1, j)) {
				uf.union((siteID(i, j)), siteID(i - 1, j)); //checks above the site
			}
		}
		if (i != (n-1)){
			if (isOpen(i + 1, j)) {
				uf.union((siteID(i, j)), siteID(i + 1, j)); //checks below the site
			}
		}
		if (i == 0)uf.union((siteID(i, j)), vTop);
		if (i == (n-1))uf.union((siteID(i, j)), vBottom);
	}
	/** Returns the counted open sites for PercolationVisulizer
	 * @return int*/
	public int numberOfOpenSites() {
		return openSites;
	}
}