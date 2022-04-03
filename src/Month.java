
public class Month {
	Year year;
	int month;
	int numOfDays;
	
	/*** 透過年份與月份建立 Month 物件。
	 * @param year, month
	 * @throws IllegalArgumentException
	 * 若輸入了不合法的月份（非 1~12 月），就會 throw IllegalArgumentException
	 * @return Month object
	 * Example: Month(2022/4) return an object Month with the record of the month 2022.4
	 * Time Estimate: O(1)
	 */
	Month(int year, int month){
		if(month > 12 || month < 1) {
			throw new IllegalArgumentException("月份只有 1~12 月");
		}
		this.year = new Year(year);
		this.month = month;
		numOfDays = getNumOfDays(month);
	}
	
	/*** 計算該月份有幾天。
	 * @param month
	 * @throws IllegalArgumentException
	 * 若輸入了不合法的月份（非 1~12 月），就會 throw IllegalArgumentException
	 * @return how many day of the month
	 * Example: month = 4, return 30 (30 days in April)
	 * Time Estimate: O(1)
	 */
	private int getNumOfDays(int month) {
		if(month > 12 || month < 1) {
			throw new IllegalArgumentException("月份只有 1~12 月");
		}
		int[] arr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if(year.isLeap())
			arr[1] = 29;
		return arr[month-1];
	}
	
	/*** 計算下一個月是哪一個月。
	 * @param no parameter
	 * @return next month
	 * Example: month = Month(2022/12), month.nextMonth = Month(2023/1)
	 * Time Estimate: O(1)
	 */
	public Month nextMonth() {
		if(month == 12) {
			return new Month(year.year+1, 1);
		}else {
			return new Month(year.year, month+1);
		}
	}
	
	/*** 計算該月份有幾天。
	 * @param no parameter
	 * @return 印出該月份的月曆
	 * Example: for Month(2022/4) it will print:
	 * 		Sun  Mon  Tue  Wed  Thu  Fri  Sat
	 *		                         1    2    
	 *		3    4    5    6    7    8    9    
	 *		10   11   12   13   14   15   16   
	 *		17   18   19   20   21   22   23   
	 *		24   25   26   27   28   29   30 
	 *
	 * Time Estimate: O(1), since numOfDays will not exceed 31
	 */
	public void printCalendar() {
		Date firstDate = new Date(year.year, month, 1);
		int currentDay = firstDate.day;
		
		System.out.println("Sun  Mon  Tue  Wed  Thu  Fri  Sat");
		for(int i = 0; i < currentDay; i++) {
			System.out.print("     ");
		}
		for(int i = 1; i <= numOfDays; i++) {
			System.out.print( String.format("%-5d", i) );
			currentDay = (currentDay + 1) % 7;
			if(currentDay == 0)
				System.out.print('\n');
		}
		if(currentDay != 0)
			System.out.print('\n');
	}
}
