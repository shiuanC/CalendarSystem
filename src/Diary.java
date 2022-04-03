import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Diary {
	TreeMap<Date, String> records;
	private Path currentRelativePath;
	private String outputDir;
	private String fileName;
	private File file;
	
	/*** 建立空白的 record，並初始化存放 .csv 檔的位置。
	 * @param no parameter
	 * @return Diary object
	 * Example: new Diary(), it will return an object Diary without any record
	 * Time Estimate: O(1)
	 */
	Diary(){
		Comparator<Date> dateComparator = new Comparator<Date>() {
		      public int compare(Date d1, Date d2) {
		    	  if(d1.year.year != d2.year.year) {
		    		  if(d1.year.year > d2.year.year) {
		    			  return 1;
		    		  }else{
		    			  return -1;
		    		  }
		    	  }else if(d1.month.month != d2.month.month) {
		    		  if(d1.month.month > d2.month.month) {
		    			  return 1;
		    		  }else{
		    			  return -1;
		    		  }
		    	  }else if(d1.date != d2.date) {
		    		  if(d1.date > d2.date) {
		    			  return 1;
		    		  }else{
		    			  return -1;
		    		  }
		    	  }else {
		    		  return 0;
		    	  }
				
		      }
			};
		records = new TreeMap<Date, String>(dateComparator);
		currentRelativePath = Paths.get("");
		outputDir = currentRelativePath.toAbsolutePath().toString();
		fileName = "myDiary.csv";
		file = new File(outputDir, fileName);
	}
	
	/***透過 myDiary.csv 初始化 record若不存在 myDiary.csv，便會於目前專案的資料夾下建立一個。
	 * @param no parameter
	 * @return return true if successfully new a file and initialize, otherwise, return false
	 * Example: just call it
	 * Time Estimate: O(n), n = the number of record in myDiary.csv file
	 */
	public boolean init() {
		try {
			InputStreamReader streamReader = new InputStreamReader(new FileInputStream(file));
			BufferedReader reader = new BufferedReader(streamReader);
			String line = null;
			reader.readLine();
			while(( line = reader.readLine()) != null){
			      String[] item = line.split(",");
			      String[] words = item[0].split("/");
			      Date date = new Date (Integer.parseInt(words[0]), Integer.parseInt(words[1]), Integer.parseInt(words[2]));
			      records.put(date, item[1]);
			}
			reader.close();
			return true;
		} catch (FileNotFoundException e) {
			this.saveDiary();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	/*** 新增日期與日記內容
	 * @param date, content
	 * @return return true if successfully add a new record, otherwise, return false
	 * Example: Diary.addcContent(new Date(2020,1,1), "test"), it should return true and record the content.
	 * Time Estimate: O(n), n = the number of records, since we use the treeMap, which must maintain the sorted map.
	 */
	public boolean addContent(Date date, String content) {
		try {
			records.put(date, content);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
	/*** 透過日期搜尋日記內容
	 * @param date
	 * @return return the string of the content of the date, if there isn't any record,
	 * it will return "這天沒有任何紀錄，請按 F 進行編輯"
	 * Example: Diary.searchContent(Date(2022,4,1),)
	 * 		if we had add the content "test" in the day before, it will return a string "test"
	 * 		or it should return "這天沒有任何紀錄，請按 F 進行編輯"
	 * Time Estimate: O(n), n = the number of record.
	 */
	public String searchContent(Date date) {
		for(Entry<Date, String> entry : records.entrySet()) {
			Date key = entry.getKey();
			String value = entry.getValue();
			if (key.year.year == date.year.year && key.month.month == date.month.month && key.date == date.date) {
				return value;
			}
		}
		return "這天沒有任何紀錄，請按 F 進行編輯";
	}
	
	/***將所記錄的所有日期與對應的內容記錄到 myDiary.csv 檔中
	 * @param no parameter
	 * @return return true if successfully save the file
	 * Example: just call it
	 * Time Estimate: O(n), n = the number of record.
	 */
	public boolean saveDiary(){
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(file,false));
			writer.write("date, content");
			writer.newLine();
			
			for(Entry<Date, String> entry : records.entrySet()) {
				Date key = entry.getKey();
				String value = entry.getValue();
				writer.write(key.year.year+"/"+key.month.month+"/"+key.date+","+value+"\n");
			}
			
			writer.close();
			return true;
		} catch (IOException e) {
			return false;
		}
		
	}
}
