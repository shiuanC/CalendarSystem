import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calendar {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
	LocalDate localDate = LocalDate.now();
	String[] words = dtf.format(localDate).split("/");
	Date today = new Date (Integer.parseInt(words[0]), Integer.parseInt(words[1]), Integer.parseInt(words[2]));
	Scanner scanner = new Scanner(System.in);
	Diary diary = new Diary();
	
	/***顯示 menu，依據不同的選項執行相應的功能。
	 * @param testInput
	 * @return void
	 * Examples:
	 * 		Calendar.showMenu('\0') 使用者可以根據選單的只是輸入指令
	 * 		Calendar.showMenu('E') 測試用，測試輸入 option 'E' 的結果
	 * Time Estimate: O(N), N = number of options
	 */
	void showMenu(char testInput) {
		char option = '\0';
		boolean exceptionFlag = false;
		diary.init();
		System.out.println("請輸入指令號碼或Ｑ（結束使用）");
		System.out.println();
		System.out.println("輸入指令：");
		System.out.println("1) A 顯示該月月曆");
		System.out.println("2) B 西元轉換干支、生肖");
		System.out.println("3) C 計算天數");
		System.out.println("4) D 計算日期");
		System.out.println("5) E 離開");
		
		
		do {
			char input;
			if(testInput != '\0') {
				input = testInput;
			}
			else if (exceptionFlag) {
				input = option;
				exceptionFlag = false;
			}
			else {
				input = scanner.next().charAt(0);
			}
			
			option = Character.toUpperCase(input);
			try {
				switch(option) {
				// Case A: Show the calendar of the month
				case 'A':
					showMonthCalendar();
					System.out.println("請輸入指令號碼或Ｑ（結束使用）");break;
				// Case B: Show the Chinese Year and the Animal
				case 'B':
					showChineseYearAnimal();
					System.out.println("請輸入指令號碼或Ｑ（結束使用）");break;
				// Case C: Show the number of days until the date
				case 'C':
					showFutureDays();
					System.out.println("請輸入指令號碼或Ｑ（結束使用）");break;
				// Case D: Show the date after the number of day
				case 'D':
					showNumOfDays();
					System.out.println("請輸入指令號碼或Ｑ（結束使用）");break;
				// Case E: Exit
				case 'E':
					System.out.println("離開");
					break;
				// Case E: Exit
				case 'F':
					System.out.println("編輯日記");
					addDiaryContent();
					System.out.println("請輸入指令號碼或Ｑ（結束使用）"); break;
				case 'G':
					System.out.println("搜尋日記");
					searchDiaryContent();
					System.out.println("請輸入指令號碼或Ｑ（結束使用）"); break;
				// Case Q: Exit
				case 'Q':
					System.out.println("結束使用");
					break;
				// default: Get the new input
				default:
					System.out.println("錯誤：invalid option。只能輸入 A, B, C, D, E, 或 Q");
					if(testInput != '\0')
						option = 'Q';
					break;
				}
			}catch(IllegalArgumentException ex){
				System.out.println("錯誤：" + ex.getMessage());
				exceptionFlag = true;
				continue;
			}catch(InputMismatchException ex){
				exceptionFlag = true;
				continue;
			}catch(ArrayIndexOutOfBoundsException ex){
				System.out.println("錯誤：" + ex.getMessage());
				exceptionFlag = true;
				continue;
			}
		}while(option != 'Q' && option != 'E');
		// save the diary to csv file
		scanner.close();
	}
	
	/***取得使用者想要查詢的日期，並呼叫 month 物件的 printCalendar() 顯示包含當日的月份。
	 * @param no parameter
	 * @return void
	 * Example: just call it
	 * Time Estimate: O(1)
	 */
	private void showMonthCalendar() {
		System.out.print("請輸入欲查詢日期（年/月/日）：");
		String date = scanner.next();
		String[] words = date.split("/");
		if(words.length == 3) {
			Date dateForCatchError = new Date( Integer.parseInt(words[0]), Integer.parseInt(words[1]),  Integer.parseInt(words[2]));
			Month month = new Month( Integer.parseInt(words[0]), Integer.parseInt(words[1]) );			
			System.out.println();
			month.printCalendar();
		}else {
			throw new ArrayIndexOutOfBoundsException("請確認格式是否正確，格式為：（年/月/日）需要有兩個斜線。");
		}
		
	}
	
	/***取得使用者想要查詢的年份，並呼叫 year 物件的 getStemAndBranch() 與 getZodiac()，顯示干支與生肖。
	 * @param no parameter
	 * @return void
	 * Example: just call it
	 * Time Estimate: O(1)
	 */
	private void showChineseYearAnimal() {
		System.out.print("請輸入欲查詢年：");
		int num = 1;
		try {
			num = scanner.nextInt();
			System.out.println();
			Year year = new Year(num);
			String output = Integer.toString(num) + "是" + year.getStemAndBranch() + "年，屬" + year.getZodiac();
			System.out.println(output);
		}catch(InputMismatchException ex){
			System.out.println("必須輸入整數");
			scanner = new Scanner(System.in);
			throw new InputMismatchException();
		}
	}
	
	/***取得使用者想要查詢的日期，呼叫 Date 物件的 getTotalDay() 取得該日與今天距離 1/1/1 的天數，並將兩數值相減，
	 ***依據相減的結果顯示不同的輸出結果（未來天數、過去天數、今天）。
	 * @param no parameter
	 * @return void
	 * Example: just call it
	 * Time Estimate: O(1)
	 */
	private void showFutureDays() {
		System.out.print("請輸入欲查詢日期（年/月/日）：");
		String date = scanner.next();
		System.out.println();
		
		String[] words = date.split("/");
		if(words.length == 3) {
			Date futureDay = new Date (Integer.parseInt(words[0]), Integer.parseInt(words[1]), Integer.parseInt(words[2]));
			int days = futureDay.getTotalDay() - today.getTotalDay();
			String output;
			if(days > 0) {
				output = date + "距離今天還有" + Integer.toString(days) + "天";
			}else if(days < 0) {
				output = date + "距離今天已經過了" + Integer.toString(-1*days) + "天了";
			}else {
				output = "就是今天！";
			}
			System.out.println(output);
			System.out.println();
		}else {
			throw new ArrayIndexOutOfBoundsException("請確認格式是否正確，格式為：（年/月/日）需要有兩個斜線。");
		}
		
	}
	
	/***取得使用者欲往後推算的天數，呼叫 Date 物件的 printFutureDate()，並顯示到指定之期還需要經過多少天。
	 * @param no parameter
	 * @return void
	 * Example: just call it
	 * Time Estimate: O(1)
	 */
	private void showNumOfDays() {
		System.out.print("請輸入往後推算的天數：");
		int num;
		try {
			num = scanner.nextInt();
			System.out.println();
			String futureDate = today.getFutureDate(num);
			System.out.println("往後" + Integer.toString(num) + "天是" + futureDate);
		}catch(InputMismatchException ex){
			System.out.println("必須輸入整數");
			scanner = new Scanner(System.in);
			throw new InputMismatchException();
		}
		
	}
	
	private void addDiaryContent() {
		System.out.print("請輸入想要紀錄的日期：");
		String date = scanner.next();
		String[] words = date.split("/");
		if(words.length == 3) {
			Date addDay = new Date (Integer.parseInt(words[0]), Integer.parseInt(words[1]), Integer.parseInt(words[2]));
			scanner.nextLine();
			System.out.println("請輸入內容：");
			String content = scanner.nextLine();
			diary.addContent(addDay, content);
			System.out.println();
		}else {
			throw new ArrayIndexOutOfBoundsException("請確認格式是否正確，格式為：（年/月/日）需要有兩個斜線。");
		}
	}
	
	private void searchDiaryContent() {
		System.out.print("請輸入想要搜尋的日期（年/月/日）：");
		String date = scanner.next();
		String[] words = date.split("/");
		if(words.length == 3) {
			Date searchDay = new Date (Integer.parseInt(words[0]), Integer.parseInt(words[1]), Integer.parseInt(words[2]));
			String output = diary.searchContent(searchDay);
			System.out.println(output);
			System.out.println();
		}else {
			throw new ArrayIndexOutOfBoundsException("請確認格式是否正確，格式為：（年/月/日）需要有兩個斜線。");
		}
	}
}
