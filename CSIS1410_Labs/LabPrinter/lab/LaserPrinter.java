/*Assignment: package printer;
Program: LaserPrinter
Created: Feb 7, 2019
Author: %{user}
*/
package lab;
//class
public class LaserPrinter extends Printer {
	private int remainingToner;

	//constructor
	public LaserPrinter(int number) {
		super(number);
		remainingToner = 100;
	}
	public int getRemainingToner() {
		return remainingToner;
	}
	public void print() {
		if(getRemainingToner() > 0 ){
			remainingToner -= 10;
			System.out.printf("LaserPrinter is printing. Remaining toner: %s%%\n", remainingToner);
		} else
			System.out.println("Toner is empty");
	}
}
