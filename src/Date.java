
public class Date {
	int date; // 日
	int day; // 星期
	Month month; // 月
	Year year; // 年
	
	/*** 透過日期建立 Date 物件。
	 * @param year, month, date
	 * @throws IllegalArgumentException
	 * 若輸入了不合法的日期，就會 throw IllegalArgumentException
	 * @return Date object
	 * Example: Date(2022/4/1) return an object Date with the record of 2022/4/1
	 * Time Estimate: O(1)
	 */
	Date(int year, int month, int date){
		this.year = new Year(year);
		this.month = new Month(year, month);
		if(date < 1 || date > this.month.numOfDays){
			throw new IllegalArgumentException("輸入了錯誤的天數");
		}
		this.date = date;
		day = getDayNum(year, month, date);
	}
	
	/*** 回傳該天是星期幾，因為在 constructor 已經確定日期合法，故不會有錯誤的情形。
	 * @param year, month, date
	 * @return week day of the date
	 * Example: Date(2022/4/1) return 5 (Friday)
	 * Time Estimate: O(1)
	 */
	private int getDayNum(int year, int month, int date) {
		int y = year;
		int m = month;
		int d = date;
		
		int[] base = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
		if( m < 3) y -= 1;
		
		return ( y + y/4 - y/100 + y/400 + base[m-1] + d) % 7; // (total days) % 7
	}
	
	/*** 回傳該天之於 1/1/1 過了多少天。
	 * @param no parameter
	 * @return total day pass since 1/1/1
	 * Example: Date(1/1/2) return 1 (one day pass)
	 * Time Estimate: O(1)
	 */
	public int getTotalDay() {
		int y = year.year;
		int m = month.month;
		int d = date;
		
		int totalDays = d;
		for(int i = 1; i < m; i++) {
			Month previousMonth = new Month(y, i);
			totalDays += previousMonth.numOfDays;
		}
		y--;
		return ( y*365 + y/4 - y/100 + y/400 + totalDays);
	}
	/*** 根據輸入的天數計算日期。
	 * @param remainDays
	 * @throws IllegalArgumentException
	 * 只支援計算未來的日期，remainDays 需要是正整數。
	 * @return a string of the future date
	 * Example: Object Date(2022/4/1) 呼叫 Date.getFutureDate(1) 會得到 2022/4/2
	 * Time Estimate: O(n), n = remainDays
	 */
	public String getFutureDate(int remainDays) {
		if(remainDays < 0) {
			throw new IllegalArgumentException("請輸入大於 0 的數");
		}
		// recursion method
		if(remainDays <= month.numOfDays-date) {
			return Integer.toString(year.year) + "/" + Integer.toString(month.month) + "/" + Integer.toString(remainDays+date);
		}else {
			int newMonth, newYear;
			if(month.month == 12) {
				newMonth = 1;
				newYear = year.year +1;
			}else {
				newMonth = month.month + 1;
				newYear = year.year;	
			}
			Date next = new Date( newYear, newMonth, 1);
			remainDays--;
			return next.getFutureDate(remainDays - (month.numOfDays-date));
		}
	}
}
