/*Assignment: package printer;
Program: InjectPrinter
Created: Feb 7, 2019
Author: %{user}
*/
package lab;
//class
public class InkjetPrinter extends Printer{
	//fields
	private int remainingCartridge = 100;
	
	//constructor
	public InkjetPrinter(int serialNumber) {
		super(serialNumber);
		remainingCartridge = 100;
	}
	public int getRemainingCartridge() {
		return remainingCartridge;
	}
	public void print() {
		if(getRemainingCartridge() > 0) {
			remainingCartridge -= 10;
			System.out.printf("InkjetPrinter is printing. Remaining cartrdge: %d%%\n", remainingCartridge);
		} else
			System.out.println("Cartridge is empty");
	}
}
