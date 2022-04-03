import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalendarTest {
	Calendar test = null;

	@BeforeEach
	void setUp() throws Exception {
		test = new Calendar();
	}

	@AfterEach
	void tearDown() throws Exception {
		test = null;
	}
	/**
	 * test method: Calendar.showMenu();
	 * test input: E (the valid input)
	 */
	@Test
	void testInputE() {
		String exceptString = "請輸入指令號碼或Ｑ（結束使用）\n\n" + 
				"輸入指令：\n" + 
				"1) A 顯示該月月曆\n" + 
				"2) B 西元轉換干支、生肖\n" + 
				"3) C 計算天數\n" + 
				"4) D 計算日期\n" + 
				"5) E 離開\n" + 
				"離開\n";
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(stream);
		PrintStream originalPrintStream = System.out;
		
		System.setOut(ps);
		test.showMenu('E');
		System.setOut(originalPrintStream);
		
		String output = new String(stream.toByteArray());
		assertEquals(exceptString, output);
	}
	/**
	 * test method: Calendar.showMenu();
	 * test input: L (the invalid input)
	 */
	@Test
	void testInputL() {
		String exceptString = "請輸入指令號碼或Ｑ（結束使用）\n\n" + 
				"輸入指令：\n" + 
				"1) A 顯示該月月曆\n" + 
				"2) B 西元轉換干支、生肖\n" + 
				"3) C 計算天數\n" + 
				"4) D 計算日期\n" + 
				"5) E 離開\n" + 
				"錯誤：invalid option。只能輸入 A, B, C, D, E, 或 Q\n";
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(stream);
		PrintStream originalPrintStream = System.out;
		
		System.setOut(ps);
		test.showMenu('L');
		System.setOut(originalPrintStream);
		
		String output = new String(stream.toByteArray());
		assertEquals(exceptString, output);
	}

}
