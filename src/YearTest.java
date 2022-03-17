import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class YearTest {

	Year test= null;
	
	@BeforeEach
	void setUp() throws Exception {
		test = new Year(2022);
	}

	@AfterEach
	void tearDown() throws Exception {
		test = null;
	}

	@Test
	void test1() {
		assertEquals(2022, test.year);
		assertEquals( 9, test.stem);
		assertEquals( 3, test.branch);
	}
	void test2() {
		assertEquals(false, test.isLeap());
	}
	void test3() {
		assertEquals("壬寅", test.getStemAndBranch());
	}
	void test4() {
		assertEquals("虎", test.getZodiac());
	}


}
