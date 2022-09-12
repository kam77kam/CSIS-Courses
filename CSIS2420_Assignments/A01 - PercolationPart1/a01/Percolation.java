/*
 * Author: Kamdon Bird
 * Class: CSIS2420
 * Created: 9/12/2022
 * Assignment: A01 - Perculation
 * @author Kamdon Bird
 */

package a01;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation{
	int num, size, top, bottom, open;
	boolean[][] grid;
	WeightedQuickUnionUF uf;
	
	public Percolation(int N) {
		num = N;
		if (num < 0)
			throw new java.lang.IllegalArgumentException();
		
		size = num * num;
		grid = new boolean[num][num];
		uf = new WeightedQuickUnionUF(size + 1);
		top = size;
		bottom = top - 1;
		
		for(int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = true;
			}
		}
		
		
		
	}
	public void open(int i, int j) {
	}
	public boolean isOpen(int i, int j) {
		return false;
	}
	public boolean isFull(int i, int j) {
		return false;
	}
	public boolean perculates() {
		return false;
	}
}
