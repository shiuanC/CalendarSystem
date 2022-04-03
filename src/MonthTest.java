import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MonthTest {
	Month test202001;
	Month test202212;
	Month test202204;
	@BeforeEach
	void setUp() throws Exception {
		test202001 = new Month(2020, 1);
		test202212 = new Month(2022, 12);
		test202204 = new Month(2022, 4);
	}

	@AfterEach
	void tearDown() throws Exception {
		test202001 = null;
		test202212 = null;
		test202204 = null;
	}
	/*
	 * test method: constructors
	 * test month: 2020.1, 2022.12, 2022.4
	 */
	void testConstructors() {
		assertEquals(1, test202001.month);
		assertEquals(2020, test202001.year.year);
		assertEquals(31, test202001.numOfDays);
		assertEquals(12, test202212.month);
		assertEquals(2022, test202212.year.year);
		assertEquals(31, test202212.numOfDays);
		assertEquals(4, test202204.month);
		assertEquals(2022, test202204.year.year);
		assertEquals(30, test202204.numOfDays);
	}
	/*
	 * test method: Month.nextMonth()
	 * test month: 2020.1
	 */
	@Test
	void test_nextMonth_2020_1() {
		Month ans = new Month(2020, 2);
		Month test = test202001.nextMonth();
		assertEquals(ans.month, test.month);
		assertEquals(ans.year.year, test.year.year);
	}
	/*
	 * test method: Month.nextMonth()
	 * test month: 2022.12 (the last month of the year)
	 */
	@Test
	void test_nextMonth_2022_12() {
		Month ans = new Month(2023, 1);
		Month test = test202212.nextMonth();
		assertEquals(ans.month, test.month);
		assertEquals(ans.year.year, test.year.year);
	}
	/*
	 * test method: Month.printCalendar()
	 * test month: 2022.4
	 */
	@Test
	void test_printCalendar_2022_4() {
		String exceptString = 
				"Sun  Mon  Tue  Wed  Thu  Fri  Sat\n" + 
				"                         1    2    \n" + 
				"3    4    5    6    7    8    9    \n" + 
				"10   11   12   13   14   15   16   \n" + 
				"17   18   19   20   21   22   23   \n" + 
				"24   25   26   27   28   29   30   \n";
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(stream);
		PrintStream originalPrintStream = System.out;
		
		System.setOut(ps);
		test202204.printCalendar();
		System.setOut(originalPrintStream);
		
		String output = new String(stream.toByteArray());
		assertEquals(exceptString, output);
	}
	/*
	 * test method: Month.printCalendar()
	 * test month: 2022.1
	 */
	@Test
	void test_printCalendar_2020_1() {
		String exceptString = 
				"Sun  Mon  Tue  Wed  Thu  Fri  Sat\n" + 
				"               1    2    3    4    \n" + 
				"5    6    7    8    9    10   11   \n" + 
				"12   13   14   15   16   17   18   \n" + 
				"19   20   21   22   23   24   25   \n" + 
				"26   27   28   29   30   31   \n";
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(stream);
		PrintStream originalPrintStream = System.out;
		
		System.setOut(ps);
		test202001.printCalendar();
		System.setOut(originalPrintStream);
		
		String output = new String(stream.toByteArray());
		assertEquals(exceptString, output);
	}

}
