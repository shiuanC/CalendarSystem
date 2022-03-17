import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateTest {
	Date test = null;
	@BeforeEach
	void setUp() throws Exception {
		test = new Date(2022, 3, 17);
	}

	@AfterEach
	void tearDown() throws Exception {
		test = null;
	}
	
	/**
	 * test method: constructor(int year, int month, int date);
	 * test year: 2022
	 * test month: 3
	 * test date: 17
	 */
	@Test
	void test1() {
		assertEquals(2022, test.year.year);
		assertEquals(3, test.month.month);
		assertEquals(17, test.date);
		assertEquals(4, test.day);
		//fail("Not yet implemented");
	}
	
	/**
	 * test method: Date.printFutureDate(int remainDays)
	 * test remainDays: 365
	 */
	@Test
	void test3() {
		 assertEquals("2023/3/17", test.printFutureDate(365));
		//fail("Not yet implemented");
	}
}
