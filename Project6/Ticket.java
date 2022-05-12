
import java.text.NumberFormat;

/**
 * An abstract ticket class with two abstract methods called calculateTicketPrice and getId(). 
 * Consists of to-String method, getters and setters and at least 2 constructors, one of the constructors
 * must be the default (no-arg) constructor. 
 * @author Herman Mann 
 *
 */
public abstract class Ticket {
	
	public abstract double calculateTicketPrice();
	
	public abstract int getId();
	
	protected String forTheMovie = "";
	
	protected String movieName = "";
	
	protected String ratingofMovie;
	
	protected int Day;
	
	protected int time;
	
	protected int Id;
	
	protected double priceOfTicket;
	
	protected String type = "";
	
	protected Format Imax = Format.IMAX;
	
	protected Format three_D = Format.THREE_D;
	
	protected Format None = Format.NONE;
	
	protected final double theTax = 0.096;
	
	protected int startDay = 1;
	
	protected int endDay = 31;
	
	protected int before6PM = 18;
	
	protected String formatofMovie = "";
	
	protected String movieIsImax = "IMAX";
	
	protected String movieis3D = "3D";
	
	protected String movieisNeither = "NONE";
	
	protected String movie = "Movie: ";
	
	protected final String RATING_G = "G";
	
	protected final String RATING_PG13 = "PG13";
	
	protected final String RATING_PG = "PG";
	
	protected final String RATING_R = "R";
	
	protected final String NOT_RATED = "NR";
	
	protected int numVisits = 0;
	
	protected int numOfMoviesSeenThatDay = 0;
	
	protected int numberofTimesSeenthatMovie = 0;
	
	protected String customerType = "";
	
	protected boolean ifFree;
	
	protected boolean _ONEMOVIE;
	
	protected NumberFormat formatofPrice = NumberFormat.getCurrencyInstance();
	
	
	/**
	 * No-arg Ticket constructor. 
	 */
	public Ticket()
	{
		
	}
	
	/**
	 * 
	 * @param movieName the movie name
	 * @param rating the rating of the movie. 
	 * @param day of the movie. 
	 * @param time the time of the movie.
	 * @param format the format of the movie. 
	 * @param id the employee Id or return -1 for Child and Adult ticket type. 
	 */
	public Ticket(String movieName, String rating, int day, int time, String format, int id)
	{
		this.movieName = movieName;
		
		this.forTheMovie = format;
		
		this.Day = day;
		
		this.ratingofMovie = rating;
		
		this.time = time;
		
		this.Id = id;
	}
	
	/**
	 * 
	 * @param movieName the movie name
	 * @param rating the rating of the movie 
	 * @param Day the day of the movie 
	 * @param time the time of the movie 
	 * @param format the format of the movie (IMAX, 3D, or NONE).
	 * @param id the employee ID or -1 for the ID of the child and Adult ticket type. 
	 * @param Free if the movie is free only if some certain conditions are met. 
	 * @param _oneMovie the price of first movie is $9.99
	 */
	public Ticket(String movieName, String rating, int Day, int time, String format, int id, boolean Free, boolean _oneMovie)
	{
		this.movieName = movieName;
		this.forTheMovie = format;
		this.Day = Day;
		this.time = time;
		this.ratingofMovie = rating;
		this.Id = id;
		this.ifFree = Free;
		this._ONEMOVIE = _oneMovie;
	}

	
	/**
	 * 
	 * @param movieName the movie name 
	 * @param theRatingOfMovie the rating of the movie. 
	 * @param theDay the day of the movie.
	 * @param theTime the time of the movie. 
	 * @param theFormat the format of the movie.
	 * @param id the id of employee or -1 for the Adult and Child type. 
	 * @param numVisits the number of visits by the employee or child or adult. 
	 */
	public Ticket(String movieName, String theRatingOfMovie, int theDay, int theTime, String theFormat, int id,
			int numVisits)
	{
		this.movieName = (movieName);
		
		this.ratingofMovie = theRatingOfMovie;
		
		this.Day = theDay;
		
		this.time = theTime;
		
		this.Id = id;
		
		this.forTheMovie = theFormat;
		
		this.numVisits = numVisits;
		
		
	}
	
	/**
	 * 
	 * @param movieName the movie name
	 * @param rating the rating of the movie. 
	 * @param Day the day of the movie. 
	 * @param time the time of the movie. 
	 * @param format the format of the movie. 
	 * @param id the employee id or the -1 for adult and child type. 
	 * @param numVisits the number of visits by adult, employee, or child. 
	 * @param numOfMoviesSeenThatDay number of movies seen that day. 
	 * @param numberofTimesSeenthatMovie the numebr of movies seen the specific movie. 
	 */
	public Ticket(String movieName, String rating, int Day, int time, String format, int id, int numVisits, 
			int numOfMoviesSeenThatDay, int numberofTimesSeenthatMovie)
	{
		this.movieName = (movieName);
		
		this.ratingofMovie = rating;
		
		this.Day = Day;
		
		this.time = time;
		
		this.Id = id;
		
		this.formatofMovie = format;
		
		this.numVisits = numVisits;
		
		this.numOfMoviesSeenThatDay = numOfMoviesSeenThatDay;
		
		this.numberofTimesSeenthatMovie  = numberofTimesSeenthatMovie;
		
	}
	
	
	/**
	 * Setting the format of the movie. 
	 * @param forTheMovie the format of movie. 
	 */
	public void setFormat(String forTheMovie)
	{
		this.forTheMovie = forTheMovie;
	}
	
	
	/**
	 * getting the format of the specific movie. 
	 * @return the format of a movie as a String. 
	 */
	public String getFormat()
	{
		return forTheMovie;
	}
	
