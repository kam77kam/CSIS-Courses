/*Assignment: package printer;
Program: Printer
Created: Feb 7, 2019
Author: %{user}
*/
package lab;
//class
public abstract class Printer {
	//fields
	private int serialNumber;
	//constructor
	public Printer(int number) {
		serialNumber = number;
	}
	//methods
	public abstract void print();

	@Override
	public String toString() {
		return String.format("%s #%d", super.getClass().getSimpleName(), serialNumber);
	}
}
