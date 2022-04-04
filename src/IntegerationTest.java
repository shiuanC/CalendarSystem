import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntegerationTest {
	CalendarSystem testCalendarSystem;
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	ByteArrayInputStream inContent;
	
	@BeforeEach
	void setUp() throws Exception {
		testCalendarSystem = new CalendarSystem();
	}
	
    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

	@AfterEach
	void tearDown() throws Exception {
		testCalendarSystem = null;
	}
	
	/**
	 * test function: all function in Calender System
	 * test data: date = 2014/12/20, year = 2014/12/20
	 */
	@Test
	void test1() {
		String outData = "", output = "";
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(stream);
		PrintStream originalPrintStream = System.out;
		
		// 顯示日曆
		provideInput("2014/12/20");
		System.setOut(ps);
		testCalendarSystem.calendar.showMonthCalendar();
		System.setOut(originalPrintStream);
		
		output = new String(stream.toByteArray());
		outData += "請輸入欲查詢日期（年/月/日）：\n"
				+ "Sun  Mon  Tue  Wed  Thu  Fri  Sat\n"
				+ "     1    2    3    4    5    6    \n"
				+ "7    8    9    10   11   12   13   \n"
				+ "14   15   16   17   18   19   20   \n"
				+ "21   22   23   24   25   26   27   \n"
				+ "28   29   30   31   \n";
		assertEquals(outData, output);
		
		// 計算天干、生肖
		provideInput("2014");
		System.setOut(ps);
		testCalendarSystem.calendar.showChineseYearAnimal();
		System.setOut(originalPrintStream);
		
		output = new String(stream.toByteArray());
		outData += "請輸入欲查詢年：\n"
					+"2014是甲午年，屬馬\n";
		assertEquals(outData, output);
		
		// 計算天數
		provideInput("2014/12/20");
		System.setOut(ps);
		testCalendarSystem.calendar.showFutureDays();
		System.setOut(originalPrintStream);
		
		output = new String(stream.toByteArray());
		outData += "請輸入欲查詢日期（年/月/日）：\n"
				+ "2014/12/20距離今天已經過了2662天了\n\n";
		assertEquals(outData, output);
		
		// 計算日期
		provideInput("100");
		System.setOut(ps);
		testCalendarSystem.calendar.showNumOfDays();
		System.setOut(originalPrintStream);
		
		output = new String(stream.toByteArray());
		outData += "請輸入往後推算的天數：\n"
				+ "往後100天是2022/7/13\n";
		assertEquals(outData, output);
		
//		// 查看日記
		provideInput("2014/12/20");
		System.setOut(ps);
		testCalendarSystem.calendar.searchDiaryContent();
		System.setOut(originalPrintStream);
		
		output = new String(stream.toByteArray());
		outData += "請輸入欲查詢日期（年/月/日）：\n"
				+ "這天沒有任何紀錄，請按 F 進行編輯\n\n";
		assertEquals(outData, output);
	}

	/**
	 * test function: all function in Calender System
	 * test data: date = 2014/12/20, year = 2014/12/20
	 */
	
	@Test
	void test2() {
		String outData = "", output = "";
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(stream);
		PrintStream originalPrintStream = System.out;
		
		// 顯示日曆
		provideInput("2024/2/20");
		System.setOut(ps);
		testCalendarSystem.calendar.showMonthCalendar();
		System.setOut(originalPrintStream);
		
		output = new String(stream.toByteArray());
		outData += "請輸入欲查詢日期（年/月/日）：\n"
				+ "Sun  Mon  Tue  Wed  Thu  Fri  Sat\n"
				+ "                    1    2    3    \n"
				+ "4    5    6    7    8    9    10   \n"
				+ "11   12   13   14   15   16   17   \n"
				+ "18   19   20   21   22   23   24   \n"
				+ "25   26   27   28   29   \n";
		assertEquals(outData, output);
		
		// 計算天干、生肖
		provideInput("2024");
		System.setOut(ps);
		testCalendarSystem.calendar.showChineseYearAnimal();
		System.setOut(originalPrintStream);
		
		output = new String(stream.toByteArray());
		outData += "請輸入欲查詢年：\n"
					+"2024是甲辰年，屬龍\n";
		assertEquals(outData, output);
		
		// 計算天數
		provideInput("2024/2/20");
		System.setOut(ps);
		testCalendarSystem.calendar.showFutureDays();
		System.setOut(originalPrintStream);
		
		output = new String(stream.toByteArray());
		outData += "請輸入欲查詢日期（年/月/日）：\n"
				+ "2024/2/20距離今天還有687天\n\n";
		assertEquals(outData, output);
		
		// 計算日期
		provideInput("120");
		System.setOut(ps);
		testCalendarSystem.calendar.showNumOfDays();
		System.setOut(originalPrintStream);
		
		output = new String(stream.toByteArray());
		outData += "請輸入往後推算的天數：\n"
				+ "往後120天是2022/8/2\n";
		assertEquals(outData, output);
		
//		// 查看日記
		provideInput("2024/2/20");
		System.setOut(ps);
		testCalendarSystem.calendar.searchDiaryContent();
		System.setOut(originalPrintStream);
		
		output = new String(stream.toByteArray());
		outData += "請輸入欲查詢日期（年/月/日）：\n"
				+ "這天沒有任何紀錄，請按 F 進行編輯\n\n";
		assertEquals(outData, output);
	}

}