	/**
	 * The movie name being set
	 * @param movieName the movie name of the movie
	 */
	public void setMovieName(String movieName)
	{
		this.movieName = movieName;
	}
	
	
	/**
	 * The movie name being seen
	 * @return the movie name. 
	 */
	public String getMovieName()
	{
		return movieName;
	}
	
	/**
	 * setting the rating of the movie.
	 * @param ratingOfMovie getting the movie rating of the specific movie. 
	 */
	public void setRating(String ratingOfMovie)
	{
		this.ratingofMovie = ratingOfMovie;
	}
	
	/**
	 * getting the rating of the movie. 
	 * @return the rating of movie. 
	 */
	public String getTheRatingMovie()
	{
		return ratingofMovie;
	}
	
	/**
	 * setting the day of the movie. 
	 * @param day the day of the movie. 
	 */
	public void setDay(int day)
	{
		this.Day = day;
	}
	
	/**
	 * returning the day of the movie. 
	 * @return the day of movie. 
	 */
	public int getDay()
	{
		return Day;
	}
	
	/**
	 * setting the time of the movie. 
	 * @param time of the movie. 
	 */
	public void setTime(int time)
	{
		this.time = time;
	}
	
	
	/**
	 * getting the time of the movie. 
	 * @return the time of the movie. 
	 */
	public int getTime()
	{
		return time;
	}
	
	/**
	 * setting the id of the person seeing the movie, dependent on if employee, child, or adult. 
	 * @param id of the individual. 
	 */
	public void setid(int id)
	{
		this.Id = id;
	}
	
	
	/**
	 * getting the id of the individual 
	 * @return the id. 
	 */
	public int getID()
	{
		return Id;
	}
	
	
	/**
	 * setting the number of visits by employee.
	 * @param numVisits the total number of visits. 
	 */
	public void setNumVisits(int numVisits)
	{
		this.numVisits = numVisits;
		this.numVisits++;
	}
	
	/**
	 * getting the number of visits made by the individual. 
	 * @return the number of visits by employee.
	 */
	public int getNumVisits()
	{
		return numVisits;
		
		
	}
	
	/**
	 * setting the price of the movie. 
	 * @param priceOfTicket of the movie. 
	 */
	public void setPrice(double priceOfTicket)
	{
		this.priceOfTicket = priceOfTicket;
	}
	
	
	/**
	 * getting the price of the movie. 
	 * @return the price of the movie. 
	 */
	public double getPrice()
	{
		return priceOfTicket;
	}
	
	/**
	 * setting the type of movie. 
	 * @param type of movie. 
	 */
	public void setType(String type)
	{
		this.type = type;
	}
	
	/**
	 * getting the type of movie. 
	 * @return the type of movie. 
	 */
	public String getType()
	{
		return type;
	}
	
	/**
	 * 
	 * @param numMoviesSeenThatDay by individual 
	 * @param id of the individual
	 * @param day of the movie being seen. 
	 */
	public void setNumberOfMoviesSeenThatDay(int numMoviesSeenThatDay, int id, int day)
	{
		this.numOfMoviesSeenThatDay = numMoviesSeenThatDay;
		this.Id = id;
		this.Day = day;
	}
	
	/**
	 * getting the number of movies seen that day. 
	 * @return the number of movies seen that day. 
	 */
	public int getNumberOfMoviesSeenThatDay()
	{
		return numOfMoviesSeenThatDay;
	}
	
	/**
	 * 
	 * @param numberofTimesSeenthatMovie in a day or week or month. 
	 * @param id of the individual. 
	 * @param movie being seen by individual. 
	 */
	public void setnumberofTimesSeenthatMovie(int numberofTimesSeenthatMovie, int id, String movie)
	{
		this.numberofTimesSeenthatMovie = numberofTimesSeenthatMovie;
		this.Id = id;
		this.movieName = movie;
	}
	
	/**
	 * number of times seeing the specific movie. 
	 * @return the number of times seeing the specific movie. 
	 */
	public int getNumberofTimesSeenthatMovie()
	{
		return numberofTimesSeenthatMovie;
	}
	
	
	/**
	 * Name would be either Child, adult, employee, moviepass. 
	 * @param name of the ticket. 
	 */
	public void setCustomerName(String name)
	{
		this.customerType = name;
	}
	
	/**
	 * the to-String method of ticket class. 
	 */
	public String toString()
	{
		

		if(getFormat().equals("IMAX"))
		{
			forTheMovie = "IMAX";
		}
		
		else if(getFormat().equals("3D"))
		{
			forTheMovie = "3D";
		}
		
		return  "Movie: " +movieName + "Rating: "+ratingofMovie + "Day: " +Day + 
				"Time: "+time + "Price: "  + "\n";
	}
	
	

}

 
 
 
 
 
