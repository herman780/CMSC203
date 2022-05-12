
/**
 * This is the Plot data element class consisting of the fields of the X and Y location of 
 * the upper left corner of each specific plot and a depth and width value of each specific plot.
 * Used for obtaining a plot or set of plots of the added properties according to the specification of how many
 * properties the user wants, and according to that the plots get added of each of the properties made and then to
 * be tested using a property of user's choice/and or a set of properties. The x-value of the upper-left corner of the plot,
 * the y-value of the upper-left corner of the plot, the width, the horizontal distance/extent of the plot, and the depth, 
 * the distance/vertical extent of the plot. 
 * @author Herman Mann 
 */
public class Plot extends java.lang.Object {
	
	private int x; /* the x-value which is the upper left corner of the plot */
	private int y; /* the y-value which is the y-value of the upper left corner of the plot */
	private int width; /* the horizontal extent of the individual plot(s). */
	private int depth; /* The vertical extent of the individual plot(s). */
	
	

	/**
	 * This is a no argument constructor of Plot() designed to create a
	 * default plot with each separate argument of the x-value of the
	 * default plot to be 0 (x = 0), the y value of the default plot to
	 * be 0 (y = 0), the width value of the default plot to be 1 (width = 1),
	 * the depth value of the default plot to be 1 (depth = 1).
	 */
	public Plot()
	{
		x = 0; /* The default x value set to value of 0.*/
		y = 0; /* The default y value set to value of 0. */
		width = 1; /* The default width value set to a value of 1. */
		depth = 1; /* The default depth value set to a value of 1. */
	}
	
	

	/**
	 * This is the Copy Constructor, and it is designed to create a new specific object
	 * based on the information of the specific object passed to it. 
	 * @param p (a new object of Plot, using the information/info of the object passed to it
	 * as shown below, creates a new Plot using the information of Plot passed to it as mentioned.
	 */
	public Plot(Plot p)
	{
		this.x = p.x; /* Assignment of an old plot to a new plot of the information passed to it as an x value
		in this case. */
		this.y = p.y; /* Assignment of an old plot to a new plot of the information passed to it as an y value
		in this case. */
		this.width = p.width; /* Assignment of an old plot to a new plot of the information passed to it as an width 
		value in this case */
		this.depth = p.depth; /* Assignment of an old plot to a new plot of the information passed to it as an depth
		value in this case */
	}

	
	/**
	 * Parameterized constructor of the different parameters.
	 * @param x (the x value of the default plot/and other plots as well, x-value of upper-left corner of plot, dependent
	 * on the number of properties there as a result).
	 * @param y (the y value of the direct top/upper left corner of the plot and other plots as well, dependent on the
	 * number of properties there).
	 * @param width (the width value of the horizontal distance/extent of the plot/and or other plots, dependent on the
	 * number of properties there).
	 * @param depth (the depth value of the vertical distance/extent of the plot/and or other plots, dependent on the 
	 * number of properties there). 
	 */
	public Plot(int x, int y, int width, int depth)
	{
		this.x = x; /* horizontal coordinate of upper left corner of plot */
		this.y = y; /* vertical coordinate of upper left corner of plot */
		this.depth = depth; /* vertical size of plot */
		this.width = width; /* Horizontal size of plot */
	}
	
	
	
	/**
	 * Returning the x value of the plot.
	 * @return the x-value.
	 */
	public int getX()
	{
		return x; /* returning the x value. */
	}

	
	/**
	 * Setting the x-value of the plot.
	 * @param x (the x value).
	 */
	public void setX(int x)
	{
		this.x = x; /* setting the x value to the parameter. */
	}
	
	
	/**
	 * Returning the y-value of the plot
	 * @return the y-value.
	 */
	public int getY()
	{
		return y; /* returning the y value of plot . */
	}
	
	
	/**
	 * Setting the y-value of the plot.
	 * @param y (the y value to set).
	 */
	public void setY(int y)
	{
		this.y = y; /* setting the y value to the parameter. */
	}
	
	
	/**
	 * Setting the width value of the plot.
	 * @param width (the width value to set).
	 */
	public void setWidth(int width)
	{
		this.width = width; /* setting the width value to the parameter. */
	}
	
	
	/**
	 * Returning the width value of the plot.
	 * @return the width value. 
	 */
	public int getWidth()
	{
		return width; /* returning the width value of the plot */
	}
	
	
	/**
	 * Returning the depth value of the plot.
	 * @return the depth value. 
	 */
	public int getDepth()
	{
		return depth; /* returning the depth value of the plot */
	}
	
	
	/**
	 * Setting the depth value of the plot. 
	 * @param depth (the depth value to set).
	 */
	public void setDepth(int depth)
	{
		this.depth = depth; /* setting the depth value to the parameter. */
	}
	
	
	/**
	 * Determines if a plot or this plot overlaps its parameter, returns true if the two plots
	 * overlap each other, and false otherwise as a result.
	 * @param P (plot instance of Plot).
	 * @return true if this plot or a plot overlaps the parameter, and false therefore otherwise.
	 */
	public boolean overlaps(Plot P)
	{
		/*Setting the boolean variable to true and will work only if a certain
		 * plot overlaps the paramter's individual values of a given plot itself. 
		 */	
		boolean overlapOccuring = true; /* boolean true value of overlap occurring or not. */
		
		int parameterOfx = P.x;
		
		int xofPlot = x; /* x val of plot */
		
		int widthofPlot = width; /* width val */
		
		int yofPlot = y; /* the y value of plot */
		
		int depthofPlot = depth; /* the depth value of plot */
		
		boolean overlappingNotOccuring = false; /* boolean value for overlap not occuring  */
		
		int parameteOfDepth = P.getDepth();
		
		if(parameterOfx >= xofPlot + widthofPlot || (parameterOfx + P.width) <= xofPlot)
		{
			overlapOccuring = overlappingNotOccuring;
		}
		
		if(P.y >= yofPlot + depthofPlot  || (P.y + P.depth) <= yofPlot)
		{
			overlapOccuring = overlappingNotOccuring;
		}
		
		return overlapOccuring; /* dependent on if it is overlapping or not */
		
	}
	
	
	/**
	 * Determines if this plot or a plot encompasses the parameter or not.
	 * @param plot (plot instance and using it to determine if current plot contains it).
	 * @return true if this plot or a plot encompasses the parameter, false therefore otherwise.
	 */
	public boolean encompasses(Plot plot)
	{
		int val = plot.x;
		int val1 = plot.y;
		int val2 = plot.width;
		int val3 = plot.depth;
		
		return val >= x && val1 >= y && val + val2 <= x + width && val1 + val3 <= y + depth;
	}
	
	
	/**
	 * Prints out the Upper left coordinates of the plot, of the printed out x-value, y-value, width, and depth value
	 * turning it into a string forming representation of a plot object in a specific format of things. 
	 * @return the string representation of a Plot object in a given format of listing the information. 
	 */
	public String toString()
	{
		String upper_Left = "Upper left: ";
		String colon = ";";
		String the_Width = " Width: ";
		String the_Depth = "Depth: ";
		String spacing_forValues = " ";
		
		/* returning the formatted toString */
		return upper_Left + "(" +x + "," +y + ")" + colon + the_Width +this.width 
				+ spacing_forValues + the_Depth +this.depth;
	}
	}


