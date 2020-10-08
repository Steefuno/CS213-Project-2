package account;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Date implements Comparable<Date> {
	 private int year;
	 private int month;
	 private int day;
	
	 public int compareTo(Date date) {
		 if (date.isValid()) {
			 if(this.equals(date)) {
				 return 1;
			 }
			 else {
				 return 0;
			 }
		 }
		 else {
			 return -1;
		 }
	 } 
	 
	 public String toString() {
		 String output = String.format("%d/%d/%d", this.month, this.day, this.year);
		 return output;
	 }
		 
	  //in the format mm/dd/yyyy
	public boolean isValid() {
		Pattern pattern = Pattern.compile("^((0|1|2)\\d{1})\\/(([0-3])\\d{1})\\/((17|18|19|20)\\d{2})");  
		Matcher matcher = pattern.matcher(this.toString());

	
		    if(matcher.find()){ // String doesn't contain any number or symbols
		       return true;
		    }
		    else {
		    	return false;
		    }
		    
	}	
}

