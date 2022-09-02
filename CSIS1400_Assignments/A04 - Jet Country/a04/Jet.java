/*******************************************************
* Sample Code - do not modify
* Assignment: Jet Country
*******************************************************/
package a04;

public class Jet {
   // fields 
	private final String manufacturer;
	private final String model;
	private final int numberOfEngines;
   private final boolean fighter;
	
	// contructors
	public Jet (String manufacturer, String model, int numberOfEngines, boolean fighter) {
      this.manufacturer = manufacturer;
      this.model = model;
      this.numberOfEngines = numberOfEngines;
      this.fighter = fighter;
   }
   
	// methods
	public String getManufacturer() {
		return manufacturer;
	}	
	
	public String getModel() {
		return model;
	}
	
	public int getNumberOfEngines() {
		return numberOfEngines;
	}
   
   public boolean getFighter() {
      return fighter;
   }
}