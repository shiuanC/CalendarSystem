
public class Date {
	int date; // 日
	int day; // 星期
	Month month; // 月
	Year year; // 年
	
	Date(int year, int month, int date){
		this.year = new Year(year);
		this.month = new Month(year, month);
		this.date = date;
		day = getDayNum(year, month, date);
	}
	
	int getDayNum(int year, int month, int date) {
		int y = year;
		int m = month;
		int d = date;
		
		int[] base = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
		if( m < 3) y -= 1;
		
		return ( y + y/4 - y/100 + y/400 + base[m-1] + d) % 7; // (total days) % 7
	}
	
	int getTotalDay() {
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
	
	String printFutureDate(int remainDays) {
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
			Date next = new Date( newYear, newMonth, 0);
			return next.printFutureDate(remainDays - (month.numOfDays-date));
		}
		
		
	}
	
	String getPrintFormat(int y, int m, int d) {
		return Integer.toString(y) + "/"+ Integer.toString(m) + "/" + Integer.toString(d);
	}

}
