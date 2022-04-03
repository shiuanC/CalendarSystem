
public class Year {
	int year;
	int stem; // 天干
	int branch; // 地支 = 生肖
	
	/*** 透過年份建立 Year 物件，同時計算天干與地支。
	 * @param year
	 * @throws IllegalArgumentException
	 * 若輸入了不合法的年份（非正數），就會 throw IllegalArgumentException
	 * @return Year object with the record of year, stem and branch
	 * Example: Year(2022) return an object of year = 2022; stem = 壬; branch = 寅
	 * Time Estimate: O(1)
	 */
	Year(int year){
		if(year <= 0) {
			throw new IllegalArgumentException("年份須大於 0");
		}
		this.year = year;
		this.stem = ( (year-3) % 60 ) % 10;
		this.branch = ( (year-3) % 60 ) % 12;
	}
	
	/*** 判斷該年是否為閏年。
	 * @param no parameter
	 * @return true if the year is leap year, otherwise, false
	 * Example:
	 * 		year = Year(1905), year.isLeap = false
	 * 		year = Year(2000), year.isLeap = true
	 * Time Estimate: O(1)
	 */
	public boolean isLeap() {
		if(year % 400 == 0) {
			return true;
		}else if(year % 100 == 0) {
			return false;
		}else if(year % 4 == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	/*** 計算該年的天干與地支。
	 * @param no parameter
	 * @return a string of stem and branch
	 * Example: for Year(2022), return "壬寅"
	 * Time Estimate: O(1)
	 */
	// 干支
	public String getStemAndBranch() {
		char[] stems = {'癸', '甲', '乙', '丙', '丁', '戊', '己', '庚', '辛', '壬'};
		char[] branches = {'亥', '子', '丑', '寅', '卯', '辰', '巳', '午', '未', '申', '酉', '戌'};
		return Character.toString(stems[stem]) + Character.toString(branches[branch]);
	}
	/*** 計算該年的生肖。
	 * @param no parameter
	 * @return a string of Zodiac
	 * Example: for Year(2022), return "虎"
	 * Time Estimate: O(1)
	 */
	// 生肖
	public String getZodiac() {
		char[] animals = {'豬', '鼠', '牛', '虎', '兔', '龍', '蛇', '馬', '羊', '猴', '雞', '狗'};
		return Character.toString(animals[branch]);
	}
}
