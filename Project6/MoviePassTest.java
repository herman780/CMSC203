
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MoviePassTest {
	MoviePass m1,m2,m3,m4,m5,m6;

	@Before
	public void setUp() throws Exception {
		//only seem 1 movie this month
		m1 = new MoviePass("Deadpool", "NR", 5,19,"NONE",12345,1, 0, 0);
		//seen 0 movies this month
		m2 = new MoviePass("Action Point", "NR", 2,12,"NONE",23456,0, 0, 0);
		//seen 1 movies this month
		m3 = new MoviePass("Adrift", "PG13", 3,20,"IMAX",34567,1, 0, 2);
		//seen 2 movies
		m4 = new MoviePass("Book Club", "PG13", 1,13,"IMAX",45678,2, 0 , 2);
		//seen 0 movies this month
		m5 = new MoviePass("Life of the Party", "PG13", 3,21,"3D",56789,0, 1, 0);
		//seen 3 movies this month
		m6 = new MoviePass("Overboard", "PG13", 2,14,"3D",67890,2, 2, 0);
	}

	@After
	public void tearDown() throws Exception {
		m1=m2=m3=m4=m5=m6=null;
	}

	@Test
	public void test() {
		assertEquals(14.796,m1.calculateTicketPrice(),.01);
		assertEquals(9.99,m2.calculateTicketPrice(),.01);
		assertEquals(14.796,m3.calculateTicketPrice(),.01);
		assertEquals(11.508,m4.calculateTicketPrice(),.01);
		assertEquals(9.99,m5.calculateTicketPrice(),.01);
		assertEquals(11.508,m6.calculateTicketPrice(),.01);
	}

}
