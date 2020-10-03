
public class Checking extends Account {
	private boolean directDeposit;
	private final double monthlyFee = 25;
	private final double waiveBalanceMinimum = 1500;
	private final double annualInterestRate = .0005;
	
	public Checking(String _fname, String _lname, double _balance, int _month, int _day, int _year, boolean _directDeposit) {
		super(_fname, _lname, _balance, _month, _day, _year);
		this.directDeposit = _directDeposit;
	}
	
	public double monthlyInterest() {
		return this.getBalance() * (annualInterestRate / 12);
	}
	
	public double monthlyFee() {
		if (this.getBalance() >= waiveBalanceMinimum || this.directDeposit) {
			return 0;
		} else {
			return monthlyFee;
		}
	}
	
	public boolean getIsDirectDeposit() {
		return directDeposit;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Checking) {
			return super.equals(o);
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Checking c1 = new Checking("B", "B", 100, 1, 1, 2000, true);
		Checking c2 = new Checking("A", "A", 150, 1, 1, 2000, false);
		Checking c3 = new Checking("B", "B", 1501, 1, 1, 2000, false);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		System.out.println("c1:\n\tbalance: " + c1.getBalance() + "\n\tinterest: " + c1.monthlyInterest() + "\n\tfee: " + c1.monthlyFee());
		System.out.println("c2:\n\tbalance: " + c1.getBalance() + "\n\tinterest: " + c2.monthlyInterest() + "\n\tfee: " + c2.monthlyFee());
		System.out.println("c3:\n\tbalance: " + c1.getBalance() + "\n\tinterest: " + c3.monthlyInterest() + "\n\tfee: " + c3.monthlyFee());
		
		if (c1.equals(c2)) {
			System.out.println("Unexpected: c1 == c2");
		} else {
			System.out.println("Expected: c1 != c2");
		}
		
		if (c1.equals(c3)) {
			System.out.println("Expected: c1 == c3");
		} else {
			System.out.println("Unexpected: c1 != c3");
		}
	}
}