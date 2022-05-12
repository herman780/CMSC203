/**
 * The adult class, the id being -1 and the ticket prices of 10.50 and 13.50.
 * The format being either IMAX, 3D, or NONE. 
 * @author Herman Mann
 *
 */
public class Adult extends Ticket {

	private final double ADULTPRICE_6PM_BEFORE = 10.50;
	
	private final double ADULTPRICE_6PM_AFTER = 13.50;
	
	private final double PLUS_IMAX = 3.00;
	
	private final double PLUS_THREE_D = 2.50;
	
	private double thePrice = 0.0;
	
	private final String NAME_OFTICKET_ADULT = "ADULT";
	
	private final int if_BEFORE_6PM = 18;
	
	
	/**
	 * 
	 * @param movieName the name of the movie. 
	 * @param rating of the movie. 
	 * @param time the time of the movie
	 * @param day the day of the movie. 
	 * @param format of the movie. 
	 * @param id of the person seeing the movie. 
	 */
	public Adult(String movieName, String rating, int time, int day, String format, int id)
	{
		super(movieName, rating, time, day, format, id);
	}
	
	//public Adult(String theMovieTitle, String theRating, int theDay, int theTime, String theFormat, int id)
	//{
	//	super(theMovieTitle, theRating, theDay, theTime, theFormat, id);
	//}
	
	

	/**
	 * calculate ticket price of the adult seeing the movie.
	 * @return the ticket price of the adult ticket type. 
	 */
	@Override
	public double calculateTicketPrice() {
		
		double adultMovieTicketPrice = 0.0;
		
		if(getTime() <  if_BEFORE_6PM)
		{
			thePrice = ADULTPRICE_6PM_BEFORE;
			
			if(this.getFormat().equalsIgnoreCase("IMAX"))
			{
				thePrice = thePrice + PLUS_IMAX;
			}
			
			else if(this.getFormat().equalsIgnoreCase("3D"))
			{
				thePrice = thePrice + PLUS_THREE_D;
			}
		}
		
		else if(getTime() > if_BEFORE_6PM && getTime() <= 23)
		{
			thePrice = ADULTPRICE_6PM_AFTER;
			
			if(this.getFormat().equalsIgnoreCase("IMAX"))
			{
				thePrice = thePrice + PLUS_IMAX;
			}
			
			else if(this.getFormat().equals("3D"))
			{
				thePrice = thePrice + PLUS_THREE_D;
			}
			
		}
		
		adultMovieTicketPrice = thePrice * theTax;
		
		thePrice = thePrice + adultMovieTicketPrice;
		
		return thePrice;
	}

	
	/**
	 * Returning the ID of the adult which will be -1.
	 * @return -1 for ID of Adult. 
	 */
	@Override
	public int getId() {
		
		return -1;
	}
	
	/**
	 * The to-String method of the adult class. 
	 */
	public String toString()
	{
		return NAME_OFTICKET_ADULT + super.toString();
	}
	
	

}
