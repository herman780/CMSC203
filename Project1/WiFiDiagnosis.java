/* Programmer Name: Herman Mann
 * 
 * Date when Project is due: 09/17/2020
 
 * Assignment 1: Wi-Fi Diagnosis will describe with the use of Programming how to
 * get through some of the possible issues/problems to technologically get back and restore the Internet
 * connectivity. We have to assume that our computer(s) uses the wi-fi to connect to a specific router 
 * which connects to a specific Internet Service Provider (ISP) which then connects to the overall Internet. 
 */

import java.util.Scanner; //Needed for Scanner class.

public class WiFiDiagnosis {

	public static void main(String[] args) {
		
	/*Declaration of variables and initializations that are needed. */
		String choice_One = "yes";
		String choice_Two = "no";
		String user_InputRead;
		String user_InputRead2;
		String user_InputRead3;
		String user_InputRead4;
		String programmer_Name = "Herman Mann";
		
		//Project application header. 
		System.out.print("If you have a problem with internet connectivity, " +
		"this WiFi Diagnosis might work.");
		
		System.out.println("\n");
		
		Scanner userInputScan = new Scanner(System.in); //Declaring new scanner object for user input 
		
		System.out.println("First step: reboot your computer");
		System.out.println("Are you able to connect with the Internet? (yes or no)");
		
		user_InputRead = userInputScan.nextLine();
		
		if(user_InputRead.equals (choice_One))
		{
			System.out.println("Rebooting your computer seemed to work");
			System.out.println("\n\n" + "Programmer Name: " +programmer_Name); //Printing of Programmer's name at the end.
			System.exit(0);
			
		}
		
		else if(user_InputRead.equals(choice_Two)) /* If the user input is a no, the following statements
		will be printed to the screen. */
		{
			System.out.println("Second step: reboot your router");
			System.out.println("Now are you able to connect with the internet? (yes or no)");
		}
		
		
		
		/* If the first step did not fix internet connectivity for the user, the
		 * user will enter a choice if the second step worked or not with a yes or no input validation.
		 */
		user_InputRead2 = userInputScan.nextLine();
		
		if(user_InputRead2.equals(choice_One))
		{
			System.out.println("Rebooting your router seemed to work");
			System.out.println("\n\n" + "Programmer Name: " +programmer_Name); //Printing of Programmer's name at the end.
			System.exit(0);
		}
		
		else if(user_InputRead2.equals(choice_Two))
		{
			System.out.println("Third step: make sure the cables to your router are plugged in firmly and ");
			System.out.println("your router is getting power");
			
			System.out.println("Now are you able to connect with the internet? (yes or no)");
		}
		
		
		/* If the second step did not fix Internet connectivity for the user, the
		 * user will enter a choice if the third step worked or not with a yes or no input validation. 
		 */
		user_InputRead3 = userInputScan.nextLine();
		
		if(user_InputRead3.equals(choice_One))
		{
			System.out.println("Checking the router's cables seemed to work");
			System.out.println("\n\n" + "Programmer Name: " +programmer_Name); //Printing of Programmer's name at the end.
			System.exit(0);
		}
		
		else if(user_InputRead3.equals(choice_Two))
		{
			System.out.println("Fourth step: move your computer closer to your router");
			System.out.println("Now are you able to connect with the internet? (yes or no)");
		}
		
		
		/* If the third step did not fix Internet connectivity for the user, the
		 * user will enter a choice if the fourth step worked or not with a yes or no input validation.
		 */
		
		user_InputRead4 = userInputScan.nextLine(); // User input will be scanned of the choice here 
		
		if(user_InputRead4.equals(choice_One))
		{
			System.out.println("Moving the computer closer to the router seemed to work");
			System.out.println("\n\n" + "Programmer Name: " +programmer_Name); //Printing of Programmer's name at the end.
			System.exit(0);
		}
		
		else if(user_InputRead4.equals(choice_Two))
		{
			System.out.println("Fifth step: contact your ISP");
			System.out.println("Make sure your ISP is hooked up to your router.");
			System.out.println("\n\n" + "Programmer Name: " +programmer_Name); //Printing of Programmer's name at the end. 
			System.exit(0);
			
		}
		
	
	}

}
