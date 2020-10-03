
public class Savings extends Account {
	private boolean isLoyal;
	private static final double monthlyFee = 5;
	private static final double waiveBalanceMinimum = 300;
	private static final double annualInterestRate = .0025;
	private static final double loyalAnnualInterestRate = .0035;
	
	public Savings(String _fname, String _lname, double _balance, int _month, int _day, int _year, boolean _isLoyal) {
		super(_fname, _lname, _balance, _month, _day, _year);
		this.isLoyal = _isLoyal;
	}
	
	public double monthlyInterest() {
		double rate = annualInterestRate;
		if (this.isLoyal) {
			rate = loyalAnnualInterestRate;
		}
		
		return this.getBalance() * (rate / 12);
	}
	
	public double monthlyFee() {
		if (this.getBalance() >= waiveBalanceMinimum) {
			return 0;
		} else {
			return monthlyFee;
		}
	}
	
	public boolean getIsLoyal() {
		return this.isLoyal;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Savings) {
			return super.equals(o);
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		
	}
}
