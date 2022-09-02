/*Assignment: LabConcert
Program: ConcertApp
Created: Jan 8, 2019
Author: Kamdon Bird
*/
package lab;

public class Concert {
	private String name;
	private Time startTime;
	private Time endTime;
	
	//Creating Constructor and passing name, startTime, and endTime
	public Concert(String name, Time startTime, Time endTime) {
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
   }
   @Override
   public String toString(){
      return String.format("Concert %s is at %s and ends at %s", this.name, this.startTime.toMilitary(), endTime.toMilitary());
   }
}