/*Assignment: package gps;
Program: Gps
Created: Jan 28, 2019
Author: Kamdon Bird
*/

/**
 * package gps
 */
package gps;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Kamdon Bird
 */
public class Gps {
	/**
	 * 
	 */
	private ArrayList<GpsPosition> route = new ArrayList<>();
	/**
	 * 
	 * @param position
	 */
	public Gps(GpsPosition position) {
		route.add(position);
	}
	
	public ArrayList<GpsPosition> getRoute() {
		return route;
	}
	public void update(GpsPosition position) {
		route.add(position);
	}
	public void randomUpdate() {
		Random rand = new Random();
		
		GpsPosition last = new GpsPosition(route.get(route.size() - 1).getLatitude() + rand.nextDouble()-.5,
				route.get(route.size() - 1).getLongitude() + rand.nextDouble()-.5,
				route.get(route.size() - 1).getElevation());
		route.remove(route.size()-1);
		route.add(last);
	}
	public GpsPosition position() {
		return route.get(route.size()-1);
	}
	public double distanceTraveled() {
		double distance = 0;
		for (int i = 0; i < route.size()-1; i++) {
			distance += distance(route.get(i), route.get(i + 1));
		}
		return distance;
	}
	private double distance(GpsPosition from, GpsPosition to) {
		final int R = 6371; // Radius of the earth

	    double latDistance = Math.toRadians(to.getLatitude() - from.getLatitude());
	    double lonDistance = Math.toRadians(to.getLongitude() - from.getLongitude());
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(from.getLatitude())) * Math.cos(Math.toRadians(to.getLatitude()))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters

	    double height = to.getElevation() - from.getElevation();

	    distance = Math.pow(distance, 2) + Math.pow(height, 2);

	    return Math.sqrt(distance) / 1000;
	}
	public void reset() {
		GpsPosition last = route.get(route.size()-1);
		
		route.clear();
		route.add(last);
	}
}
