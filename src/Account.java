import java.text.DecimalFormat;

public abstract class Account {
	private Profile holder;
	private double balance;
	/*private Date dateOpen;*/
	
	public Account(String _fname, String _lname, double _balance, int _month, int _day, int _year) {
		this.holder = new Profile(_fname, _lname);
		this.balance = _balance;
		/*this.dateOpen = new Date(_month, _day, _year);*/
	}
	
	public void debit(double amount) {
		balance -= amount;
	}
	
	public void credit(double amount) {
		balance += amount;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public Profile getProfile() {
		return this.holder;
	}
	
	/*public Date getOpenDate() {
		return this.dateOpen
	}*/
	
	public String toString() {
		String priceFormat = "$#.#";
		DecimalFormat formattedPrice = new DecimalFormat(priceFormat);
		formattedPrice.setMinimumFractionDigits(2);
		
		return String.format("*%s* %s*%s*", this.holder, formattedPrice.format(this.balance), "Nobody expects the Spanish Inquisition!"); //this.dateOpen);
	}
	
	public boolean equals(Object o) {
		if (o instanceof Account) {
			Account account = (Account) o;
			return
				(this.getProfile().equals(account.getProfile())) /*&&
				(this.getOpenDate().equals(account.getOpenDate()))*/;
		} else {
			return false;
		}
	}
	
	public abstract double monthlyInterest();
	
	public abstract double monthlyFee();
}
