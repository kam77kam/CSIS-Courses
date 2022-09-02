/*******************************************************
* Sample Code - do not modify
* Assignment: Jet Country
*******************************************************/
package a04;

public class Country {
   // fields
	private String name;
	private int population; 
	private final int area; // area in square miles
	
	// constructors
   public Country(String name, int population, int area) {
      this.name = name;
      this.population = population;
      this.area = area;
   }
	
	// methods
	public String getName() {
		return name;
	}
	
	public int getPopulation() {
		return population;
	}	
	
	public int getArea() {
		return area;
	}	   
   	
   public void setName(String name) {
		this.name = name;
	}	
	
   public void setPopulation(int population) {
		this.population = population;
	}		
	
	// population per square mile
	public int populationDensity() {
		int density = population / area; // integer division truncates
		return density;
	}
}