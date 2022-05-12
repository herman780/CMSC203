import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {

	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSetSTUDENT = {{4,5,6}, {7,8}, {9,10,11}};
	private double[][] dataSetSTUDENT1 = {{8.9, 3.6, 4.8}, {2.1}, {6.4, 1.4, 2.8}, {12.3, 10.1, 6.5, 9.5}};
	private double[][] dataSetSTUDENT2 = {{-2.7, -5.7, 6.6}, {-4.1, 9.3}, {1.5, -9.3}, {-4.1, 7.6, -5.1, 1.4}};
	
	private File inputFile,outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSetSTUDENT = dataSetSTUDENT1 = dataSetSTUDENT2 = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		assertEquals(60.0, TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT),.001);
		assertEquals(68.4, TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT1),.001);
		assertEquals(-4.6, TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT2),.001);
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		assertEquals(7.5, TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT),.001);
		assertEquals(6.218, TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT1),.001);
		assertEquals(-0.418, TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT2),.001);
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(30.0, TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT, 2),.001);
		assertEquals(38.4, TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT1, 3),.001);
		assertEquals(5.2, TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT2, 1),.001);
		
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(20.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT, 0),.001);
		assertEquals(15.1, TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT1, 1),.001);
		assertEquals(1.5, TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT2, 2),.001);
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		
		assertEquals(11.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT),.001);
		assertEquals(12.3, TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT1),.001);
		assertEquals(9.3, TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT2),.001);
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		double[][] array=null;
		try {
			TwoDimRaggedArrayUtility.writeToFile(dataSetSTUDENT2, outputFile);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		
		array = TwoDimRaggedArrayUtility.readFile(outputFile);
		assertEquals(-2.7, array[0][0],.001);
		assertEquals(-5.7, array[0][1],.001);
		assertEquals(6.6, array[0][2],.001);
		assertEquals(-4.1, array[1][0],.001);
		assertEquals(9.3, array[1][1],.001);
		assertEquals(1.5, array[2][0],.001);
		assertEquals(-9.3, array[2][1],.001);
		assertEquals(-4.1, array[3][0],.001);
		assertEquals(7.6, array[3][1],.001);
		assertEquals(-5.1, array[3][2],.001);
		assertEquals(1.4, array[3][3],.001);
	}

}
