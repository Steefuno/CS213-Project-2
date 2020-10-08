package account;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class represents a date following the format mm/dd/yyyy
 * @author Steven Nguyen, Julian Romero
 */
public class Date implements Comparable<Date> {
	 private int year;
	 private int month;
	 private int day;
	 
	 /**
	 * Constructs a date object
	 * @param _month	the month of the open date
	 * @param _day		the day of the open date
	 * @param _year		the year of the open date
	 */
	 public Date(int month, int day, int year) {
		 this.month = month;
		 this.day = day;
		 this.year = year;
	 }
	 
	 
	
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
	/**
	* Gets the string representation of this Date<br>
	* Format: *Month*, *day* ,*year*
	* @return	the string representation
	*/	 
	 
	 public String toString() {
		 String output = String.format("%d/%d/%d", this.month, this.day, this.year);
		 return output;
	 }
		 
	  //in the format mm/dd/yyyy
	public boolean isValid() {
		
		Pattern pattern = Pattern.compile("^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$");  
		Matcher matcher = pattern.matcher(this.toString());

	
		    if(matcher.matches()){ 
		       return true;
		    }
		    else {
		    	return false;
		    }
		    
	}	
}
