package m03;

import edu.princeton.cs.algs4.StdRandom;

// = = = = =   THIS CLASS SHOULD NOT BE CHANGED   = = = = = =
/**
 * Defines a plane by its model and number of passengers.
 * 
 * @author CS Starter Code
 */
public class Plane {
	private PlaneModel model;
	private int passengerCount; // number from range [1, 4]
	
	public Plane(PlaneModel model, int passengerCount) {
		if (passengerCount < 1 || passengerCount > 4)
			throw new IllegalArgumentException("The planes can take 1 to 4 passengers.");
		
		this.model = model;
		this.passengerCount = passengerCount;
	}
	
	public Plane() {
		int randomIndex = StdRandom.uniformInt(PlaneModel.values().length);
		this.model = PlaneModel.values()[randomIndex];
		this.passengerCount = StdRandom.uniformInt(1,5);
	}

	public PlaneModel getModel() {
		return model;
	}

	public int getPassengerCount() {
		return passengerCount;
	}

	@Override
	public String toString() {
		return model + "/" + passengerCount;
	}
	
	// = = = Test Client = = =
	
	public static void main(String[] args) {
		Plane myCessna = new Plane(PlaneModel.Cessna_172_Skyhawk, 3);
		System.out.println("myCessna: " + myCessna);
		
		Plane randPlane = new Plane();
		System.out.println("randPlane: " + randPlane);
	}
	
}
