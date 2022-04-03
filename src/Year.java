
public class Year {
	int year;
	int stem; // 天干
	int branch; // 地支 = 生肖
	
	Year(int num){
		if(num <= 0) {
			throw new IllegalArgumentException("年份須大於 0");
		}
		year = num;
		stem = ( (num-3) % 60 ) % 10;
		branch = ( (num-3) % 60 ) % 12;
	}
	
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
	
	// 干支
	public String getStemAndBranch() {
		char[] stems = {'癸', '甲', '乙', '丙', '丁', '戊', '己', '庚', '辛', '壬'};
		char[] branches = {'亥', '子', '丑', '寅', '卯', '辰', '巳', '午', '未', '申', '酉', '戌'};
		return Character.toString(stems[stem]) + Character.toString(branches[branch]);
	}
	
	// 生肖
	public String getZodiac() {
		char[] animals = {'豬', '鼠', '牛', '虎', '兔', '龍', '蛇', '馬', '羊', '猴', '雞', '狗'};
		return Character.toString(animals[branch]);
	}
}
