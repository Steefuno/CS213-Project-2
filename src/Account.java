import java.text.DecimalFormat;

public abstract class Account {
	private Profile holder;
	private double balance;
	private Date dateOpen;
	
	public Account(String _fname, String _lname, double _balance, int _month, int _day, int _year) {
		this.holder = new Profile(_fname, _lname);
		this.balance = _balance;
		this.dateOpen = new Date(_month, _day, _year);
	}
	
	public void debit(double amount) {
		balance -= amount;
	}
	
	public void credit(double amount) {
		balance += amount;
	}
	
	public String toString() {
		String priceFormat = "$#.#";
		DecimalFormat formattedPrice = new DecimalFormat(priceFormat);
		formattedPrice.setMinimumFractionDigits(2);
		
		return String.format("*%s* %s*%s*", this.holder, formattedPrice.format(this.balance), this.dateOpen);
	}
	
	public abstract double monthlyInterest();
	
	public abstract double monthlyFee();
}
