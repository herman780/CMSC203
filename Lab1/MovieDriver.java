import java.util.Scanner; //Needed for Scanner class to get input(s) from user. 

public class MovieDriver {

	public static void main(String[] args) {
		
		String title;
		String rating;
		int soldTickets;
		String user_InputOption;
		
		//User input-scan variable used for getting the title, rating, and the tickets sold. 
		Scanner value_Input = new Scanner(System.in);

		do
		{
			Movie obj1 = new Movie(); //Declaring new movie object of a programmer (Herman) from the constructor. 
			
			System.out.println("Enter the name of the movie here: "); //User will enter the name/title of the movie here.
		
			title = value_Input.nextLine(); //Scanning user input of title/name of the movie 
		
			obj1.setTitle(title); /*Using the movie object declared to set the title/name of the movie in the movie 
			object according to user's desired input entered*/
		
			System.out.println("Enter the rating of the movie: "); /*User will enter the rating of the movie of
			the movie that was entered earlier of the user's choice*/
		
			rating = value_Input.nextLine(); //User input of the rating of movie will be scanned here
		
			obj1.setRating(rating); //The rating of the movie will be set in the movie object 
		
			System.out.println("Enter the number of tickets sold for this movie: "); /*User will enter the number of tickets
			that were sold for the entered movie here*/
		
			soldTickets = value_Input.nextInt(); //User input of the number of tickets sold will be scanned here
		
			obj1.setSoldTickets(soldTickets); /*The number of tickets that were sold for the movie will
			be set in the movie object*/
		
			System.out.println(obj1.toString()); /*Printing out the information per user's inputed input
			using the movie's toString method*/
			
			System.out.println("Do you want to enter another movie? (y or n)"); /*User will enter if y for entering
			more than 1 movie or no to exit the program*/
			
			user_InputOption = value_Input.next();
			
			value_Input.nextLine();
		
		}while(user_InputOption.equals("Y") || user_InputOption.equals("y"));
		
			System.out.print("Goodbye");
			System.exit(0);
			
			value_Input.close(); //Closing of the Scanner class 
		
		
		
			
		
			
			
		
		
			
			
			
			
			
			
			
			
		}
		
		
		
		

	}


