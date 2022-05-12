import javafx.scene.layout.Region;

/**
 * This is the data manager class, having no output functionality, but will take in the necessary input
 * , operating on the data and its structure, and returning the values or setting the variables that may possibly
 * be accessed with the getters. Containing the instance variables of name, tax ID, management fee, MAX_PROPERTY, 
 * and including the two constants of integers of MGMT_WIDTH and MGMT_DEPTH set to a value of 10. Including an
 * attribute plot of type of the Plot that explains the plot of the ManagementCompany class. Containing the methods
 * of addProperty (3 different versions of this method). Representing the management company object. This class will have
 * and run the maxRentProp, the totalRent, maxRentPropertyIndex(), displayPropertyAtIndex(int i), the toString() method, and
 * the getMAX_PROPERTY. Additional variables/attributes are declared for the imporant use of running the data manager class. 
 * The ind and val variables will be used for the addProperty method (3 versions) and the other methods of this class. 
 * @author Herman Mann
 */
public class ManagementCompany extends java.lang.Object {
	
	private final int MAX_PROPERTY = 5; /* The highest number of properties that this management company can handle. */
	private double mgmFeePer; /* The management fee percentage of the property(s) to charge */
	private String name; /* The name of the management company */
	private String taxID; /* the tax ID of the management company. */
	private Property [] properties; /* An array of the objects of Property. */
	private final int MGMT_WIDTH = 10; /* initialized to a value of 10 for the width of plot of property containment */
	private final int MGMT_DEPTH = 10; /* initialized to a value of 10 for the depth of plot of the property containment. */
	private Plot plot; /* The plot of the Management company. */
	private int ind; /* Variable needed for the use of the other methods, specifically for addProperty (the 3 versions of this method). */
	private int val; /* Needed for values of addProperty if (returning val = -2 (property == null), returning val = -1 if the array is full, 
	returning val = -3 if the management company does not contain/encompass the plot of the property, and returning val = -4 if the 
	property plot overlaps any of the properties in array. */
	
	
	/**
	 * This is a no argument constructor that creates a ManagementCompany object containing the empty strings,
	 * and a default plot, and the properties array is initialized here. The plot is set to a Plot with the x and y
	 * values set to 0, and the width and depth set to a value of 10. Two other attributes are declared here, the ind and
	 * val variables a part of ManagementCompany constructor, set to a value of 0. MGMT_WIDTH will be set to a value of 10, 
	 * and the MGMT_DEPTH set to a value of 10 as well. The ind and val attributes/fields will be set to 0. 
	 */
	public ManagementCompany()
	{
		this.name = ""; /* name of management company set to a empty string. */
		this.taxID = ""; /* the tax id of the management company set to a empty string. */
		this.mgmFeePer = 0; /* the management fee of the property set to an initialization of 0. */
		this.properties = new Property[MAX_PROPERTY]; /* initialization of the properties array here . */
		this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH); /* new plot created of x having a value of 0, the y
		value having a value of 0, the width of the plot having a value of 10, and the depth of the plot having a value of
		10 ( for the introduced plot of the management company). */
		this.ind = 0; /* needed for the addProperty method (3 versions). */
		this.val = 0; /* needed for assigning the value of -1,-2,-3, or -4 depending on if the array is full,
		the property object of "Property" is equal to null, if the plot does not contain/encompass the property,
		and if a plot overlaps the management company plot to set the values (-1,-2,-3,-4 to val). */
	}
	
	
	/**
	 * The Management company constructor creates a ManagementCompany object using the passed information 
	 *, the Plot is set to a Plot with the x any being a value of 0, and the width and depth set to 10, the
	 * properties array is initialized here also. 
	 * @param name (the management company name).
	 * @param taxID (tax id of the management company).
	 * @param mgmFee (the management fee).
	 */
	public ManagementCompany(String name, String taxID, double mgmFee)
	{
		this.name = name; /* setting the name of the management company to the parameter "name". */
		this.taxID = taxID; /* setting the taxID of the management company to the parameter "taxID". */
		this.mgmFeePer = mgmFee; /* setting the management fee of the management company to the parameter "mgmFee". */
		this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY]; /* properties array instantiated here as well. */
	}
	
	
	/**
	 * The Management company constructor creates a ManagementCompany object using the passed
	 * information. The properties array is initialized here also.
	 * @param name (management company name).
	 * @param taxID (tax Id).
	 * @param mgmFee (the management fee of the company).
	 * @param x (the x-value of the plot of the management company property(s)).
	 * @param y (the y-value of the plot of the management company property(s)).
	 * @param width (the width of the plot of the management company property(s)).
	 * @param depth (the depth of the plot of the management company property(s)).
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth)
	{
		this.properties = new Property[MAX_PROPERTY];
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(x, y,MGMT_WIDTH,MGMT_DEPTH);
	}
	
	
	/**
	 * Copy constructor that creates a ManagementCompany object using another ManagementCompany object. The
	 * properties array is initialized here also. 
	 * @param otherCompany (another management company).
	 */
	public ManagementCompany(ManagementCompany otherCompany)
	{
		/* information 
		 * used for another ManagementCompany object using the management company object of another. */
		this.properties = new Property[MAX_PROPERTY];
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
	}
	
	
	/**
	 * Adds the property object to the properties array.
	 * @param property (a property object).
	 * @return -1 if the array is full
	 * -2 if the object of Property "property" is null
	 * -3 if the plot is not contained/encompassed by the ManagementCompany plot
	 * -4 if the plot overlaps any other property, or if the index in the array where the
	 * property was added accordingly/successfully. 
	 */
	public int addProperty(Property property)
	{
		int arrayisTooFull = ind;
		int totalelementsInArray = MAX_PROPERTY;
		boolean notNullStatus = true; /* needed for returning -2 result. */
		boolean notContained = false; /* needed for returning the -3 result. */
		
		/* If the property object of property is equal to null status */
		if(property == null == (notNullStatus))
		{
			return val = -2; /* val will be assigned -2 here. */
		}
		
		if(arrayisTooFull >= totalelementsInArray)
		{
			return val = -1; /*if array is too full */
		}
		
		/*return -3 only if the plot is not contained within by the Management Company plot. */
		if(plot.encompasses(property.getPlot()) == notContained)
		{
			return val = -3; /* val will be assigned -3 here. */
		}
		
		for(int p = 0; p < ind; p++)
		{
			Property arrayofProperties = properties[p];
	
			if(arrayofProperties != null == notNullStatus)
			{
				/*if the certain plot overlaps any other property, or if the index in the array where the
				 * property was added properly and accordingly */
				
					if((property.getPlot().overlaps(arrayofProperties.getPlot()) == true))
					{
						return val = -4; /* val will be assigned -4 here. */
					}
					
			}
		}
		if(arrayisTooFull < totalelementsInArray)
		{
			properties[ind] = property;
			ind++; /* incrementation of the index of array */
		}
		
		return ind -1;
	}
	
	/**
	 * Creating a property object and adding it onto the properties array, in a default plot.
	 * @param name (property name).
	 * @param city (location of the property).
	 * @param rent (monthly rent).
	 * @param owner (owner of the property).
	 * @return -1 if the array is full
	 * -2 if the property object of property is null
	 * -3 if the plot is not contained/encompassed by the ManagementCompany plot
	 * -4 if the plot overlaps any other property, or the index in the array where the 
	 * property was added accordingly.
	 */
	public int addProperty(String name, String city, double rent, String owner)
	{
		/* returning another version of addProperty here with the name, city, rent, and owner parameters passed into it */
		int p1 = (addProperty(new Property(name,city,rent,owner)));
		return p1; /* returning the new addProperty method with the passed in information */
		
	}
	
	
	/**
	 * Creates a property object and adds it to the properties array.
	 * @param name (property name)
	 * @param city (location of the property)
	 * @param rent (monthly rent)
	 * @param owner (owner of the property)
	 * @param x (x location of upper left corner of property's plot)
	 * @param y (y location of upper left corner of property's plot)
	 * @param width (width of the property's plot)
	 * @param depth (depth of the property's plot)
	 * @return -1 if the array is full
	 * -2 if the property object of property is null
	 * -3 if plot is not contained/encompassed by the ManagementCompany plot
	 * -4 if the plot overlaps any other property, or the index in the array where the
	 * property was added properly/accordingly. 
	 */
	public int addProperty(String name, String city, double rent, String owner,
			int x, int y, int width, int depth)
	{
		/* Another version of addProperty(passing in the information of the parameters name,
		 * city, rent, the owner, x, y, width, and depth (p2, in this case). 
		 */
		int p2 = (addProperty (new Property(name, city, rent, owner, x, y, width, depth)));
		return p2; /* returning the third version of addProperty and passing in the necessary
		information */
	}
		
		
	/**
	 * This method accesses each property object in the array properties and sums up the 
	 * property rent and returns the total amount. 
	 * @return total rent
	 */
	public double totalRent()
	{
		double rentCount = 0.00; /* initialization of the rent Count to be used later in summing
		up the rents of each of the properties (dependent on the amount we have). */
		
		for(int i = 0; i < ind; i++)
		{
			double totalRentResult = properties[i].getRentAmount();
			
			if(!(properties[i] == null))
			{
				rentCount = rentCount + totalRentResult; /*summing up the property rent and returns the total
				rent of the property(s). */
			}
		}
		
		return rentCount; /* returning the total amount of the summation of property rents of each
		properties(s) if more than one exists, otherwise a single property summation of the total amount. */
	}
	
	
	
	/**
	 * This method finds the property with the highest/maximum rent amount and returns its formatted toString
	 * result. We assume that each Property object's rent amount is different. 
	 * @return double, the maximum rent amount
	 */
	public String maxRentProp()
	{
		String returnStatus = properties [maxRentPropertyIndex()].toString();
		return returnStatus; 
	}
	
	
	/**
	 * This method finds the index of the property with the highest/maximum rent amount.
	 * We assume each property's object rent amount is different.  
	 * @return an int, the index of the property with the highest/maximum rent amount
	 */
	public int maxRentPropertyIndex()
	{
		int totalMaxCount = 0;
		double propwithMaxRent = properties[totalMaxCount].getRentAmount();
		int totalArray = MAX_PROPERTY;
		double rentAmount;
		
		for(int k = 0; k < ind; k++)
		{	
			rentAmount = properties[k].getRentAmount();
			
			if(!(properties[k] == null))
			{
				if(rentAmount > propwithMaxRent)
				{
					totalMaxCount = k;
					propwithMaxRent = rentAmount;
				}
			}
			
		}
		
		return totalMaxCount; /* returning the highest/maximum rent amount of a certain property. */
	}
	
	
	
	/**
	 * Displaying the information of the overall property at the specific index,
	 * in this case the index is of i.
	 * @param i the index of the property in the array properties.
	 * @return the information of the specific property at the index, in this case i. 
	 */
	public String displayPropertyAtIndex(int i)
	{
		String propertiesIndexReturn = properties[i].toString();
		
		System.out.println("\n"); /* newline necessary for neater output format. */
		
		return propertiesIndexReturn;
	}
	
	
	/**
	 * Returning of the max property constant that symbolizes the direct size of the array properties. 
	 * @return the MAX_PROPERTY, a constant attribute/variable for the class which is set to 5. 
	 */
	public int getMAX_PROPERTY()
	{
		return MAX_PROPERTY; /* returning the max properties there can be which is the value of 5. */
	}
	
	
	/**
	 * Displays/prints the information of all of the properties entered
	 *  in of the properties array.
	 *  Overrides the toString in the class of the java.lang.Object
	 *  returns the information of all the properties within this management company by getting
	 *  the properties array in the formatted lining of things. Accesses the properties array for displaying
	 *  the information of any necessary information needed. 
	 *  @return the information of ALL the properties within the specific management company by accessing
	 *  the properties array, in a formatted output. 
	 */
	public String toString()
	{
		int totalArraytoString = ind;
		
		int indexofProperties = 0;
		
		String infoDisplay = "";
		
		double totalCombinedManagementFee;
		
		double dividingFactor = 100.0;
		
		totalCombinedManagementFee = (mgmFeePer / dividingFactor) * (totalRent());
		
		String displayTheInformation = "";
		
		String propName = "Property Name: ";
		
		String indent = "\n";
		
		String location = "Located in ";
		
		String owner = "Belonging to: ";
		
		String rentAmount = "Rent Amount: ";
		
		String listingOfProperties = "List of all properties for  ";
		
		String totManagFee = "total management Fee: %.1f";
		
		for(int j = 0; j < totalArraytoString; j++)
		{
			/* displaying of the information of property name, location of city of the property, the owner name
			 * of the property, the rent amount of the property. 
			 */
			
			if(!(properties[j] == null))
			{
				displayTheInformation = displayTheInformation + "\n" + propName + properties[j].getPropertyName() +
									 indent +location +properties[j].getCity() + indent + owner +properties[j].getOwner() +
									 indent + rentAmount + properties[j].getRentAmount();
			}
			
			/* displaying the information of the management company, the total management fee of individual companies
			 *  (dependent on the total amount of properties included in the calculation), with the total combined management fee
			 *  of all of the properties of the management companies together.
			 */
			infoDisplay =  listingOfProperties+ name + ", taxID: " + taxID  
					    + "\n______________________________________________________ " + displayTheInformation + 
					    String.format("\n______________________________________________________\n" + indent +  totManagFee, 
					    totalCombinedManagementFee);
					    		
			
		}
	
		return infoDisplay; /* returning the information in a formatted output. */
		
	}

	/**
	 * Returning the plot(s) of each added property.
	 * @return plot
	 */
	public Plot getPlot() 
	{
		return plot; /* returning the plot of the property(s), needed for successful
		compilation of the MgmCompanyGUI, otherwise the GUI couldn't of ran */
	}
	
	
	/**
	 * Returning of the name of the Management Company.
	 * @return Management Company name. 
	 */
	public String getName() 
	{
		return name; /* returning the name of the management company,
		needed for successful compilation of the MgmCompanyGUI, otherwise the GUI couldn't
		of ran */
	}

}

	
