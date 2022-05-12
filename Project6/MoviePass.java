
/**
 * The first movie is $9.99 (includes tax) and all additional movies are free if:
 * 1. Attend only one movie per day
 * 2. movie cannot have been seen before.
 * 3. Movie cannot be IMAX or 3D.
 * If any of the 3 rules have not been met, they will be charged at the Adult Price. 
 * @author Herman Mann
 *
 */
public class MoviePass extends Ticket {
	
	
	private final double ADULTPRICE_BEFORE_6PM = 10.50;
	
	private final double ADULTPRICE_AFTER_6PM = 13.50;
	
	private final double IMAX_PRICEADDED = 3.00;
	
	private final double THREE_D_PRICEADDED = 2.50;
	
	private int theCountOfMovies;
	
	private String ratingMovie;
	
	private String theFormat;
	
	private double thePriceofMovie;
	
	private final int ONLY_1_MOVIE = 1;
	
	private int howManyTimes_movieSeenBefore;
	
	private int theiD;
	
	private int theNumberofMovies;
	
	private int ifSeenOtherMovie;
	
	private double theTotalPrice; 
	
	private String nameOfMovie;

	private int theNumberofMoviesSeen_inMonth;

	private int theFirstOne;
	
	private boolean theFree;
	
	private double adultMovieTicketPrice;
	

	/**
	 * 
	 * @param movieName the name of the movie. 
	 * @param rating the rating of movie. 
	 * @param day the day of the movie. 
	 * @param time the time of the movie.
	 * @param format the format of the movie(3D or IMAX or NONE). 
	 * @param id the employee ID. 
	 * @param numVisits the number of visits by the employee. 
	 * @param numOfMoviesSeenThatDay number of the movies seen that specific day. 
	 * @param numberofTimesSeenthatMovie the number of times seen that specific movie. 
	 */
	public MoviePass(String movieName, String rating, int day, int time, String format, int id,
		int numVisits, int numOfMoviesSeenThatDay, int numberofTimesSeenthatMovie)
	{
		super(movieName, rating, day, time, format, id, numVisits, numOfMoviesSeenThatDay, numberofTimesSeenthatMovie);
	
		setNumVisits(numVisits);
		setNumberOfMoviesSeenThatDay(numOfMoviesSeenThatDay, id, day);
		setnumberofTimesSeenthatMovie(numberofTimesSeenthatMovie, id, movieName);
	} 
	
	//public MoviePass(String movieName, String rating, int d, int t, String f, int id)
	//{
	//	super(movieName, rating, d, t, f, id);
	//	super.formatofMovie = "MoviePass";
	//	this.theiD = id;
		
	//}
	
	/**
	 * 
	 * @param movieName name of movie. 
	 * @param rating of movie
	 * @param d the day of movie
	 * @param t the time of movie. 
	 * @param f the format of movie.
	 * @param id the employee id of employee
	 * @param ifFree if the movie is free, these certain conditions will follow as mentioned. 
	 * @param oneMovie the price of seeing the movie the first time is $9.99. 
	 */
	public MoviePass(String movieName, String rating, int d, int t, String f, int id, boolean ifFree, boolean oneMovie)
	{
		super(movieName, rating, d, t, f, id);
		
		this.theiD = id;
		
		this.ifFree = ifFree;
		
		this._ONEMOVIE = oneMovie;
	}

	
	//public MoviePass(String string, String string2, int i, int j, String string3, int k, int l, int m, int n) {
		// TODO Auto-generated constructor stub
	//}

	//public MoviePass(String movieN, String rating, int d, int t, String f, int id) {
		
		
	//}

	


	/**
	 * The calculating the price method depends on the format, time, and the day of movie it occurs at. 
	 * @return the ticket price of movie of the movie pass option. 
	 */
	@Override
	public double calculateTicketPrice() {
	
	
		double thePriceofMovie;
	
		if(getNumVisits() < 2 && !this.getFormat().equals("IMAX") && !this.getFormat().equals("3D"))
		{
			thePriceofMovie = 9.99;
		}
		
	
			 
		else {
			
			 if(this.getTime() < 18)
			 {
				 thePriceofMovie = ADULTPRICE_BEFORE_6PM;
			 }
			 
			 else {
				 
				 thePriceofMovie = ADULTPRICE_AFTER_6PM;
			 }
			 
				if(this.getFormat().equalsIgnoreCase("IMAX"))
				{
					thePriceofMovie += IMAX_PRICEADDED;
				}
				
				if(this.getFormat().equalsIgnoreCase("3D"))
				{
					thePriceofMovie += THREE_D_PRICEADDED;
				}
				
				if(this.getFormat().equalsIgnoreCase("NONE"))
				{
					thePriceofMovie += 0; 
				}
			

				thePriceofMovie = thePriceofMovie + (thePriceofMovie * 0.096);
			
			
		}
		
		return thePriceofMovie;
				
				
	}

					
			
	

	/**
	 * The employee ID who is going to see the movie.
	 * @return the ID of the employee. 
	 */
	@Override
	public int getId() {
		
		return theiD;
	}
	
	
	/**
	 * The Movie pass to-String method to print out the information of the specific movie pass ticket. 
	 * @return the format with the movie, otherwise the Moviepass ticket without the format being in and added. 
	 */
	public String toString()
	{
		
		if(this.getFormat().equals("IMAX"))
		{
			return "MOVIEPASS " + "-" + this.getId() + " IMAX " + super.toString() + String.format(" Price: $%.2f", this.calculateTicketPrice());
		}
		
		else if(this.getFormat().equals("3D"))
		{
			return "MOVIEPASS- " + this.getId() + "3D " + super.toString() + String.format(" Price: $%.2f", this.calculateTicketPrice());
		}
		
		else
		{
			return "MOVIEPASS- " + this.getId() + super.toString() + String.format(" Price: $%.2f", this.calculateTicketPrice());
		}
	}
	

}


