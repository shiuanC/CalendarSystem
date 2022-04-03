import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateTest {
	Date test00010101 = null;
	Date test20241231 = null;
	
	@BeforeEach
	void setUp() throws Exception {
		test00010101 = new Date(1,1,1);
		test20241231 = new Date(2024, 12, 31);
	}

	@AfterEach
	void tearDown() throws Exception {
		test00010101 = null;
		test20241231 = null;
	}
	
	/**
	 * test method: constructors;
	 * test date: 1/1/1, 2024/12/31
	 */
	@Test
	void test_constructors() {
		assertEquals(1, test00010101.year.year);
		assertEquals(1, test00010101.month.month);
		assertEquals(1, test00010101.date);
		assertEquals(1, test00010101.day);
		assertEquals(2024, test20241231.year.year);
		assertEquals(12, test20241231.month.month);
		assertEquals(31, test20241231.date);
		assertEquals(2, test20241231.day);
	}
	
	void test_getTotalDay_00010101() {
		assertEquals(0, test00010101.getTotalDay());
	}
	void test_getTotalDay_20241231() {
		assertEquals(739250, test20241231.getTotalDay());
	}
	/**
	 * test method: Date.getFutureDate(int remainDays)
	 * test date: 1/1/1
	 * test remainDays: 365
	 */
	@Test
	void test_getFutureDate00010101() {
		 assertEquals("2/1/1", test00010101.getFutureDate(365));
	}
	/**
	 * test method: Date.getFutureDate(int remainDays)
	 * test date: 2024/12/31
	 * test remainDays: 0,1
	 */
	@Test
	void test_getFutureDate20240101() {
		assertEquals("2024/12/31", test20241231.getFutureDate(0));
		assertEquals("2025/1/1", test20241231.getFutureDate(1));
	}
	
}
