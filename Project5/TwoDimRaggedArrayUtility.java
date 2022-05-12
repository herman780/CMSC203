import java.util.Scanner;
import java.io.*;
//import java.io.File;
//import java.io.PrintWriter;

/**
 * @author Herman Mann
 *This specific utility works with 2 dimensional ragged arrays with a max of 10 rows and 10 columns.
 *This utility works with negative and positive numbers.
 *This is a utility class - there are no private data members attributed to 1 single class.
 */
public final class TwoDimRaggedArrayUtility extends java.lang.Object {


	/**
	 * This specific utility works with 2 dimensional ragged arrays with a max of 10 rows and 10 columns.
	 * This utility works with negative and positive numbers.
	 * This is a utility class - there are no private data members attributed to 1 single class.
	 * This is a public constructor of the TwoDimRaggedArrayUtility class. 
	 */
	
	public TwoDimRaggedArrayUtility()
	{
		
	}
	
	
	/**
	 * Returns the average of the elements in the two dimensional array.
	 * @param data - the two dimensional array getting the average of. 
	 * @return the average of the elements in the two dimensional array (total of elements/num of elements).
	 */
	public static double getAverage(double [][] data)
	{
		double average = 0.0; /* variable needed for getting the average (total of elements/ num of elements)
		,returning it as a double. */
		
		double sum = 0.0; /* needed for calculating sum of the total of elements in the two dimensional array. */
		
		double totalNumberOfElements = 0.0;
		
		for(int row = 0; row < data.length; row++)
		{
			int eachIndividElement = data[row].length;
			
			totalNumberOfElements = totalNumberOfElements + eachIndividElement; /* calculating the number of elements and adding them
			together to get the overall total num of elements as a whole */
			
			for(int col = 0; col < data[row].length; col++)
			{
				double individElements =  data[row][col];
				
				sum = sum + individElements; /* total of elements and adding them up as a total sum */
				
			}
			
			average = sum / totalNumberOfElements; /* (number of total elements dividing it by the number of each individual 
			elements there are individually). */

		}
		
		return average; /* returns the average of the two dimensional ragged array. */
		
	}
	
	/**
	 * Returns the total of the selected column in the two dimensional array index 0 refers to the
	 * first column. If a row in the two dimensional array doesn't have this column index, it is not
	 * an error, it doesn't participate in this method. 
	 * @param data - the two dimensional array.
	 * @param col - the column index to take the total of (0 refers to the first column).
	 * @return the total of the column.
	 */
	
	public static double getColumnTotal(double[][] data, int col)
	{
		//double sum = 0.0; 
		
		double colSum = 0.0;
		
		int colSize = data[0].length;
		
		//double colStart[] = new double[colSize];
		
		for(int Row = 0; Row < data.length; Row++)
		{
			for(int col2 = 0; col2 < data[Row].length; col2++)
			{
				
				if(col2 == col) /* if a row in the 2-d array doesn't have this column index, it is not an error, 
				it doesn't participate in this method as well. */
				{
					colSum = colSum + data[Row][col]; /* summing up each individual selected column sum */
				}
			}
		}
	
		return colSum; /* returning the total of the individual selected column in the 2-d array. */
		
	}
	
	/**
	 * Returns the largest element in the two dimensional array.
	 * @param data - the two dimensional array. 
	 * @return the largest element in the two dimensional array. 
	 */
	
	public static double getHighestInArray(double[][] data)
	{
		double max = 0.0;
		
		for(int row = 0; row < data.length; row++)
		{
			for(int col = 0; col < data[row].length; col++)
			{
				double elementInHighestInArray = data[row][col];
				
				if(max < elementInHighestInArray )
				{
					max = elementInHighestInArray; /* max will be assigned to the highest element, depending on if and
					only if it is greater than the max element */
					
				}
			}
		}
		
		return max; /* returning the largest number(element) in the 2-d array. */
		
	}
	
	/**
	 * Returns the largest element of the selected column in the two dimensional array index 0 refers
	 * to the first column. If a row in the two dimensional array doesn't have this column index, it is
	 * not an error, it doesn't participate in this method. 
	 * @param data - the two dimensional array.
	 * @param col - the column index to find the largest element of (0 refers to the first column).
	 * @return the largest element of the column. 
	 */
	
