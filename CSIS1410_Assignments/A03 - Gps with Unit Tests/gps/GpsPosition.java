/*Assignment: package gps;
Program: GpsPosition
Created: Jan 28, 2019
Author: Kamdon Bird
*/


/**
 * package gps
 */
package gps;

/**
 * @author Kamdon Bird
 */
public class GpsPosition {
	
	/**
	 * the latitude of the GpsPosition
	 */
	private double latitude;
	
	/**
	 * the longitude of the GpsPosition
	 */
	private double longitude;
	
	/**
	 * the elevation of the GpsPosition
	 */
	private double elevation;
	
	/**
	 * @param latitude
	 * @param longitude
	 * @param elevation
	 */
	public GpsPosition(double latitude, double longitude, double elevation)
	{
		if(latitude >= -90 && latitude <= 90  && longitude >= -180 && longitude <= 180) {
			this.latitude = latitude;
			this.longitude = longitude;
			this.elevation = elevation;
		}
		else{
			throw new IllegalArgumentException("Invalid latitude and/or longitude");
		}
	}
	
	/**
	 * @param latidude
	 * @return latidude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param longitude
	 * @return longitude
	 */
	public double getLongitude() {
		return longitude;
	}
	
	/**
	 * @param elevation
	 * @return elevation
	 */
	public double getElevation() {
		return elevation;
	}
	
	/**
	 * @param name
	 * @return String
	 */
	@Override
	public String toString() {
		return String.format("%.6f, %.6f (%.1f)", latitude, longitude, elevation);
		
	}
	
}