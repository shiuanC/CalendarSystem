import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.TreeMap;
public class Diary {
	TreeMap<Date, String> records;
	
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
	}
	// Initialize Diary
	
	// Add Content
	public void addContent(Date date, String content) {
		records.put(date, content);
	}
	
	// Save Diary
	public void saveDiary() throws IOException {
		Path currentRelativePath = Paths.get("");
		String outputDir = currentRelativePath.toAbsolutePath().toString();
		String fileName = "myDiary";
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("myDiary.csv",false));
		writer.write("date, content");
		writer.newLine();
		
		for(Entry<Date, String> entry : records.entrySet()) {
			Date key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " => " + value);
			writer.write(key.year.year);
		}
		
		writer.close();
		
	}
}
