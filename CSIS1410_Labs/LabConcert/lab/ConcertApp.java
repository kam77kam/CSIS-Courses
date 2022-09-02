/*Assignment: LabConcert
Program: ConcertApp
Created: Jan 8, 2019
Author: Kamdon Bird
*/
package lab;
public class ConcertApp {

	public static void main(String[] args) {
      String name = "Woodstock";
      Time start = new Time(18,30,30);
      Time end = new Time();
		Concert myConcert1 = new Concert("Cher", new Time(19,0,0), new Time(22,0,0));
      Concert myConcert2 = new Concert(name, start, end);
      System.out.println(myConcert1);
      System.out.println(myConcert2);
   }
}