
public class MoneyMarket extends Account {
	private int withdrawals = 0;
	private final int maxWithdrawals = 6;
	private final double monthlyFee = 12;
	private final double waiveBalanceMinimum = 2500;
	private final double annualInterestRate = .0065;
	
	public MoneyMarket(String _fname, String _lname, double _balance, int _month, int _day, int _year) {
		super(_fname, _lname, _balance, _month, _day, _year);
	}
	
	public void debit(double amount) {
		withdrawals++;
		super.debit(amount);
	}
	
	public double monthlyInterest() {
		return this.getBalance() * (annualInterestRate / 12);
	}
	
	public double monthlyFee() {
		if (this.getBalance() >= waiveBalanceMinimum && this.withdrawals <= maxWithdrawals) {
			return 0;
		} else {
			return monthlyFee;
		}
	}
	
	public boolean equals(Object o) {
		if (o instanceof MoneyMarket) {
			return super.equals(o);
		} else {
			return false;
		}
	}
}
