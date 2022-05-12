/**
 * This is a data element class Property, designed to have fields to hold the property
 * name, the city where the specific property is located, the rent amount, the owner's name,
 * and the plot to be overall occupied by the specific property, and along with the separate 
 * getters and setters to get/access and set the fields. Including a parameterized constructor (taking
 * the very specific values for the fields as the parameters itself). Included within the data element class
 * the copy constructor (takes a property object as the parameter). 
 * @author Herman Mann 
 *
 */
public class Property extends java.lang.Object {
	
	private String city; /* the city name of the property location. */
	private String owner; /* the owner name of the property */
	private String propertyName; /* the name of the property. */
	private double rentAmount = 0; /* initialization of rent Amount to a value of 0 */
	private Plot plot; /* introducing plot value of the Plot class */



	
	/**
	 * This is a no argument constructor, creating a new object with default values
	 * of empty strings, the value 0 for the rent amount, and the default plot (setting the
	 * x and y values to 0, the depth and width to a value of 1).
	 */
	public Property()
	{
		this.city = ""; /* city initialized to empty string. */
		this.owner = ""; /* owner name initialized to empty string. */
		this.propertyName = ""; /* property name initialized to empty string. */
		this.rentAmount = 0; /* rent amount initialized to default value of 0. */
		plot = new Plot(); /*instantiating a new plot */
	}
	
	
	/**
	 * This is a copy constructor of the data element property class, creating
	 * a new object using the information of the object passed to it.
	 * @param p (a property object, with information being passed to this object
	 * indirectly).
	 */
	public Property(Property p)
	{
		this.city = p.city;
		this.owner = p.owner;
		this.propertyName = p.propertyName;
		this.rentAmount = p.rentAmount;
		
	}
	
	
	/**
	 * A constructor of the property data element class, this is a parameterized constructor
	 * with no Plot information sent in/provided (using the default plot where the x,y are set to a value of 0, 
	 * the width and depth values set to a value of 1).
	 * @param propertyName (the property name).
	 * @param city (the city name of where the property is located).
	 * @param rentAmount (the rent amount of the property).
	 * @param owner (the owner's name of the property).
	 */
	public Property(String propertyName, String city, double rentAmount, String owner)
	{
		this.city = city;
		this.owner = owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
		this.plot = new Plot(0,0,1,1); /* default plot */
	}
	
	
	/**
	 * This is a constructor of the property data element class, a parameterized constructor.
	 * @param propertyName (the name of the property).
	 * @param city (the city where the property is located).
	 * @param rentAmount (the rent amount of the property).
	 * @param owner (the owner's name of whom owns the specific property).
	 * @param x (the x-value of the property's plot).
	 * @param y (the y-value of the propery's plot).
	 * @param width (the horizontal size of the property's plot).
	 * @param depth (the vertical size of the property's plot).
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(x,y, width, depth); /* user's plot of their own values for x,y,
		width and the depth */
	}
	
	
	/**
	 * Returning the property name.
	 * @return the propertyName
	 */
	public String getPropertyName()
	{
		return propertyName; /* returning the propertyName */
	}
	
	
	/**
	 * Set the property name.
	 * @param propertyName (the propertyName to set).
	 */
	public void setPropertyName(String propertyName)
	{
		this.propertyName = propertyName; /* property name set to the parameter's */
	}
	
	
	/**
	 * Return the city where property is located.
	 * @return (the city of property's location).
	 */
	public String getCity()
	{
		return city; /* returning the city */
	}
	
	
	/**
	 * Setting the Plot values of the plot where the property will be at.
	 * @param x (the x-value of the property's plot).
	 * @param y (the y-value of the property's plot).
	 * @param width (the horizontal size of the property's plot).
	 * @param depth (the vertical size of the property's plot).
	 * @return the Plot for the property. 
	 */
	public Plot setPlot(int x, int y, int width, int depth)
	{

		return this.plot = new Plot(x,y,width,depth); /* returning the plot of the property */
	}
	
	
	/**
	 * Returning the plot of the values of a specific property(s).
	 * @return plot
	 */
	public Plot getPlot()
	{
		return plot; /* returning a newly generated plot needed for 
		successful GUI compilation. */
	}
	
	
	/**
	 * Setting the city of the property.
	 * @param city (the city to set).
	 */
	public void setCity(String city)
	{
		this.city = city; /* setting the city string value to the parameter */
	}
	
	
	/**
	 * Returning the rent amount of a specific property/and or set of properties.
	 * @return the rentAmount.
	 */
	public double getRentAmount()
	{
		return rentAmount; /* returning the rent amount of the property */
	}
	
	
	/**
	 * Setting the rent amount
	 * @param rentAmount (the rentAmount to set).
	 */
	public void setRentAmount(double rentAmount)
	{
		this.rentAmount = rentAmount; /* the rent amount setting it to the parameter's value */
	}
	
	
	/**
	 * Returning the owner name of the property.
	 * @return the owner of the property.
	 */
	public String getOwner()
	{
		return owner; /* returning the owner's name of the property */
	}
	
	
	/**
	 * Setting the owner name of the property.
	 * @param owner (the owner to set).
	 */
	public void setOwner(String owner)
	{
		this.owner = owner; /* setting the owner's name to the parameter. */
	}
	
	/**
	 * Prints out the name, the city, the owner, and the rent amount for a specific property.
	 * @return the string representation of a Property object in a given format of listing the information.
	 */
	public String toString()
	{
		String prop_Name = "Property Name: "; /* the formatted property string . */
		String location_ofProp = "\nLocated in "; /* the formatted location of property. */
		String owner_BelongTo = "\nBelonging to: "; /* the formatted belonging owner of property */
		String rent_AmountOfProp = "\nRent Amount: "; /* the rent amount of the property in a formatted string. */
		
		/* returning the information of the property in a formatted string of indentation */
		return prop_Name +this.propertyName
				+location_ofProp +this.city
				+owner_BelongTo +this.owner
				+rent_AmountOfProp +this.rentAmount;
	}
}
