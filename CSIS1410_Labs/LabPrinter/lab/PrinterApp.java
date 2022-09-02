/*Assignment: package printer;
Program: PrinterApp
Created: Feb 12, 2019
Author: %{user}
*/
/**
 * 
 */
package lab;

import java.util.ArrayList;

public class PrinterApp {
	
	public static void main(String[] args) {
		ArrayList<Printer> printers = new ArrayList<>();
		
		InkjetPrinter inkjet = new InkjetPrinter(1789);
		System.out.println(inkjet);
		System.out.printf("Remaining Cartridge: %d%%\n", inkjet.getRemainingCartridge());
		
		LaserPrinter laser = new LaserPrinter(2898);
		System.out.println(laser);
		System.out.printf("Remaining Toner: %d%%\n", laser.getRemainingToner());
		
		System.out.println("List of Printers:");
		printers.add(inkjet);
		printers.add(laser);
		for(Printer el: printers) {
			System.out.println(el);
			for(int i = 0; i < 12; i++) {
				el.print();
			}
		}
		
	}

}
