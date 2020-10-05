/**
 * This class represents a money market account<br>
 * Checking accounts have a monthly fee of 6, a minimum balance of 2500 unless the withdrawals has surpassed 6, and an annual interest rate of .65%
 * @author Steven Nguyen, Julian Romero
 */
public class MoneyMarket extends Account {
	private int withdrawals = 0;
	private static final int maxWithdrawals = 6;
	private static final double monthlyFee = 12;
	private static final double waiveBalanceMinimum = 2500;
	private static final double annualInterestRate = .0065;
	
	/**
	 * Constructs a money market account
	 * @param _fname	the first name of the profile
	 * @param _lname	the last name of the profile
	 * @param _balance	the initial balance
	 * @param _month	the month of the open date
	 * @param _day		the day of the open date
	 * @param _year		the year of the open date
	 */
	public MoneyMarket(String _fname, String _lname, double _balance, int _month, int _day, int _year) {
		super(_fname, _lname, _balance, _month, _day, _year);
	}
	
	/**
	 * Withdraw money
	 * @param amount	the amount of money to withdraw
	 * @overload
	 */
	public void debit(double amount) {
		withdrawals++;
		super.debit(amount);
	}
	
	/**
	 * Calculate the monthly interest
	 * @return	the monthly interest
	 */
	public double monthlyInterest() {
		return this.getBalance() * (annualInterestRate / 12);
	}
	
	/**
	 * Calculate the monthly fee
	 * @return	the monthly fee
	 */
	public double monthlyFee() {
		if (this.getBalance() >= waiveBalanceMinimum && this.withdrawals <= maxWithdrawals) {
			return 0;
		} else {
			return monthlyFee;
		}
	}
	
	/**
	 * Gets the string representation of this money market account<br>
	 * Format: "*Money Market*[Profile Name]* $[Balance]*[Open Date]* [Number of withdrawals] withdrawals*
	 * @return	the string representation
	 * @overload
	 */
	public String toString() {
		return String.format("*%s%s%s withdrawals*", "Money Market", super.toString(), this.withdrawals);
	}
	
	/**
	 * Gets if this account is equal to an object
	 * @param o	the object to compare to this account
	 * @return	true if the object is a money market account with the same name
	 * @overload
	 */
	public boolean equals(Object o) {
		if (o instanceof MoneyMarket) {
			return super.equals(o);
		} else {
			return false;
		}
	}
	
	/**
	 * Testmain - tests the methods in this class
	 * @param args	unused
	 */
	public static void main(String[] args) {
		MoneyMarket m1 = new MoneyMarket("B", "B", 100, 1, 1, 2000);
		MoneyMarket m2 = new MoneyMarket("A", "A", 150, 1, 1, 2000);
		MoneyMarket m3 = new MoneyMarket("B", "B", 100, 1, 1, 2000);
		MoneyMarket m4 = new MoneyMarket("B", "B", 2500, 1, 1, 2000);
		
		for (int i = 0; i <= maxWithdrawals; i++) {
			m3.debit(100);
		}
		
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		System.out.println(m4);
		
		System.out.println("m1:\n\tbalance: " + m1.getBalance() + "\n\tinterest: " + m1.monthlyInterest() + "\n\tfee: " + m1.monthlyFee());
		System.out.println("m2:\n\tbalance: " + m2.getBalance() + "\n\tinterest: " + m2.monthlyInterest() + "\n\tfee: " + m2.monthlyFee());
		System.out.println("m3:\n\tbalance: " + m3.getBalance() + "\n\tinterest: " + m3.monthlyInterest() + "\n\tfee: " + m3.monthlyFee());
		System.out.println("m4:\n\tbalance: " + m4.getBalance() + "\n\tinterest: " + m4.monthlyInterest() + "\n\tfee: " + m4.monthlyFee());
		
		if (m1.equals(m2)) {
			System.out.println("Unexpected: m1 == m2");
		} else {
			System.out.println("Expected: m1 != m2");
		}

		if (m1.equals(m3)) {
			System.out.println("Expected: m1 == m3");
		} else {
			System.out.println("Unexpected: m1 != m3");
		}
	}
}
