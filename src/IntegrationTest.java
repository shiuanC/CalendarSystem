import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntegrationTest {
	CalendarSystem testCalendarSystem;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;
    
    String output = "", outData = "";
	String outMenu = "請輸入指令號碼或Ｑ（結束使用）\n\n"
			+ "輸入指令：\n"
			+ "1) A 顯示該月月曆\n"
			+ "2) B 西元轉換干支、生肖\n"
			+ "3) C 計算天數\n"
			+ "4) D 計算日期\n"
			+ "5) F 新增日記\n"
			+ "6) G 查看日記\n"
			+ "7) E 離開\n"
			+ "";
	String outLeave = "請輸入指令號碼或Ｑ（結束使用）\n" + "離開\n";

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
	 * test function: all function in Calendar System
	 * test data: date = 2014/12/20, year = 2014/12/20
	 */
	@Test
	void test1() {
		
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		
		// 顯示日曆
		provideInput("A\n2014/12/20\nE\n");
		System.setOut(new PrintStream(stream));
		testCalendarSystem.calendar.showMenu('\0');
		System.setOut(System.out);
		
		output = new String(stream.toByteArray());
		outData = outMenu + "請輸入欲查詢日期（年/月/日）：\n"
				+ "Sun  Mon  Tue  Wed  Thu  Fri  Sat\n"
				+ "     1    2    3    4    5    6    \n"
				+ "7    8    9    10   11   12   13   \n"
				+ "14   15   16   17   18   19   20   \n"
				+ "21   22   23   24   25   26   27   \n"
				+ "28   29   30   31   \n" + outLeave;
		assertEquals(outData, output);
		
		// 計算天干、生肖
		provideInput("B\n2014\nE\n");
		System.setOut(new PrintStream(stream));
		testCalendarSystem.calendar.showMenu('\0');
		System.setOut(System.out);
		
		output = new String(stream.toByteArray());
		outData += outMenu + "請輸入欲查詢年：\n"
					+"2014是甲午年，屬馬\n" + outLeave;
		assertEquals(outData, output);
		
		// 計算天數
		provideInput("C\n2014/12/20\nE\n");
		System.setOut(new PrintStream(stream));
		testCalendarSystem.calendar.showMenu('\0');
		System.setOut(System.out);
		
		output = new String(stream.toByteArray());
		outData += outMenu + "請輸入欲查詢日期（年/月/日）：\n"
				+ "2014/12/20距離今天已經過了2662天了\n\n" + outLeave;
		assertEquals(outData, output);
		
		// 計算日期
		provideInput("D\n100\nE\n");
		System.setOut(new PrintStream(stream));
		testCalendarSystem.calendar.showMenu('\0');
		System.setOut(System.out);
		
		output = new String(stream.toByteArray());
		outData += outMenu + "請輸入往後推算的天數：\n"
				+ "往後100天是2022/7/13\n" + outLeave;
		assertEquals(outData, output);
		
		// 查看日記
		provideInput("G\n2014/12/20\nE\n");
		System.setOut(new PrintStream(stream));
		testCalendarSystem.calendar.showMenu('\0');
		System.setOut(System.out);
		
		output = new String(stream.toByteArray());
		outData += outMenu + "查看日記\n請輸入欲查詢日期（年/月/日）：\n"
				+ "這天沒有任何紀錄，請按 F 進行編輯\n\n" + outLeave;
		assertEquals(outData, output);
		
		// 新增日記
		provideInput("F\n2014/12/20 \n test2014/12/20 \nE\n");
		System.setOut(new PrintStream(stream));
		testCalendarSystem.calendar.showMenu('\0');
		System.setOut(System.out);
		
		output = new String(stream.toByteArray());
		outData += outMenu + "新增日記\n請輸入想要紀錄的日期（年/月/日）："
				+ "請輸入內容：\n\n" + outLeave;
		assertEquals(outData, output);
	}

	/**
	 * test function: all function in Calendar System
	 * test data: date = 2014/12/20, year = 2014/12/20
	 */
	
	@Test
	void test2() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		
		// 顯示日曆
		provideInput("A\n2024/2/20\nE\n");
		System.setOut(new PrintStream(stream));
		testCalendarSystem.calendar.showMenu('\0');
		System.setOut(System.out);
		
		output = new String(stream.toByteArray());
		outData += outMenu + "請輸入欲查詢日期（年/月/日）：\n"
				+ "Sun  Mon  Tue  Wed  Thu  Fri  Sat\n"
				+ "                    1    2    3    \n"
				+ "4    5    6    7    8    9    10   \n"
				+ "11   12   13   14   15   16   17   \n"
				+ "18   19   20   21   22   23   24   \n"
				+ "25   26   27   28   29   \n" + outLeave;
		assertEquals(outData, output);
		
		// 計算天干、生肖
		provideInput("B\n2024\nE\n");
		System.setOut(new PrintStream(stream));
		testCalendarSystem.calendar.showMenu('\0');
		System.setOut(System.out);
		
		output = new String(stream.toByteArray());
		outData += outMenu + "請輸入欲查詢年：\n"
					+"2024是甲辰年，屬龍\n" + outLeave;
		assertEquals(outData, output);
		
		// 計算天數
		provideInput("C\n2024/2/20\nE\n");
		System.setOut(new PrintStream(stream));
		testCalendarSystem.calendar.showMenu('\0');
		System.setOut(System.out);
		
		output = new String(stream.toByteArray());
		outData += outMenu + "請輸入欲查詢日期（年/月/日）：\n"
				+ "2024/2/20距離今天還有687天\n\n" + outLeave;
		assertEquals(outData, output);
		
		// 計算日期
		provideInput("D\n120\nE\n");
		System.setOut(new PrintStream(stream));
		testCalendarSystem.calendar.showMenu('\0');
		System.setOut(System.out);
		
		output = new String(stream.toByteArray());
		outData += outMenu + "請輸入往後推算的天數：\n"
				+ "往後120天是2022/8/2\n" + outLeave;
		assertEquals(outData, output);
		

		
		// 新增日記
		provideInput("F\n2024/2/20 \ntest2024/2/20\nE\n");
		System.setOut(new PrintStream(stream));
		testCalendarSystem.calendar.showMenu('\0');
		System.setOut(System.out);
		
		output = new String(stream.toByteArray());
		outData += outMenu +  "新增日記\n請輸入想要紀錄的日期（年/月/日）："
				+ "請輸入內容：\n\n" + outLeave;
		assertEquals(outData, output);
		
//		// 查看日記
		provideInput("G\n2024/2/20\nE\n");
		System.setOut(new PrintStream(stream));
		testCalendarSystem.calendar.showMenu('\0');
		System.setOut(System.out);
		
		output = new String(stream.toByteArray());
		outData += outMenu +  "查看日記\n請輸入欲查詢日期（年/月/日）：\n"
				+ "test2024/2/20\n\n" + outLeave;
		assertEquals(outData, output);
	}
}
