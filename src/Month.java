
public class Month {
	Year year;
	int month;
	int numOfDays;
	
	Month(int year, int month){
		this.year = new Year(year);
		this.month = month;
		numOfDays = getNumOfDays(month);
	}
	
	int getNumOfDays(int month) {
		if(month % 2 == 1) {
			return 31;
		}else {
			if(month != 2) {
				return 30;
			}else {
				if(year.isLeap()) {
					return 29;
				}else {
					return 28;
				}
			}
		}
	}
	
	Month nextMonth() {
		if(month == 12) {
			return new Month(year.year+1, 1);
		}else {
			return new Month(year.year, month+1);
		}
	}
	
	void printCalendar() {
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
	}
}
