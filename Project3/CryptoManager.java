/*Author Name: Herman Mann 

 
 * Assignment 3(Cryptography): Writing a Java program to encrypt and to decrypt a phrase/word using two similar
 
 * but different approaches, the Caesar Cipher and Bellaso methods. (Encrypting and the decrypting of both of them).
 
 * Implementing 5 of the methods, encryptCaesar, encryptBellaso, stringInBounds, decryptCaesar, and decryptBellaso.
 
 * Due Date of Assignment: 10/15/2020
 
 */

/*Implementing each of the five methods of this class to make the class pass the big Junit CryptoJUnitTest
 
 * The class has static methods and the user has to implement them accordinly for each of the 5 methods to successfully
 
 * work. The Cryptomanager class requires a string key or integer key to be passed as an argument to each of the 5 methods 
 * of successful use.
  
 */
public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		
		//throw new RuntimeException("method not implemented");
		
		/*The method of the plainText will return true only if the characters in the
		 * string of the string's length are in between the LOWER_BOUND = 32 and UPPER_BOUND =
		 * 95. 
		 */
		boolean statusofBounds = true;
		
		for(int k = 0; k <= (plainText.length()-1); k++)
		{
			if(plainText.charAt(k) < LOWER_BOUND || plainText.charAt(k) > UPPER_BOUND)
			{	
				/*Will return false only if the characters in the string depending on length of
				 * string is less than the lower bound which is 32 and is greater than the
				 * upper bound which is 95. 
				 */
				return statusofBounds = false;
			}
		
		}
		/*returning the stringInBounds method of the boolean return type
		 * dependent on the characters of the length of the string itself. 
		 */
		return statusofBounds; 
		
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		
		//throw new RuntimeException("method not implemented");
		
		
		/*Using a integer key to add it to each of the characters of the plainText and
		 * returning the caesar encrypted text all together. 
		 */
		String encryptCaesarString = "";
		char chStr = 0;
		int stringEncrypted = 0;
		
		//while(key > UPPER_BOUND)
		//{
		//	key = key - RANGE;
		//}

		
			for(int chStart = 0; chStart <= (plainText.length()-1); chStart++)
			{
				
				chStr = (char)(plainText.charAt(chStart));
				
				/* If the string of the plainText is not within bounds the method of encrypting the caesar will fail,
				 * unless if each of the characters in the string is within the bounds of 32-95 in ASCII character value. 
				 */
				if(stringInBounds(plainText))
				{
				
					/* Adding the integer key to each of the characters of the empty plainText string 
					 * within the bounds and then returning the empty string plus the key added on to each of the characters
					 * to the returned string itself. 
					 */
					stringEncrypted = (int) chStr + key;
	
					
					/* If the string that is encrypted of the individual characters in the string plus the key as an integer
					 * is greater than the UPPER_BOUND of 95, the key added on top of the individual characters will be 
					 * subtracted from the range, which has a value of 64 and make each character of the string of the key added 
					 * onto each character as an offset to be within bounds. 
					 */
					while(stringEncrypted > UPPER_BOUND)
					{
					
						stringEncrypted = stringEncrypted - RANGE;
					
					}
				
					/* The empty string declared at the top as it will return as an encryptedCaesar will be added
					 * to the previous variable that was assigned to get the key added on to the individual characters
					 * and added to the empty string to return an appropriate value as of String type. 
					 */
					encryptCaesarString = encryptCaesarString + (char)stringEncrypted;
				
				}
			
			
			}
		
			
			/* Returning of the encrypted Caesar string as a String return type of the plainText. */
			return encryptCaesarString;
		
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
	
		//throw new RuntimeException("method not implemented");
		
		//Empty string gets declared for the returning of the encrypted Bellaso string 
		String encryptTheBellaso = ""; 
		
		/*The indexofBel variable takes in the plainText and each individual character
		 * starting at index 0 and increments up and gets added onto the bellasoStr for the bellaso string key input
		 * dependent on the user's string key input. 
		 */
		char indexofBel = 0;
		
		/* Takes in the text of plainText and adds it on to the string key of BellasoStr, returning the
		 * remainder since the input key as an integer is not known. 
		 */
		char totalStringofBellaso = 0;
		
		for(int bel = 0; bel < plainText.length(); bel++)
		{
			
			/* Each individual character of an index of the string according to the string's length 
			 *  will be sent into the plainText and will be assigned to a newly declared variable 
			 */
			indexofBel = (char) plainText.charAt(bel);
			
			
			/* If only if the string of the individual characters are within the ASCII character 
			 * bounds of 32-95 the following statements will run of the BellasoString added onto the empty
			 * plainText string itself. 
			 */
			if(stringInBounds(plainText));
			{
				
				/* The individual characters of the plainText string will be added onto the string keyword of BellasoStr
				 * 	and then the bellaso String will return the remainder of each of the characters so the length of the Bellaso
				 * string matches accordingly to the length of the plain Text string. Then the string key word of bellaso string
				 * will be added onto the plainText string according to its length and with different key. 
				 */
				totalStringofBellaso = (char) ((char)indexofBel + bellasoStr.charAt(bel % bellasoStr.length()));
				
		
				while(totalStringofBellaso > UPPER_BOUND)
				{
					/*If the individual characters within the bellasostr added onto the plainText string characters are
					 * greater than the UPEPR_BOUND ASCII character of 95, each of the characters with the string key will
					 * be subtracted from the RANGE of value 64. 
					 */
					totalStringofBellaso = (char) (totalStringofBellaso - RANGE);
					
				}
				
				
				/* Adding the string of plainText characters along with the bellaso string key word to the empty string 
				 * to return the string as an encrypted Bellaso string return type. 
				 */
				encryptTheBellaso = encryptTheBellaso + totalStringofBellaso;
				
			}
	
				
			
		}
		
		/*Returns the encrypted Bellaso string with the bellasoStr key word added to each of the characters
		 * according to the string plainText type length. 	
		 */
		return encryptTheBellaso;	
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		//throw new RuntimeException("method not implemented");
		
		/*Used for returning the decryptCaesar string with the individual characters of the 
		 * string subtracting it by the offset integer key to return it to its original text itself. 
		 */
		String decryptString = "";
		
		
		/*Declaration of needed variable. */
		int ch2;
		
		int decryptCaesartestBound = 0;
		
		for(int k = 0; k <= (encryptedText.length()-1); k++)
		{
			/*Uses the encryptedText of each of its characters
			 * to be used in the process of subtracting each of the characters from the key offset back
			 * to its original length.
			 */
			ch2 = (char) (encryptedText.charAt(k));
			
			
			if(stringInBounds(encryptedText))
			{
			
				/*Subtracting each of the individual characters of the encrypted text which was once
				 * encrypted to an addition of the offset integer key to subtracting the integer key of offset
				 * to return the encrypted text to its original text itself. 
				 */
				decryptCaesartestBound = (char) (encryptedText.charAt(k) - key);
				
				/* If the characters in the encrypted text subtracting it by the key is greater than the UPPER_BOUND
				 * of the ASCII character 95, the string of the characters will be subtracted by the Range of 64. 
				 */
				while(decryptCaesartestBound > UPPER_BOUND)
				{
					/*Subtracting by the RANGE of value 64. */
					decryptCaesartestBound = decryptCaesartestBound - RANGE;
				}
				
				/* The decryptString method will have the decryptCaesartestBound of the individual characters subtracting
				 * the key to return the original string inputed. 
				 */
				decryptString = decryptString + (char)decryptCaesartestBound;
				
			}
		}
		
		/* Returns the decryptedCaesar string of to its original string. */
		return decryptString;
		
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		
		/* The bellaso decrypt bellaso will return the original string of the inputted bellaso. */
		String decryptTheBellaso = "";
		
		/*Needed declaration variable to return the decrypted bellaso string
		 * back to its original length. 
		 */
		int decryptBellasotestBound = 0;
		int decryptBellasoReturned = 0;
		
		for(int decBell = 0; decBell < encryptedText.length(); decBell++)
		{
			decryptBellasotestBound = (char) (encryptedText.charAt(decBell));
			
			if(stringInBounds(encryptedText))
			{
				/*Returning the bellaso string encrypted to its original inputed string. m*/
				decryptBellasoReturned = (int) ((int)encryptedText.charAt(decBell) - bellasoStr.charAt(decBell % bellasoStr.length()));
				
				while((int)decryptBellasoReturned < LOWER_BOUND)
				{
					
					decryptBellasoReturned =  (char) (decryptBellasoReturned + RANGE);
					
				}
				
				decryptTheBellaso = decryptTheBellaso + (char)decryptBellasoReturned ;
				
			}
			
		}
		
		/*Returning the decrypt Bellaso string to return the bellaso string to its old inputed value */
		return decryptTheBellaso;
		
	}

}
