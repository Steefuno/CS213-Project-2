package account;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransactionManager {
	private AccountDatabase accountDatabase;
	
	public TransactionManager() {
		accountDatabase = new AccountDatabase();
	}
	
	//Opening Accounts
	private void openChecking(String _fname, String _lname, double _balance, int _month, int _day, int _year, boolean _directDeposit) {
		Checking checkingAccount = new Checking(_fname, _lname, _balance, _month, _day, _year, _directDeposit);
		this.accountDatabase.add(checkingAccount);
		return;
	}
	
	private void openSaving(String _fname, String _lname, double _balance, int _month, int _day, int _year, boolean _isLoyal) {
		Savings savingsAccount = new Savings(_fname, _lname, _balance, _month, _day, _year, _isLoyal);
		this.accountDatabase.add(savingsAccount);
		return;
	}
	
	private void openMoneyMarket(String _fname, String _lname, double _balance, int _month, int _day, int _year) {
		MoneyMarket moneyMarketAccount = new MoneyMarket(_fname, _lname, _balance, _month, _day, _year);
		this.accountDatabase.add(moneyMarketAccount);
		return;
	}
	
	//Closing Accounts
	private void closeChecking(String _fname, String _lname) {
		Checking checkingAccount = new Checking(_fname, _lname);
		this.accountDatabase.remove(checkingAccount);
		return;
	}
	
	private void closeSaving(String _fname, String _lname) {
		Savings savingsAccount = new Savings(_fname, _lname);
		this.accountDatabase.remove(savingsAccount);
		return;
	}
	
	private void closeMoneyMarket(String _fname, String _lname) {
		MoneyMarket moneyMarketAccount = new MoneyMarket(_fname, _lname);
		this.accountDatabase.remove(moneyMarketAccount);
		return;
	}
	
	//Depositing Accounts
	private void depositChecking(String _fname, String _lname, double _deposit) {
		Checking checkingAccount = new Checking(_fname, _lname);
		this.accountDatabase.deposit(checkingAccount, _deposit);
		return;
	}
	
	private void depositSaving(String _fname, String _lname, double _deposit) {
		Savings savingsAccount = new Savings(_fname, _lname);
		this.accountDatabase.deposit(savingsAccount, _deposit);
		return;
	}
	
	private void depositMoneyMarket(String _fname, String _lname, double _deposit) {
		MoneyMarket moneyMarketAccount = new MoneyMarket(_fname, _lname);
		this.accountDatabase.deposit(moneyMarketAccount, _deposit);
		return;
	}
	
	//Depositing Accounts
	private void withdrawChecking(String _fname, String _lname, double _withdraw) {
		Checking checkingAccount = new Checking(_fname, _lname);
		this.accountDatabase.withdrawal(checkingAccount, _withdraw);
		return;
	}
	
	private void withdrawSaving(String _fname, String _lname, double _withdraw) {
		Savings savingsAccount = new Savings(_fname, _lname);
		this.accountDatabase.withdrawal(savingsAccount, _withdraw);
		return;
	}
	
	private void withdrawMoneyMarket(String _fname, String _lname, double _withdraw) {
		MoneyMarket moneyMarketAccount = new MoneyMarket(_fname, _lname);
		this.accountDatabase.withdrawal(moneyMarketAccount, _withdraw);
		return;
	}
	private Double convertStringToDouble(String string) {
		try {
			return Double.parseDouble(string);
		}
		catch(NumberFormatException e) {
			System.out.println(e.toString());
		}
		return null;
	}
	private Integer convertStringToInteger(String string) {
		try {
			return Integer.parseInt(string);
		}
		catch(NumberFormatException e) {
			System.out.println(e.toString());
		}
		return null;
	}
	private Boolean convertStringToBoolean(String string) {
		try {
			return Boolean.parseBoolean(string);
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}
	
	private String validString(String string) {
		Pattern pattern = Pattern.compile("^[a-zA-Z]+$");  
		Matcher matcher = pattern.matcher(string);

		try{
		    if(matcher.find()){ // String doesn't contain any number or symbols
		       return string;
		    }
		    
		}catch(Exception e){
		    System.out.println(e.toString());
		}
		return null;
	}
	
	private String validDate(String string) {
		Pattern pattern = Pattern.compile("^((0|1|2)\\d{1})\\/(([0-3])\\d{1})\\/((17|18|19|20)\\d{2})");  
		Matcher matcher = pattern.matcher(string);

		try{
		    if(matcher.find()){ // String doesn't contain any number or symbols
		       return string;
		    }
		    
		}catch(Exception e){
		    System.out.println(e.toString());
		}
		return null;
	}
	
	
	private boolean handleCommand(String input) {
		// Splits the input by whitespace
		String[] args = input.split("\\s+", 0);
		// Checks if a command was inputted
		if (args.length == 0) {
			System.out.println("Invalid Command!");
			return true;
		}
		
		String command = args[0];

			String [] date = validDate(args[4]).split("/");
		
		
		
	
		// Note, assume that number and type of arguments are valid
		// Given a command, calls the respective method
		switch(command) {
		case "OC":
			this.openChecking(validString(args[1]), validString(args[2]), convertStringToDouble(args[3]), convertStringToInteger(date[0]), 
			convertStringToInteger(date[1]), convertStringToInteger(date[2]), convertStringToBoolean(args[4]));
			break;
		case "OS":
			this.openSaving(validString(args[1]), validString(args[2]), convertStringToDouble(args[3]), convertStringToInteger(args[4]), 
			convertStringToInteger(args[5]), convertStringToInteger(args[6]), convertStringToBoolean(args[4]));
			break;
		case "OM":
			this.openMoneyMarket(args[1], args[2], convertStringToDouble(args[3]), convertStringToInteger(date[0]), 
			convertStringToInteger(date[1]), convertStringToInteger(date[2]));
			break;
		case "CC":
			this.closeChecking(validString(args[1]), validString(args[2]));
			break;
		case "CS":
			this.closeSaving(validString(args[1]), validString(args[2]));
			break;
		case "CM":
			this.closeMoneyMarket(validString(args[1]), validString(args[2]));
			break;
		case "DC":
			this.depositChecking(validString(args[1]), validString(args[2]), convertStringToDouble(args[3]));
			break;
		case "DS":
			this.depositSaving(validString(args[1]), validString(args[2]), convertStringToDouble(args[3]));
			break;
		case "DM":
			this.depositMoneyMarket(validString(args[1]), validString(args[2]), convertStringToDouble(args[3]));
			break;
		case "WC":
			this.withdrawChecking(validString(args[1]), validString(args[2]), convertStringToDouble(args[3]));
			break;
		case "WS":
			this.withdrawSaving(validString(args[1]), validString(args[2]), convertStringToDouble(args[3]));
			break;
		case "WM":
			this.withdrawMoneyMarket(validString(args[1]), validString(args[2]), convertStringToDouble(args[3]));
			break;
		case "PA":
			this.accountDatabase.printAccounts();
			break;
		case "PD":
			this.accountDatabase.printByDateOpen();
			break;
		case "PN":
			this.accountDatabase.printByLastName();;
			break;
			
		case "Q":
			System.out.println("Transaction processing completed");
			// Return false to break the loop in run()
			return false;
		default:
			System.out.printf("Command %s not supported!", command);
		}
		
		// Return true to continue loop in run()
		return true;
	}
	

	public void run() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Transaction processing starts.....");
		
		// Repeat getting and responding to inputs until the Q command
		String input;
		do {
			input = sc.nextLine();
		} while (handleCommand(input));
		
		sc.close();
		return;
	}
	
	

}
