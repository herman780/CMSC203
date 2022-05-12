import java.io.File;

import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 * The MovieTicketManager class implementing the movieTicket interface. 
 * @author Herman Mann 
 *
 */
public class MovieTicketManager implements MovieTicketManagerInterface {
	
	private ArrayList <Ticket> ticketList = new ArrayList <Ticket>();
	
	private double theTotalAdultPriceSales = 0.0;
	
	private double theTotalChildPriceSales = 0.0;
	
	private double theTotalEmployeePriceSales = 0.0;
	
	private double theTotalMoviePassPriceSales = 0.0;
	
	private double theTotalSalesEachTicketTogether = 0.0;
	
	private int theCountOfChild = 0;
	
	private int theCountOfAdult = 0;
	
	private int theCountOfEmployee = 0;
	
	private int theCountOfMoviePass = 0;
	
	/**
	 * The no-arg constructor of the Movie ticket manager class. 
	 */
	public MovieTicketManager()
	{
		
	}

	/**
	 * the num of visits by employee or the individual seeing movie
	 * @param id. 
	 * @return the number of visits. 
	 */
	public int numVisits(int id) {
		
		Ticket theTicket;
	
		int theVisits = 0;
		
		for(int k = 0; k < ticketList.size(); k++)
		{
			theTicket = ticketList.get(k);
			
			if(theTicket.getId() == (id))
			{
				theVisits++;
			}
			
		}
		
		return theVisits;
	}

	/**
	 * Number of movies seen.
	 * @param id, movie. 
	 * @return the visits by user seeing the movie. 
	 */
	public int numThisMovie(int id, String movie) {
		
		int theVisitsbyUser = 0;
		
		for(int k = 0; k < ticketList.size(); k++)
		{
			if((ticketList.get(k).getId() == (id) && (ticketList.get(k).getMovieName().equals(movie))))
				
				theVisitsbyUser++;
		}
		
		return theVisitsbyUser;
	}

	/**
	 * The number of movies seen today by employee or other individual. 
	 * @param id, date
	 * @return the totalVisits by employee on the date. 
	 */
	public int numMoviesToday(int id, int date) {
		
		int theTotalVisitsEmployee = 0;
		
		for(int k = 0; k < ticketList.size(); k++)
		{
			if(ticketList.get(k).getId() == (id) && ticketList.get(k).getDay() == (date))
			{
				theTotalVisitsEmployee++;
			}
		}
		
		return theTotalVisitsEmployee;
	}

	
	/**
	 * The addTicket class will add each of the types of tickets.
	 * @param movieN, rating, d, t, f, type, id. 
	 * @return returning the addTicket of each ticket type. 
	 */
	public double addTicket(String movieN, String rating, int d, int t, String f, String type, int id) {
		
		double ticketsToBePriced = 0.0;
		
		double thePrice = 0.0;
		
		Ticket eachIndividualTicket = null;
		
		if(type.equalsIgnoreCase("ADULT"))
		{
			
			eachIndividualTicket = new Adult(movieN, rating, d, t, f, id);
			ticketList.add(eachIndividualTicket);
			ticketsToBePriced = eachIndividualTicket.calculateTicketPrice();
			
			
		}
		
		if(type.equalsIgnoreCase("CHILD"))
		{
			Child theTicketToCount = new Child(movieN, rating, d, t, f);
			ticketList.add(theTicketToCount);
			ticketsToBePriced = theTicketToCount.calculateTicketPrice();
			
			
		}
		
		if(type.equalsIgnoreCase("EMPLOYEE"))
		{
			Employee addTicket = new Employee(movieN, rating, d, t, f, id, numVisits(id));
			ticketList.add(addTicket);
			ticketsToBePriced = addTicket.calculateTicketPrice();
			
		}
		
		
		if(type.equalsIgnoreCase("MoviePass"))
		{
			MoviePass ticketAdding;
			
			String ifMovieisNoneFormat = "NONE";
			
			if(numVisits(id) < 1 && f.equals(ifMovieisNoneFormat)) {
				
				ticketAdding = new MoviePass(movieN, rating, d, t, f, id, true, false);
			}
		
			if(numMoviesToday(id, d) < 1 && numThisMovie(id, movieN) < 1 && f.equals(ifMovieisNoneFormat)) {
				ticketAdding = new MoviePass(movieN, rating, d, t, f, id, false, true);
			}
			
			else
			{
				ticketAdding = new MoviePass(movieN, rating, d, t, f, id, false, false);
			}
			
			
	
			ticketList.add(ticketAdding);
			
			ticketsToBePriced = ticketAdding.calculateTicketPrice();
			
		
		}
		return ticketsToBePriced;

		
		}
		

