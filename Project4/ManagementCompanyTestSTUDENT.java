import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestSTUDENT {

	Property s1, s2, s3, s4, s5, s6;
	
	ManagementCompany testVal;
	
	@Before
	public void setUp() throws Exception {
		//student create a management company
		
		s1 = new Property ("Almost Noon", "San Diego", 5678.00, "Manny Terfanuel", 1,1,2,2);
		s2 = new Property ("Westside", "Austin", 4523, "Dilpreet Dhillon", 5,1,2,2);
		s3 = new Property ("Lake Terrace Creek", "Anchorage", 6712, "Sammy Atkinson", 8,1,2,2);
		
		testVal = new ManagementCompany("Mailey", "666666666", 7);
		
		testVal.addProperty(s1);
		testVal.addProperty(s2);
		testVal.addProperty(s3);
		
		//student add three properties, with plots, to mgmt co
		
	}

	@After
	public void tearDown() {
		//student set mgmt co to null  
		
		s1=s2=s3=s4=s5=s6=null;
		testVal=null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		
		s4 = new Property ("Transpirational", "Kaufman", 3615, "Stevenson Einstein", 2,6,6,2);
		s5 = new Property ("Coral Creek", "Eastpointe", 7823, "Candice Jones", 0,3,7,3);
		s6 = new Property ("Soo Many Properties", "Yorktownop", 4000, "Khur Cheesecakes", 6,5,2,2);
		
		assertEquals(testVal.addProperty(s4),3,0);
		assertEquals(testVal.addProperty(s5),4,0);
		assertEquals(testVal.addProperty(s6),-1,0);
		
		//student should add property with 4 args & default plot (0,0,1,1)
		//student should add property with 8 args
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
	}
 
	@Test
	public void testMaxRentProp() {

		String maxRentString = testVal.maxRentProp().split("\n")[3];
		assertTrue(maxRentString.contains("6712.0"));
		
		//student should test if maxRentProp contains the maximum rent of properties
		
	}

	@Test
	public void testTotalRent() {
		
		assertEquals(testVal.totalRent(),16913.0,0);
		
		//student should test if totalRent returns the total rent of properties
	
	}

}