	public static double getHighestInColumn(double[][] data, int col)
	{
		double max = 0;
		
		for(int row = 0; row < data.length; row++)
		{
			for(int Col = 0; Col < data[row].length; Col++)
			{
				if(Col == col) /* if a row in the 2-d array doesn't have this column index, it is not
				an error, it doesn't participate in this method. */
					
					if(data[row][col] > max)
					{
						max = data[row][col]; 
					}
				
			}
		}
		
		return max; /* returning the largest element of the individualized column. */
		
	}
	
	/**
	 * Returns index of the largest element of the selected column in the two dimensional array index 0 refers
	 * to the first column. If a row in the two dimensional array doesn't have this column index, it is not an
	 * error, it doesn't participate in this method. 
	 * @param data - the two dimensional array. 
	 * @param col - the column index to find the largest element (0 refers to the first column).
	 * @return the index of the largest element of the column. 
	 */
	
	public static int getHighestInColumnIndex(double[][] data, int col)
	{
		int k = 0; /* needed for returning the highest column index. */
		double max = -100000;
		
		for(int row = 0; row < data.length; row++)
		{
			
			for(int Col = 0; Col < data[row].length; Col++)
			{
				
				if(Col == col) /* if a row in the 2-d array doesn't have this column index, it is not an error,
				it doesn't participate in this method. */
				{
					if(data[row][col] > max)
					{
						max = data[row][col];
						k = row; /* the index of the largest element of the column */
					}
				}
			}
		}
		
		return k; /* return the highest column index. */
		
	}
	
	/**
	 * Returns the largest element of the selected row in the two dimensional array index 0 refers
	 * to the first row. 
	 * @param data - the two dimensional array. 
	 * @param row - the row index to find the largest element of (0 refers to the first row). 
	 * @return the largest element of the row. 
	 */
	
	public static double getHighestInRow(double[][] data, int row)
	{
		double maxvalHighestInRow = 0; /* needed for getting the highest/largest element of the row. */
		
		for(int rowMax = 0; rowMax < data[row].length; rowMax++)
		{
			double highestElementInRow = data[row][rowMax];
			
			if(highestElementInRow > maxvalHighestInRow)
			{
				maxvalHighestInRow = highestElementInRow;
			}
		}
		
		return maxvalHighestInRow; /* returning the largest element of the row */
		
	}
	
	/**
	 * Returns the largest element of the selected row in the two dimensional array index 0
	 * refers to the first row. 
	 * @param data - the two dimensional array. 
	 * @param row - the row index to find the largest element of (0 refers to the first row).
	 * @return the largest element of the row.
	 */
	
	public static int getHighestInRowIndex(double[][] data, int row)
	{
		int i = 0; /* needed for highest index in the row to return it later on. */
		
		double initialMaxSet = data[row][0];
		
		for(int k = 0; k < data[row].length; k++)
		{

			double elementHighestInRowIndex = data[row][k];
			
			if(elementHighestInRowIndex > initialMaxSet)
			{
				
				i = k; /* the row index and assigning it to find the largest element of row. */
			}
			
			
		}
		return i; /* returning the largest index of the individualized row. */
		
	}
	
	/**
	 * Returns the smallest element in the two dimensional array.
	 * @param data - the two dimensional array. 
	 * @return the smallest element in the two dimensional array. 
	 */
	
	public static double getLowestInArray(double[][] data)
	{
		double min = 999; /* needed for getting the lowest element in the 2-d array. */
		
		for(int row = 0; row < data.length; row++)
		{
			for(int col = 0; col < data[row].length; col++)
			{
				double elementLowestInArray = data[row][col];
				
				if(min > elementLowestInArray)
				{
					min = elementLowestInArray;
				}
			}
		}
		
		return min; /* returning the smallest number element in the 2-d array. */
		
	}
	
	/**
	 * Returns the smallest element of the selected column in the two dimensional array index 0 refers
	 * to the first column. If a row in the two dimensional array doesn't have this column index, it is
	 * not an error, it doesn't participate in this method. 
	 * @param data - the two dimensional array. 
	 * @param col - the column index to find the smallest element of (0 refers to the first column).
	 * @return the smallest element of the column. 
	 */
	