	/**
	 * The total sales of a single month.
	 * @return the totalSales in a given month. 
	 */
	public double totalSalesMonth() {
		
		double theTotalSales = 0.0;
	
		
		for(int k = 0; k < ticketList.size(); k++)
		{
			theTotalSales = theTotalSales + ticketList.get(k).calculateTicketPrice();
		}
		
		return theTotalSales;
		
	
		
		
	}

	/**
	 * ArrayList String type of get3DTickets().
	 * @return the 3D tickets of each of the ticket types. 
	 */
	@Override
	public ArrayList<String> get3DTickets() {
		
		ArrayList <String> three_DTickets = new ArrayList<String>();
		
		sortByDay();
		
		String StringOnlyIf3D = "3D";
		
		for(int k = 0; k < ticketList.size(); k++)
		{
			if(ticketList.get(k).getFormat().equals(StringOnlyIf3D))
			{
				three_DTickets.add(ticketList.get(k).toString());
			}
		}
		
		return three_DTickets;
		
	}

	/**
	 * The get all tickets method.
	 * @return the tickets of all types of tickets. 
	 */
	public ArrayList<String> getAllTickets() {

		ArrayList<String> totalTickets = new ArrayList<String>();
		
		sortByDay();
		
		for(int j = 0; j < ticketList.size(); j++)
		{
			totalTickets.add(ticketList.get(j).toString());
		}
		
		return totalTickets;
	}

	/**
	 * The arraylist of the MoviePass ticket type. 
	 * @return the allTickets of moviepass. 
	 */
	public ArrayList<String> getMoviePassTickets() {
	
		ArrayList<String> allTickets = new ArrayList<String>();
		
		sortById();
		
		String moviePass = "MOVIEPASS";
		
		for(int k = 0; k < ticketList.size(); k++)
		{
			if(ticketList.get(k).toString().contains(moviePass))
			{
				allTickets.add(new String(ticketList.get(k).toString()));
			}
			
			
		}
	
		
		return allTickets;
		
	}

	/**
	 * ReadFIle to read the file by the user being entered of the ticket information.
	 * 
	 */
	public void readFile(File file) throws FileNotFoundException {
	
		Scanner inputFile = new Scanner(file);
		
		do {
			String[] ticket = inputFile.nextLine().split(":");
			
			addTicket(ticket[0], ticket[1], Integer.parseInt(ticket[2]), Integer.parseInt(ticket[3]),
					ticket[4], ticket[5], Integer.parseInt(ticket[6]));
		} while(inputFile.hasNextLine() && inputFile != null);
		
		inputFile.close();
		
	}
	
	/**
	 * SortByID() method will sort each of the individual ID's by user of order.
	 */
	public void sortById()
	{
		Ticket theTicketList;
		
		for(int j = 0; j < ticketList.size(); j++)
		{
			for(int k = 0; k > 0; k--)
			{
				if(ticketList.get(j).getId() < ticketList.get(k-1).getId())
				{
					theTicketList = ticketList.get(k);
					
					ticketList.set(k, ticketList.get(k-1));
					
					ticketList.set((k-1), (theTicketList));
				}
			}
		}
	}
	
	/**
	 * SortbyDay() method will sort the tickets by the day of movie and Id number. 
	 */
	public void sortByDay()
	{
		Ticket theTicketList;
		
		for(int j = 1; j < ticketList.size(); j++)
		{
			for(int k = j; k > 0; k--)
			{
				if(ticketList.get(k).getDay() < ticketList.get(k-1).getDay())
				{
					theTicketList = ticketList.get(k);
					
					ticketList.set(k, ticketList.get(k-1));
					
					ticketList.set((k-1), theTicketList);
				}
			}
		}
	}


	/**
	 * MonthlySalesReport() method will return the monthly sales of each ticket type.
	 * @return sales report of each ticket type. 
	 */
	@Override
	public String monthlySalesReport() {
		
		String theSalesReport = "";
	    
	    return "\tMonthly Sales Report"
	    		+ "\n\n\t\t\t Sales\t\tNumber"
	    		+ "\nADULT \t\t" ;

		
		
	
	}
	
	

}
