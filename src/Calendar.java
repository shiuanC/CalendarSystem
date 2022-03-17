import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Calendar {
	void showMenu() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		String[] words;
		String date;
		String output;
		int num;
		
		System.out.println("計算天數");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
		LocalDate localDate = LocalDate.now();
		words = dtf.format(localDate).split("/");
		Date today = new Date (Integer.parseInt(words[0]), Integer.parseInt(words[1]), Integer.parseInt(words[2]));
		
		System.out.println("請輸入指令號碼或Ｑ（結束使用）");
		System.out.println();
		System.out.println("輸入指令：");
		System.out.println("1) A 顯示該月月曆");
		System.out.println("2) B 西元轉換干支、生肖");
		System.out.println("3) C 計算天數");
		System.out.println("4) D 計算日期");
		System.out.println("5) E 離開");
		
		do {
			char input = scanner.next().charAt(0);
			option = Character.toUpperCase(input);
			
			switch(option) {
			// Case A: Show the calendar of the month
			case 'A':
				System.out.print("請輸入欲查詢日期（年/月/日）：");
				date = scanner.next();
				words = date.split("/");
				Month month = new Month( Integer.parseInt(words[0]), Integer.parseInt(words[1]) );
				
				System.out.println();
				month.printCalendar();
				
				break;
			// Case B: Show the Chinese Year and the Animal
			case 'B':
				System.out.print("請輸入欲查詢年：");
				System.out.println();
				num = scanner.nextInt();
				Year year = new Year(num);
				output = Integer.toString(num) + "是" + year.getStemAndBranch() + "年，屬" + year.getZodiac();
				System.out.println(output);
				break;
			// Case C: Show the number of days until the date
			case 'C':
				System.out.print("請輸入欲查詢日期（年/月/日）：");
				date = scanner.next();
				System.out.println();
				
				words = date.split("/");
				Date futureDay = new Date (Integer.parseInt(words[0]), Integer.parseInt(words[1]), Integer.parseInt(words[2]));
				
				output = date + "距離今天還有" + Integer.toString(futureDay.getTotalDay() - today.getTotalDay()) + "天";
				System.out.println(output);
				System.out.println();
				
				break;
			// Case D: Show the date after the number of day
			case 'D':
				System.out.print("請輸入往後推算的天數：");
				num = scanner.nextInt();
				System.out.println();
				String futureDate = today.printFutureDate(num);
				System.out.println("往後" + Integer.toString(num) + "天是" + futureDate);
				
				break;
			// Case E: Exit
			case 'E':
				System.out.println("離開");
				break;
			// Case Q: Exit
			case 'Q':
				System.out.println("結束使用");
				break;
			// default: Get the new input
			default:
				System.out.println("錯誤：invalid option。只能輸入 A, B, C, D, E, 或 Q");
				break;
			}
		}while(option != 'Q' && option != 'E');
		
		scanner.close();
	}
}
