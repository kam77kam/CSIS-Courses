/*Assignment: package labCoin;
Program: Coin
Created: Mar 26, 2019
Author: Kamdon Bird
*/
package lab;
public enum Coin {
	//Types of coins
	CENT(2.5, 19.05), NICKEL(5.0, 21.2), DIME(2.3, 17.9), QUARTER(5.7, 24.3);
	
	//Weight and Diameter
	private final double weight;
	private final double diameter;
	
	//Constructor
	private Coin(double weight, double diameter) {
		this.weight = weight;
		this.diameter = diameter;
	}
		
	@Override
	public String toString() {
		return String.format("%s\t w:%.1f d:%.1f%n", this.name(), this.weight, this.diameter);
	}
}