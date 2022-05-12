/*
 * Filename: RandomNumberGuesser.java
 * Author: Herman Mann
 * Date: 09/22/2020
 * Description: This is a Java program named as RandomNumberGuesser that will receive a guess 
 * and report if your guess is the random number that was generated.  
 * Application will narrow down the choices according to your previous guesses,
 * and continue to prompt you to enter a guess until you guess correctly 
 * 
 */

//Importing Java API method for scanning which includes the scanner method 
import java.util.Scanner;

//Driver class that will receive a guess and report if your guess is the random number that was generated.  
//Application will narrow down the choices according to your previous guesses,
//and continue to prompt you to enter a guess until you guess correctly 
public class RandomNumberGuesser {

	// Scanner reader object to read input values
	Scanner reader = new Scanner(System.in);
	// Variable to store randomly generated number
	int randNum;
	// Variable to store next guessed number
	int nextGuess;
	// Variable to store low guessed number
	int lowGuess = 0;
	// Variable to store high guessed number
	int highGuess = 100;
	// Whether it is first guess or not
	boolean isFirstGuess = true;
	// Whether guess number matched to a random number or not
	boolean isGuessMatched = false;
	// Whether exit from guesser or not
	boolean isExit = false;

	// Message string constants
	final String MSG_HEADER = "***************** Welcome to the Random number guessing game *****************";
	final String MSG_FOOTER_THANK_YOU = "\nThanks for playing...";
	final String PROGRAMMER_NAME = "Programmer: Herman Mann";
	final String MSG_FIRST_GUESS = "Enter your first guess";
	final String MSG_ENTER_NUMBER = "Enter your next guess between ";
	final String MSG_AND = " and ";
	final String MSG_NUMBER_OF_GUESS = "Number of guesses is ";
	final String MSG_GUESS_TOO_HIGH = "Your guess is too high";
	final String MSG_GUESS_TOO_LOW = "Your guess is too low";
	final String MSG_CONGRATULATION = "Congratulations, you guessed correctly.";
	final String MSG_TRY_AGAIN = "Try again? (yes or no)";
	final String MSG_YES = "yes";
	final String MSG_NO = "no";

	/**
	 * To initialize variables to their default values
	 *
	 */
	private void initialize() {
		isGuessMatched = false;
		isFirstGuess = true;
		isExit = false;
		lowGuess = 0; 
		highGuess = 100;
	}

	/**
	 * To guess the next number and validate the guessed number in the random number
	 * range. It also print the corresponding messages
	 *
	 */
	private void doNextGuess() {
		boolean isInValidGuess = false;
		do {
			// get the next guess
			nextGuess = Integer.parseInt(reader.nextLine());
			// validate guess in between low and high values
			if (RNG.inputValidation(nextGuess, lowGuess, highGuess)) {
				System.out.println(MSG_NUMBER_OF_GUESS + RNG.getCount());
				// check if our guess is equal to our randomly generated number
				// if not then check if the guess is too high and too low
				// then we update the values of highGuess and lowGuess
				if (nextGuess > randNum) {
					System.out.println(MSG_GUESS_TOO_HIGH);
					highGuess = nextGuess;
				} else if (nextGuess < randNum) {
					System.out.println(MSG_GUESS_TOO_LOW);
					lowGuess = nextGuess;
				} else if (nextGuess == randNum) {
					isGuessMatched = true;
				}
				isInValidGuess = false;
			} else {
				isInValidGuess = true;
			}
		} while (isInValidGuess);
	}

	/**
	 * To perform the first guess, initialize the variables and get the random
	 * number Print the corresponding messages
	 *
	 */
	private void doFirstGuess() {
		// Print message
		System.out.println(MSG_FIRST_GUESS);
		// initialize the variables
		initialize();
		// get the random number
		randNum = RNG.rand();
		// Do first next guess
		doNextGuess();
		// First guess is done so make the flag to false
		isFirstGuess = false;
	}

	/**
	 * To repeat guessing the number until guess matched and print the corresponding
	 * messages
	 *
	 */
	private void doGuessMatch() {
		// repeat guessing the number until guess matched
		do {
			// Print message
			System.out.println(MSG_ENTER_NUMBER + lowGuess + MSG_AND + highGuess);
			// Do next guess
			doNextGuess();
		} while (!isGuessMatched);
	}

	/**
	 * To allow user to play guess game again by entering yes or no and print the
	 * corresponding messages If yes then reset the count value to 0 if not then set
	 * isExit flag to true;
	 */
	private void playAgain() {
		// Loop until choose the right option from yes or no
		do {
			System.out.println(MSG_TRY_AGAIN);
			String choice = reader.nextLine();
			// Check for the user choice. if yes then we reset the count value to 0
			// if not then set isExit flag to true
			if (choice.equalsIgnoreCase(MSG_YES)) {
				RNG.resetCount();
				isFirstGuess = true;
				break;
			} else if (choice.equalsIgnoreCase(MSG_NO)) {
				isExit = true;
				break;
			}
		} while (true);
	}

	/**
	 * To start the random guesser. Print the header message. Check for the first
	 * guess if true else do guess matching until guess matched If guess matched
	 * print Congratulations message and play again based on the user choice if user
	 * choose not to play again exit from the guesser print the corresponding
	 * messages Print the footer message with programmer's name
	 */
	public void startRandomGuesser() {
		// Print header message
		System.out.println(MSG_HEADER);
		System.out.println("");
		do {
			// Check for first guess and do first guess if true else do guess matching until
			// guess matched
			if (isFirstGuess) {
				doFirstGuess();
			} else {
				doGuessMatch();
			}
			// If guess matched print congratulation message and play again based on user
			// choice
			if (isGuessMatched) {
				System.out.println(MSG_CONGRATULATION);
				playAgain();
			}
		} while (!isExit);
		// Print the footer message with programmer's name
		System.out.println(MSG_FOOTER_THANK_YOU);
		System.out.println();
		System.out.println(PROGRAMMER_NAME);
	}

	/**
	 * Main method as an entry point for the program
	 *
	 * @param args as an array of command line arguments
	 */
	public static void main(String[] args) {

		// Object of RandomNumberGuesser class
		RandomNumberGuesser randomNumberGuesser = new RandomNumberGuesser();
		// Call the startRandomGuesser to start playing random guesser game
		randomNumberGuesser.startRandomGuesser();
	}
}