	public static double getLowestInColumn(double[][] data, int col)
	{
		double minvalLowestInColumn = 7999; /* needed for finding the lowest element of the column. */
		
		for(int jk = 0; jk < data.length; jk++)
		{
			
			for(int k = 0; k < data[jk].length; k++)
			{
			
				if(k == col)
					
					if(minvalLowestInColumn > data[jk][col])
					{
						minvalLowestInColumn = data[jk][col];
					}
				
			}
			
		}
		

		return minvalLowestInColumn; /* returning the smallest element of the column. */
		
	}
	
	/**
	 * Returns the index of the smallest element of the selected column in the two dimensional array index 0
	 * refers to the first column. If a row in the two dimensional array doesn't have this column index, it is 
	 * not an error, it doesn't participate in this method. 
	 * @param data - the two dimensional array. 
	 * @param col - the column index to find the smallest element of (0 refers to the first column).
	 * @return the index of the smallest element of the column. 
	 */
	
	public static int getLowestInColumnIndex(double[][] data, int col)
	{
		int j = 0;
		double min = 899999;
		
		for(int row = 0; row < data.length; row++)
		{
			for(int Col = 0; Col < data[row].length; Col++)
			{
				if(Col == col)
				{
					while(min > data[row][col])
					{
						min = data[row][col];
						j = row;
					}
				}
			}
		}
		
		return j; /* returning the lowest column index of the column of the 2-d array. */
		
	}
	
	/**
	 * Returns the smallest element of the selected row in the two dimensional array index 0 refers
	 * to the first row. 
	 * @param data - the two dimensional array. 
	 * @param row - the row index to find the smallest element of (0 refers to the first row).
	 * @return the smallest element of the row. 
	 */
	
	public static double getLowestInRow(double[][] data, int row)
	{
		double minvalOfLowestInRow = 799;
		
		for(int j = 0; j < data[row].length; j++)
		{
			while(data[row][j] < minvalOfLowestInRow)
			{
				minvalOfLowestInRow = data[row][j];
			}
		}
		
		return minvalOfLowestInRow; /* returning the smallest number element of the row (individual). */
		
	}
	
	/**
	 * Returns the index of the smallest element of the selected row in the two dimensional array index
	 * 0 refers to the first row. 
	 * @param data - the two dimensional array. 
	 * @param row - the row index to find the smallest element of (0 refers to the first row). 
	 * @return the index of the smallest element of the row. 
	 */
	public static int getLowestInRowIndex(double[][] data, int row)
	{
		int j = 0;
		
		double min = data[row][0];
		
		for(int low = 0; low < data[row].length; low++)
		{
			double smallestElementofRow = data[row][low];
			
			while(smallestElementofRow < min)
			{
				min = smallestElementofRow ;
				j = low;
			}
			
			
		}
		
		return j; /* returning the lowest index in a given row of the 2-d array. */
		
	}
	
	/**
	 * Returns the total of the selected row in the two dimensional array index 0
	 * refers to the first row. 
	 * @param data - the two dimensional array. 
	 * @param row - the row index to take the total of (0 refers to the first row). 
	 * @return the total of the row. 
	 */
	
	public static double getRowTotal(double[][] data, int row)
	{
		double totalofRow = 0.0;
		
		double sum = 0.0;
		
		for(int j = 0; j < data[row].length; j++)
		{
			double gettingRowTotal = data[row][j];
			
			sum = sum + gettingRowTotal; /* summing up and getting the total of the selected row in the 2-d array. */
		}
		
		return sum;/* returning the total of a row */
		
	}
	
	/**
	 * Returns the total of all the elements of the two dimensional array. 
	 * @param data - the two dimensional array getting total of. 
	 * @return the sum of all the elements in the two dimensional array. 
	 */
	public static double getTotal(double[][] data)
	{
		double sum = 0.0;
		
		for(int row = 0; row < data.length; row++)
		{
			for(int col = 0; col < data[row].length; col++)
			{
				double gettingTheTotal = data[row][col];
				
				sum = sum + gettingTheTotal; /* summing up and getting the total of all the elements of the 2-d array. */
			}
		}
		
		return sum; /* returning the sum of all the elements in the 2-d array. */
		
	}
	
