import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HolidayBonus_STUDENT_TEST {
	
	private double[][] dataSetSTUDENT = {{4,5,6}, {7,8}, {9,10,11}};
	private double[][] dataSetSTUDENT1 = {{8.9, 3.6, 4.8}, {2.1}, {6.4, 1.4, 2.8}, {12.3, 10.1, 6.5, 9.5}};
	private double[][] dataSetSTUDENT2 = {{-2.7, -5.7, 6.6}, {-4.1, 9.3}, {1.5, -9.3}, {-4.1, 7.6, -5.1, 1.4}};

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalculateHolidayBonusA() {
		
		try {
			double [] result1 = HolidayBonus.calculateHolidayBonus(dataSetSTUDENT, 7000, 4000, 3000);
			assertEquals(12000.0, result1[0],.001);
			assertEquals(6000.0,result1[1],.001);
			assertEquals(21000.0,result1[2],.001);
			
			result1 = HolidayBonus.calculateHolidayBonus(dataSetSTUDENT1, 7000, 4000, 3000);
			assertEquals(9000.0, result1[0],.001);
			assertEquals(11000.0,result1[2],.001);
			assertEquals(28000.0,result1[3],.001);
			
			result1 = HolidayBonus.calculateHolidayBonus(dataSetSTUDENT2, 7000, 4000, 3000);
			assertEquals(7000.0, result1[0],.001);
			assertEquals(7000.0, result1[1],.001);
			assertEquals(7000.0, result1[2],.001);
			assertEquals(10000.0, result1[3],.001);
			
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
		
	}
	
	@Test 
	public void testCalculateHolidayBonusB() {
		
		try {
			double[] result2 = HolidayBonus.calculateHolidayBonus(dataSetSTUDENT, 2000, 350, 530);
			assertEquals(1050.0,result2[0],.001);
			assertEquals(1060.0,result2[1],.001);
			assertEquals(6000.0,result2[2],.001);
			
			result2 = HolidayBonus.calculateHolidayBonus(dataSetSTUDENT1, 2000, 350, 530);
			assertEquals(1590.0,result2[0],.001);
			assertEquals(350.0,result2[1],.001);
			assertEquals(1230.0,result2[2],.001);
			assertEquals(8000.0,result2[3],.001);
			
			result2 = HolidayBonus.calculateHolidayBonus(dataSetSTUDENT2, 2000, 350, 530);
			assertEquals(2000.0,result2[0],.001);
			assertEquals(2000.0,result2[1],.001);
			assertEquals(2000.0,result2[2],.001);
			assertEquals(2530.0,result2[3],.001);
		}
		catch (Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	@Test
	public void testCalculateTotalHolidayBonusA() {
		assertEquals(39000.0,HolidayBonus.calculateTotalHolidayBonus(dataSetSTUDENT, 7000, 4000, 3000),.001);
		assertEquals(52000.0,HolidayBonus.calculateTotalHolidayBonus(dataSetSTUDENT1, 7000, 4000, 3000),.001);
		assertEquals(31000.0,HolidayBonus.calculateTotalHolidayBonus(dataSetSTUDENT2, 7000, 4000, 3000),.001);
	}
	
	@Test
	public void testCalculateTotalHolidayBonusB() {
		assertEquals(8110.0,HolidayBonus.calculateTotalHolidayBonus(dataSetSTUDENT, 2000, 350, 530),.001);
		assertEquals(11170.0,HolidayBonus.calculateTotalHolidayBonus(dataSetSTUDENT1, 2000, 350, 530),.001);
		assertEquals(8530.0,HolidayBonus.calculateTotalHolidayBonus(dataSetSTUDENT2, 2000, 350, 530),.001);
	}

}
