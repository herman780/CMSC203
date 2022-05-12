
/**
 * @author Herman Mann 
 * The first two movies are free and all additional movies are half of the pre-tax adult price + 9.6% tax. 
 */
public class Employee extends Ticket {
	
	private final double PRICE_ADULT_6PM_BEFORE = 10.50;
	
	private final double PRICE_ADULT_6PM_AFTER_INHALF = 13.50;
	
	private final double PRICE_ADULT_PLUS_IMAX = 3.00;
	
	private final double PRICE_ADULT_PLUS_3D = 2.50;
	
	private int theCountOfmoviesSeen = 0;;
	
	//private double priceCalculated;
	
	private final double RETURN_HALFOF_THE_ADULT_PRICE = 2;
	
	private double thePriceofMovieCalculated = 0.0;
	
	private final String THETICKET_TYPE_EMPLOYEE = "EMPLOYEE";
	
	private final int FIRST_TWO_MOVIES = 2;
	
	
	/**
	 * 
	 * @param movieName of the movie 
	 * @param ratingMovie the rating of movie
	 * @param theDay the day of movie 
	 * @param theTime the time of movie
	 * @param format of the movie
	 * @param id of person seeing movie the ticket type. 
	 * @param numVisits by individual seeing movie. 
	 */
	public Employee(String movieName, String ratingMovie, int theDay, int theTime, String format, 
			int id, int numVisits)
	{
		super(movieName, ratingMovie, theDay, theTime, format, id, numVisits);
		
		setNumVisits(numVisits);
	}
	
	/**
	 * 
	 * @param movieName movie name
	 * @param rating of the movie
	 * @param day the day of movie
	 * @param time the time of movie
	 * @param format of the movie. 
	 * @param id of the movie
	 * @param numVisits by individual seeing movie. 
	 * @param numOfMoviesSeenThatDay in the specific day. 
	 * @param numberofTimesSeenthatMovie the specific movie. 
	 */
	public Employee(String movieName, String rating, int day, int time, String format, int id,
			int numVisits, int numOfMoviesSeenThatDay, int numberofTimesSeenthatMovie)
	{
		super(movieName, rating, day, time, format, id, numVisits, numOfMoviesSeenThatDay, numberofTimesSeenthatMovie);
		
		setNumVisits(numVisits);
		setNumberOfMoviesSeenThatDay(numOfMoviesSeenThatDay, id, day);
		setnumberofTimesSeenthatMovie(numberofTimesSeenthatMovie, id, movieName);
	} 
	
	

	/**
	 * the calculate ticket price of employee price of ticket. 
	 * @return the ticket price of employee seeing movie. 
	 */
	@Override
	public double calculateTicketPrice()
	{
		double priceCalculated = 0.0;
		
		if(getNumVisits() <= 2)
		{	
			thePriceofMovieCalculated = 0.0;
		}
			
		else if(getTime() < 18)
		{
			thePriceofMovieCalculated = PRICE_ADULT_6PM_BEFORE;
					
			if(this.getFormat().equalsIgnoreCase("IMAX"))
			{
				thePriceofMovieCalculated =  (PRICE_ADULT_6PM_BEFORE + PRICE_ADULT_PLUS_IMAX) ;
			}
			
			else if(this.getFormat().equalsIgnoreCase("3D"))
			{
		    	thePriceofMovieCalculated = (PRICE_ADULT_6PM_BEFORE + PRICE_ADULT_PLUS_3D) ;
			}
		    
		}
		
		else
		{
			thePriceofMovieCalculated = PRICE_ADULT_6PM_AFTER_INHALF;
			
			if(this.getFormat().equalsIgnoreCase("IMAX"))
			{
				thePriceofMovieCalculated = (PRICE_ADULT_6PM_AFTER_INHALF + PRICE_ADULT_PLUS_IMAX);
			}
			
			else if(this.getFormat().equalsIgnoreCase("3D"))
			{
		    	thePriceofMovieCalculated = (PRICE_ADULT_6PM_AFTER_INHALF + PRICE_ADULT_PLUS_3D);
			}
		   
		}
		
		thePriceofMovieCalculated = thePriceofMovieCalculated / RETURN_HALFOF_THE_ADULT_PRICE;
		
		priceCalculated = (thePriceofMovieCalculated * theTax);
		
		thePriceofMovieCalculated = thePriceofMovieCalculated + priceCalculated;
		
		return thePriceofMovieCalculated;
		
	
	}
	
	

	/**
	 * the id of the employee seeing the movie. 
	 */
	@Override
	public int getId() {
		
		return Id;
	}
	
	/**
	 * the to-String method of the employee class. 
	 */
	public String toString()
	{
		return THETICKET_TYPE_EMPLOYEE + "-" +Id + super.toString();
	}
	
	

}
