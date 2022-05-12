/**
 * This class will calculate holiday bonuses given a ragged array of doubles which represent the sales
 * for each store in each category. It will also take in bonus amount for the store with the highest
 * sales in a category, the bonus amount for the store with the lowest sales in a category and the bonus 
 * amount for all other stores. 
 * @author Herman Mann
 * Holiday Bonus class for calculating the holiday bonuses depending on the lowest and highest sales
 * of the store. 
 */
public class HolidayBonus extends java.lang.Object {
	
	/**
	 * This class will calculate holiday bonuses given a ragged array of doubles which represent the sales
	 * for each store in each category. It will also take in bonus amount for the store with the highest
	 * sales in a category, the bonus amount for the store with the lowest sales in a category and the bonus 
	 * amount for all other stores. 
	 * The constructor for HolidayBonus class. 
	 */
	public HolidayBonus()
	{
		
	}
	
	/**
	 * Calculates the holiday bonus for each store. 
	 * @param data - the two dimensional array of store sales.
	 * @param high - bonus for the highest store in a category.
	 * @param low - bonus for the lowest store in a category.
	 * @param other - bonus for all other stores in a category. 
	 * @return an array of the bonus for each store. 
	 */
	
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other)
	{
		int the_LengthofBonuses = data.length;
		
		double[] holidayBonusVal = new double[the_LengthofBonuses];
		
		int highestColHBonus = 0;
		int lowestColHBonus= 0;
		
		int totmaxColumnforBonus;
		
		/* First entry in the returned array [0] will symbolize/represent the holiday bonus for the
		 * store at [0] in the two - dimensional ragged array of doubles. 
		 */
		totmaxColumnforBonus = data[0].length;
		
		for(int colCount = 0; colCount < data.length; colCount++)
		{
			int lengthofDataforBonus = data[colCount].length;
			
			while(lengthofDataforBonus > totmaxColumnforBonus)
			{
				totmaxColumnforBonus = lengthofDataforBonus;
			}
			
			
		}
		
		for(int ind = 0; ind < totmaxColumnforBonus; ind++)
		{
			/*the bonus for the highest store in a given category */
			highestColHBonus = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, ind);
			
			/*the bonus for the lowest store in a given category */
			lowestColHBonus = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, ind);
			
			if(highestColHBonus == lowestColHBonus)
			{
				holidayBonusVal[highestColHBonus] = holidayBonusVal[highestColHBonus] + high;
			}
			
			else
			{
				for(int countofRow = 0; countofRow < holidayBonusVal.length; countofRow++)
				{
					int k = 0;
					
					/* the bonus amount for the store with the highest sales in a single
					 * individualized category. 
					 */
					if(countofRow == highestColHBonus)
					{
						if(data[countofRow][ind] > k)
							holidayBonusVal[countofRow] = holidayBonusVal[countofRow] + high;
					}
					
					
					/* the bonus amount for the store with the lowest sales in a 
					 * single individualized category.
					 */
					else if(countofRow == lowestColHBonus)
					{
						if(data[countofRow][ind] > k)
							holidayBonusVal[countofRow] = holidayBonusVal[countofRow] + low;
					}
					
					
					/* bonus amount for all other stores. */
					else if(data[countofRow].length > ind)
					{
						if(data[countofRow][ind] > k)
							holidayBonusVal[countofRow] = holidayBonusVal[countofRow] + other;
					}
				}
			}
		}
		
		return holidayBonusVal; /* returning the calculated holiday bonus of the store on the
		individualized categories. */
		
		
	}
	
	/**
	 * Calculates the total holiday bonuses. 
	 * @param data - the two dimensional array of store sales.
	 * @param high - bonus for the highest store in a category. 
	 * @param low - bonus for the lowest store in a category. 
	 * @param other - bonus for all other stores in a category. 
	 * @return the total of all holiday bonuses. 
	 */
	
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other)
	{
		
		double thetotalHolidayBonus = 0.0;
		
		double[] holidayBonusTotal = calculateHolidayBonus(data, high, low, other); /* calling the
		first method to calculate the total overall Holiday Bonus for each of the stores with the categories. */
		
		for(int totalBonus = 0; totalBonus < holidayBonusTotal.length; totalBonus++)
		{
		
			thetotalHolidayBonus = thetotalHolidayBonus + holidayBonusTotal[totalBonus]; /* summing up and getting the
			total holiday bonuses of the stores with different categories depending on the highest and lowest sales. */
		}
		
		
		return thetotalHolidayBonus; /* returning the total holiday bonus of the store of sales on the categories itself. */
	}
	
	

	
}


