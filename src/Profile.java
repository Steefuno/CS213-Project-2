public class Profile {
	private String fname;
	private String lname;
	
	public Profile(String _fname, String _lname) {
		this.fname = _fname;
		this.lname = _lname;
	}
	
	public String getFName() {
		return this.fname;
	}
	
	public String getLName() {
		return this.lname;
	}
	
	public int compareTo(Profile profile) {
		int lnameComparison = this.lname.compareTo(profile.lname);
		if (lnameComparison == 0) {
			int fnameComparison = this.fname.compareTo(profile.fname);
			return fnameComparison;
		} else {
			return lnameComparison;
		}
	}
	
	public String toString() {
		return String.format("%s %s", this.fname, this.lname);
	}
}
