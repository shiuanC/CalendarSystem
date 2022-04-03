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
	// Initialize Diary
	public void init() {
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
		} catch (FileNotFoundException e) {
			this.saveDiary();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Add Content
	public void addContent(Date date, String content) {
		records.put(date, content);
	}
	
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
	
	// Save Diary
	public void saveDiary(){
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
