package lab;

public class Country
{
	// fields
   private String name;
   private Continent continent;
	// constructor
   
	public Country(String name, Continent continent){
      this.name = name;
      this.continent = continent;
   }
	// methods
   
	public String getName(){
      return name;
   }
   
   public Continent getContinent(){
      return continent;
   }
   
	@Override
	public String toString()
	{
		return String.format("%s (%s)", name, continent);
	}
}