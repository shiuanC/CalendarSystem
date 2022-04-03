import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class YearTest {
	Year test1900;
	Year test2000;
	Year test2020;
	
	@BeforeEach
	void setUp() throws Exception {
		test1900 = new Year(1900);
		test2000 = new Year(2000);
		test2020 = new Year(2020);
	}

	@AfterEach
	void tearDown() throws Exception {
		test1900 = null;
		test2000 = null;
		test2020 = null;
	}
	/*
	 * test method: constructors
	 * test month: 1900, 2000, 2020
	 */
	@Test
	void test_constructor() {
		assertEquals(1900, test1900.year);
		assertEquals( 7, test1900.stem);
		assertEquals( 1, test1900.branch);
		assertEquals(2000, test2000.year);
		assertEquals( 7, test2000.stem);
		assertEquals( 5, test2000.branch);
		assertEquals(2020, test2020.year);
		assertEquals( 7, test2020.stem);
		assertEquals( 1, test2020.branch);
	}
	
	/*
	 * test method: Year.isLeap()
	 * test year: 1900
	 */
	@Test
	void test_isLeap_1900() {
		assertEquals(false, test1900.isLeap());
	}
	/*
	 * test method: Year.isLeap()
	 * test year: 2000
	 */
	@Test
	void test_isLeap_2000() {
		assertEquals(true, test2000.isLeap());
	}
	/*
	 * test method: Year.isLeap()
	 * test year: 2020
	 */
	@Test
	void test_isLeap_2020() {
		assertEquals(true, test2020.isLeap());
	}
	/*
	 * test method: Year.getStemAndBranch()
	 * test year: 1900
	 */
	@Test
	void test_getStemAndBranch_1900() {
		assertEquals("庚子", test1900.getStemAndBranch());
	}
	/*
	 * test method: Year.getStemAndBranch()
	 * test year: 2000
	 */
	@Test
	void test_getStemAndBranch_2000() {
		assertEquals("庚辰", test2000.getStemAndBranch());
	}
	/*
	 * test method: Year.getStemAndBranch()
	 * test year: 2020
	 */
	@Test
	void test_getStemAndBranch_2020() {
		assertEquals("庚子", test2020.getStemAndBranch());
	}
	/*
	 * test method: Year.getZodiac()
	 * test year: 1900
	 */
	@Test
	void test_getZodiac_1900() {
		assertEquals("鼠", test1900.getZodiac());
	}
	/*
	 * test method: Year.getZodiac()
	 * test year: 2000
	 */
	@Test
	void test_getZodiac_2000() {
		assertEquals("龍", test2000.getZodiac());
	}
	/*
	 * test method: Year.getZodiac()
	 * test year: 2020
	 */
	@Test
	void test_getZodiac_2020() {
		assertEquals("鼠", test2020.getZodiac());
	}


}
