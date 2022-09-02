/**
 * Assignment: A01
 * Program: ItemList
 * Created Jan 15,2019
 * @author Zach Funk
 * @author Kamdon Bird
 * 
*/
package a01;
import java.util.ArrayList;
/**
 * @author Kamdon Bird
 * @author Zach Funk
 */
class DirtBike {
	//field & Attributes

	/**
	 * The year of the bike
	 * @author Kamdon Bird
	 */
	private int year;
	/**
	 * The make of the bike
	 * @author Kamdon Bird
	 */
	private String make;
	/**
	 * the model of the bike
	 * @author Kamdon Bird
	 */
	private String model;
	/**
	 * The cc of the bike
	 * @author Kamdon Bird
	 */
	private int cc;
	/**
	 * The bike id, comes from locatingId
	 * @author Zachary Funk
	 * @author Kamdon Bird
	 */
	private int dirtBikeID;
	/**
	 * The id that ties to a bike, created with the bike. Is immutable
	 * @author Zachary Funk
	 */
	public static int locatingId = 12345678;
	/**
	 * The total bike amount
	 * @author Zachary Funk
	 */
	private static int bikeCount = 0;
	/**
	 * Is used to find the index of whichever bike the user wishes to select
	 * @author Zachary Funk
	 */
	public static ArrayList<Integer> findId = new ArrayList<>();
	//Constructors
	/**
	 * @author Kamdon Bird
	 * @param year the year of the bike
	 * @param make the make of the bike
	 * @param model the model of the bike
	 * @param cc the cc of the bike
	 */
	public DirtBike(int year, String make, String model, int cc) {
		this.year = year;
		this.make = make;
		this.model = model;
		this.cc = cc;
		dirtBikeID = locatingId++;
		bikeCount++;
		findId.add(dirtBikeID);
	}
	
	
	/**
	 * Provides the DirtBike id
	 * @author Zachary Funk
	 * @param itemNumber the dirtBikeID of the bike
	 * @return the index of the DirtBike
	 */
	public static int getBikeId(int itemNumber) {
		int index = findId.indexOf(itemNumber);
		return index;
	}
	/**
	 * @author Zachary Funk
	 * @return the bikeCount
	 */
	public static int getBikeCount() {
		return bikeCount;
	}


	/**
	 * @author Zachary Funk
	 * @param bikeCount the bikeCount to set
	 */
	public static void setBikeCount(int bikeCount) {
		DirtBike.bikeCount = bikeCount;
	}
	
	/**
	 * @author Kamdon Bird
	 * @return the Year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @author Kamdon Bird
	 * @return the Make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @author Kamdon Bird
	 * @return the Model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @author Kamdon Bird
	 * @return the cc
	 */
	public int getCc() {
		return cc;
	}

	/**
	 * @author Kamdon Bird
	 * @return the DirtBikeID
	 */
	public int getDirtBikeID() {
		return dirtBikeID;
	}
	
	/** (non-Javadoc)
	 * @author Kamdon Bird
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return year + " " +  make +" " + model +" " + cc +" id: " + dirtBikeID+"\n";
	}
}