	/**
	 * Reads from a file and returns a ragged array of doubles. The maximum rows is 10 and the maximum columns for each
	 * row is 10. Each row in the file is separated by a new line. Each element in the row is separated by a space. Suggestion:
	 * You need to know how many rows and how many columns there are for each row to create a ragged array. 1. Read the doubles from
	 * the file into an a temporary array[10][10] of Strings which was initialized to nulls. 2. Find out how many rows there are (any
	 * row that has the first element != null is a valid row). 3. Create the array based on the num of rows, i.e. double[][]array = 
	 * new double[#rows][]. 4. Determine the number of columns for the first row (any element != null is a valid element). 5. Create the
	 * first row, i.e. array[0] = new double[#columns]. 6. Put the values from the temporary array into in the row (don't forget to convert
	 * from strings to doubles). 7. Repeat for all rows. 
	 * @param file - the file to read from. 
	 * @return a two dimensional ragged (depending on data) array of doubles if the file is not empty,
	 * returns a null if file is empty. 
	 * @throws java.io.FileNotFoundException - if file is not valid. 
	 */
	
	public static double [][] readFile(java.io.File file) throws java.io.FileNotFoundException
	{
		Scanner inputFile = new Scanner(file); /* needed for reading a file of the data inputed from the write to file method. */
		
		String [][] inputFile1 = null; /* temporary file initially set to nulls. */
		
		int max_NumberOfRows = 10; /* total number of max rows there can be within a individual column */
		
		String [][] arrayTemp = new String[max_NumberOfRows][];
		
		int rowStartIndex = 0;
		
		int max_NumberofColumnsinRow = 10; /* max number of columns there can be within a individual row. */
		
		double totalArray [][] = null;
		
		Scanner inputrowCol;
		
		do
		{
			String nextLineofData = inputFile.nextLine();
			
			String [] r = nextLineofData.split(" ");
			
			arrayTemp[rowStartIndex] = new String [r.length];
			
			for(int j = 0; j < r.length; j++)
			{
				arrayTemp[rowStartIndex][j] = r[j];
			}
			
			rowStartIndex++;
			
		}while(inputFile.hasNextLine());
		
		double [][] inputdataConverstoDouble = new double[rowStartIndex][];
		
		for(int k = 0; k < rowStartIndex; k++)
		{
			inputdataConverstoDouble[k] = new double [arrayTemp[k].length];
			
			for(int j = 0; j < arrayTemp[k].length; j++)
			{
				inputdataConverstoDouble[k][j] = Double.parseDouble(arrayTemp[k][j]); /* conversion of the data
				to ragged array of doubles to the file. */
			}
			
		}
		
		inputFile.close(); /* closing the opened file. */
		
		
		return inputdataConverstoDouble; /* returning the read data of double ragged arrays in the file. */ 
	
	}
	
	
	/**
	 * Writes the ragged array of doubles into the file. Each row is on a separate line within the file
	 * and each double is separated by a space. 
	 * @param data - two dimensional ragged array of doubles.
	 * @param outputFile - the file to write to. 
	 * @throws FileNotFoundException - if outputFile is not valid. 
	 */
	
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException
	{
		PrintWriter theoverallOutputFile = new PrintWriter(outputFile); /* writing the data of
		ragged array of doubles to the given file. */
		
		int ro; /* the row of the data of ragged array of doubles in the 2-d array.*/
		int Col; /* the column of the data of ragged array of doubles in the 2-d array. */
		
		StringBuilder outputFiletoString = new StringBuilder(); /* converts the data of the ragged array of doubles
		to a toString method output type */
		
		for(ro = 0; ro < data.length; ro++)
		{
			for(Col = 0; Col < data[ro].length-1; Col++)
			{
				double datawriteToFile = data[ro][Col];
				String spacebetweendataLine = " ";
				
				 theoverallOutputFile.print(datawriteToFile + spacebetweendataLine); /*the information being transferred/sent out
				 to the written file. */
			}
			
			
			 theoverallOutputFile.println(data[ro][Col]);
			
		}
		
		theoverallOutputFile.close(); /* closing the write to file. */
		
	}

}
