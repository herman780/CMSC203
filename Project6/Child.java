
/**
 * The class designed to get the ticket price sales for a child ticket and will extend the
 * super class and calculates the sales of the individual child ticket depending on the time of
 * day, the format and after 6 pm or before 6 pm military time format. 
 * A child can only attend G and PG movies. 
 * @author Herman Mann 
 *
 */
public class Child extends Ticket {

	private final double PRICECHILD_BEFORE6PM = 5.75;
	
	private final double PRICECHILD_6PM_AFTER = 10.75;
	
	private final double PLUS_IMAX = 2.00;
	
	private final double PLUS_3D = 1.50;
	
	private double thePriceofMovieCalculated = 0.0;
	
	//private double noAmountToBeAdded = 0.0;
	
	private final String NAME_OFTICKET_CHILD = "CHILD";
	
	@Override
	public int getId() {
		
		return -1;
		
	}
	
	/**
	 * Child no-arg constructor, calls the super class with the special keyword super();
	 */
	
	public Child()
	{
		super();
	}
	
	/**
	 * 
	 * @param movieName of the movie.
	 * @param therating rating of the movie.
	 * @param dayMovie the day of the movie in integer format.
	 * @param time the time in integer military time format. 
	 * @param theFormatofMovie the format of Movie (IMAX, 3d, or None).
	 * @param id the employee ID
	 */
	
	public Child(String movieName, String therating, int dayMovie, int time, String theFormatofMovie, int id)
	{
		super(movieName, therating, dayMovie, time, theFormatofMovie, id);
	}
			
	
	
	
	/**
	 * 
	 * @param string movie name 
	 * @param string2 rating of movie
	 * @param i the day
	 * @param j the time 
	 * @param string3 the format
	 */
	public Child(String string, String string2, int i, int j, String string3) {
		
		super(string, string2, i, j, string3, j);
	}


	/**
	 * The Calculate Ticket price method of the child class to calculate the total child sales and count. 
	 * @return the price of ticket depending on format, and time, and if it is after 6 pm or before 6 pm. 
	 */
	@Override
	public double calculateTicketPrice() {
		
		double theamountCalculatedPrice = 0.0;
		
		if(getTime() < before6PM)
		{
			thePriceofMovieCalculated = PRICECHILD_BEFORE6PM;
			
			if(this.getFormat().equalsIgnoreCase("IMAX"))
			{
				thePriceofMovieCalculated = thePriceofMovieCalculated + PLUS_IMAX;
			}
			
			else if(this.getFormat().equals("3D"))
			{
				thePriceofMovieCalculated = thePriceofMovieCalculated + PLUS_3D;
			}
			
			
		}
		
		else if(getTime() > before6PM && getTime() <= 23)
		{
			thePriceofMovieCalculated = PRICECHILD_6PM_AFTER;
			
			if(this.getFormat().equals("IMAX"))
			{
				thePriceofMovieCalculated = thePriceofMovieCalculated +  PLUS_IMAX ;
			}
			
			else if(this.getFormat().equals("3D"))
			{
				thePriceofMovieCalculated = thePriceofMovieCalculated + PLUS_3D;
			}
		
		}
		
		return thePriceofMovieCalculated + (thePriceofMovieCalculated *  theTax) ;
		
		
	}
	
	
	/**
	 * The to-String method of the Child class. Name of the ticket will be child and added on to the super class which is Ticket. 
	 */
	public String toString()
	{
		return NAME_OFTICKET_CHILD + super.toString();
	}

	
	
	
	


}
