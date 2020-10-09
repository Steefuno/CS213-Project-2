package account;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class manages I/O of the account database
 * @author Steven Nguyen, Julian Romero
 */
public class TransactionManager {
	private AccountDatabase accountDatabase;
	
	/**
	 * Constructs an accountDatabase
	 */
	public TransactionManager() {
		accountDatabase = new AccountDatabase();
	}
	
	/**
	* creates a checking account and adds it to the account database.
	* @param _fname	the first name of Account
	* @param _lname the last name of Account
	* @param _balance the balance of the account
	* @param _month	the month of the open date
	* @param _day the day of the open date
	* @param _year the year of the open date
	* @param _directDeposit boolean value whether it is a direct deposit or not
	* @return boolean value of whether the checking account was successfully added in the account database
	*/
	private boolean openChecking(String _fname, String _lname, double _balance, int _month, int _day, int _year, boolean _directDeposit) {
		Checking checkingAccount = new Checking(_fname, _lname, _balance, _month, _day, _year, _directDeposit);
		boolean isPresent = this.accountDatabase.add(checkingAccount);
		return isPresent;
	}
	
	/**
	* creates a savings account and adds it to the account database.
	* @param _fname	the first name of Account
	* @param _lname the last name of Account
	* @param _balance the balance of the account
	* @param _month	the month of the open date
	* @param _day the day of the open date
	* @param _year the year of the open date
	* @param _isLoyal boolean value whether it is a direct deposit or not
	* @return boolean value of whether the saving account was successfully added in the account database
	*/
	private boolean openSaving(String _fname, String _lname, double _balance, int _month, int _day, int _year, boolean _isLoyal) {
		Savings savingsAccount = new Savings(_fname, _lname, _balance, _month, _day, _year, _isLoyal);
		boolean isPresent = this.accountDatabase.add(savingsAccount);
		return isPresent;
	}
	
	/**
	* creates an open money market account and adds it to the account database.
	* @param _fname	the first name of Account
	* @param _lname the last name of Account
	* @param _balance the balance of the account
	* @param _month	the month of the open date
	* @param _day the day of the open date
	* @param _year the year of the open date
	* @return boolean value of whether the money market account was successfully added in the account database
	*/
	private boolean openMoneyMarket(String _fname, String _lname, double _balance, int _month, int _day, int _year) {
		MoneyMarket moneyMarketAccount = new MoneyMarket(_fname, _lname, _balance, _month, _day, _year);
		boolean isPresent = this.accountDatabase.add(moneyMarketAccount);
		return isPresent;
	}
	
	/**
	* closes a checking account and removes it from the account database.
	* @param _fname	the first name of Account
	* @param _lname the last name of Account
	* @return boolean value of whether the checking account was successfully removed in the account database
	*/
	private boolean closeChecking(String _fname, String _lname) {
		Checking checkingAccount = new Checking(_fname, _lname);
		boolean accountExists = this.accountDatabase.remove(checkingAccount);
		return accountExists;
	}
	
	/**
	* closes a savings account and removes it from the account database.
	* @param _fname	the first name of Account
	* @param _lname the last name of Account
	* @return boolean value of whether the checking account was successfully removed in the account database
	*/
	private boolean closeSaving(String _fname, String _lname) {
		Savings savingsAccount = new Savings(_fname, _lname);
		boolean accountExists = this.accountDatabase.remove(savingsAccount);
		return accountExists;
	}
	
	/**
	* closes a money market account and removes it from the account database.
	* @param _fname	the first name of account
	* @param _lname the last name of account
	* @return boolean value of whether the checking account was successfully removed in the account database
	*/
	private boolean closeMoneyMarket(String _fname, String _lname) {
		MoneyMarket moneyMarketAccount = new MoneyMarket(_fname, _lname);
		boolean accountExists = this.accountDatabase.remove(moneyMarketAccount);
		return accountExists;
	}
	
	/**
	* deposits money into a checking account in the account database.
	* @param _fname	the first name of account
	* @param _lname the last name of account
	* @param _deposit the amount being deposited into account
	* @return boolean value of whether the deposit was successfully deposited in the account
	*/
	private boolean depositChecking(String _fname, String _lname, double _deposit) {
		Checking checkingAccount = new Checking(_fname, _lname);
		boolean moneyDeposited = this.accountDatabase.deposit(checkingAccount, _deposit);
		return moneyDeposited;
	}
	
	/**
	* deposits money into a savings account in the account database.
	* @param _fname	the first name of account
	* @param _lname the last name of account
	* @param _deposit the amount being deposited into account
	* @return boolean value of whether the deposit was successfully deposited in the account
	*/
	private boolean depositSaving(String _fname, String _lname, double _deposit) {
		Savings savingsAccount = new Savings(_fname, _lname);
		boolean moneyDeposited = this.accountDatabase.deposit(savingsAccount, _deposit);
		return moneyDeposited;
	}
	
	/**
	* deposits money into a money market account in the account database.
	* @param _fname	the first name of account
	* @param _lname the last name of account
	* @param _deposit the amount being deposited into account
	* @return boolean value of whether the deposit was successfully deposited in the account
	*/
	private boolean depositMoneyMarket(String _fname, String _lname, double _deposit) {
		MoneyMarket moneyMarketAccount = new MoneyMarket(_fname, _lname);
		boolean moneyDeposited = this.accountDatabase.deposit(moneyMarketAccount, _deposit);
		return moneyDeposited;
	}
	
	/**
	* withdraws money from a checking account in the account database.
	* @param _fname	the first name of account
	* @param _lname the last name of account
	* @param _withdraw amount being withdrawn from the account
	* @return int value of whether the withdraw was successfully withdrawn from the account
	*/
	private int withdrawChecking(String _fname, String _lname, double _withdraw) {
		Checking checkingAccount = new Checking(_fname, _lname);
		int accountStatus = this.accountDatabase.withdrawal(checkingAccount, _withdraw);
		return accountStatus;
	}
	
	/**
	* withdraws money from a savings account in the account database.
	* @param _fname	the first name of account
	* @param _lname the last name of account
	* @param _withdraw amount being withdrawn from the account
	* @return int value of whether the withdraw was successfully withdrawn from the account
	*/
	private int withdrawSaving(String _fname, String _lname, double _withdraw) {
		Savings savingsAccount = new Savings(_fname, _lname);
		int accountStatus = this.accountDatabase.withdrawal(savingsAccount, _withdraw);
		return accountStatus;
	}
	
	/**
	* withdraws money from a moneyMarket account in the account database.
	* @param _fname	the first name of account
	* @param _lname the last name of account
	* @param _withdraw amount being withdrawn from the account
	* @return int value of whether the withdraw was successfully withdrawn from the account
	*/
	private int withdrawMoneyMarket(String _fname, String _lname, double _withdraw) {
		MoneyMarket moneyMarketAccount = new MoneyMarket(_fname, _lname);
		int accountStatus = this.accountDatabase.withdrawal(moneyMarketAccount, _withdraw);
		return accountStatus;
	}
	
	/**
	* converts a string to a double
	* @param string a string from the input
	* @return double value of string or null representing a bad input
	*/
	private Double convertStringToDouble(String string) {
		try {
			return Double.parseDouble(string);
		}
		catch(NumberFormatException e) {
			System.out.println("Input data type mismatch.");
		}
		return null;
	}
	
	/**
	* converts a string to an integer
	* @param string a string from the input
	* @return integer value of string or null representing a bad input
	*/
	private Integer convertStringToInteger(String string) {
		try {
			return Integer.parseInt(string);
		}
		catch(NumberFormatException e) {
			System.out.println("Input data type mismatch.");
		}
		return null;
	}
	
	/**
	* converts a string to a boolean
	* @param string a string from the input
	* @return boolean value of string or null representing a bad input
	*/
	private Boolean convertStringToBoolean(String string) {
		if(string.equalsIgnoreCase("false")) {
			return false;
		}
		else if(string.equalsIgnoreCase("true")) {
			return true;
		}
		else {
			System.out.println("Input data type mismatch.");
			return null;
		}
	}
	
	/**
	* checks that a string is a valid string with no numbers or symbols
	* @param string a string from the input
	* @return String with only letters 
	*/
	private String validString(String string) {
		Pattern pattern = Pattern.compile("^[a-zA-Z]+$");  
		Matcher matcher = pattern.matcher(string);

		    if (matcher.matches()){
		       return string;
		    }
		    else {
		    	System.out.println("Input data type mismatch.");
		    }
		return null;
	}
	
	/**
	* checks the number of inputs to see if they are valid
	* @param String [] array of args from input
	* @param int number of arguments present 
	* @return int the number of arguments present
	*/
	private int checkNumberOfInputs(String [] args, int numberOfArguments) {
		int length = 0;
		String input;
		try{
			
		    while(length < numberOfArguments){
		         input = args[length];
		         length++;     
		    }
		}
		    catch(ArrayIndexOutOfBoundsException e)
		    {
		     System.out.println("wrong number of inputs");   
		    }
		return length;
	}
	
	/**
	* Checks whether or not a string is in a valid date format<br>
	* Format:  *Month*, *day* ,*year*
	* @param string a string from the input
	* @return A valid date format string or null representing a bad format
	*/
	private String validDate(String string) {
		
		boolean isValid = false;
		
		//leap year cases
		int leapYearDay = 29;
		int leapYearDivisor = 4;
		
		//special case months
		int september = 9;
		int november = 11;
		int february = 2;
		int april = 4;
		int june = 6;
		
		//special case days
		int thirtyFirst = 31;
		int thirty = 30;
		int twentyNine = 29;
		
		//parse date for special cases
		String [] numbers = string.split("/",3);
		int year = Integer.parseInt(numbers[2]);
		int month = Integer.parseInt(numbers[0]);
		int day = Integer.parseInt(numbers[1]);
		
		//handling leap years
		if(year % leapYearDivisor == 0 && month == february && day == leapYearDay) {
			String output = String.format("%d/%d/%d", month, day, year);
			return output;
			
		}
		
		//months with 31 days
		else if((month == november ||month == september || month == june ||month == april ) && day == thirtyFirst) {
			System.out.println(string + " is not a valid date!");
			return null;
		}
		
		//handling February
		else if(month == february && (day == twentyNine || day == thirty || day == thirtyFirst)) {
			System.out.println(string + " is not a valid date!");
			return null;
		}
		
		//other date inputs that are not special cases
		else {
		
		Pattern pattern = Pattern.compile("^(1[0-2]|[1-9])/(3[1]|[12][0-9]|[1-9])/[0-9]{4}$");
		Matcher matcher = pattern.matcher(string);
		isValid = matcher.matches();
			if(isValid) {
				return string;
			}
			else {
				System.out.println(string + " is not a valid date!");
				return null;
			}
		}
	}
	
	/**
	* handles the user input and output of the transaction manager
	* @param string input from user
	* @return a boolean of whether an invalid command was inputed
	*/
	private boolean handleCommand(String input) {
		// Splits the input by whitespace
		String[] args = input.split("\\s+", 0);
		String [] date;
		boolean isPresent;
		boolean accountExists;
		boolean moneyDeposited;
		int accountStatus;
		int numberOfArgumentsForOCandOS = 6;
		int numberOfArgumentsForOM = 5;
		int numberOfArgumentsForClose = 3;
		int numberOfArgumentsForDepositAndWithdraw = 4;
		
		// Checks if a command was inputed
		if (args.length == 0) {
			System.out.println("Invalid Command!");
			return true;
		}
		
		String command = args[0];
	
		switch(command) {
		case "OC":
		if(checkNumberOfInputs(args, numberOfArgumentsForOCandOS) != numberOfArgumentsForOCandOS) {
			break;
		}
			if (validString(args[1]) == null || validString(args[2]) == null || convertStringToDouble(args[3]) == null || 
			validDate(args[4]) == null || convertStringToBoolean(args[5]) == null){
				break;
			}
			
			date = args[4].split("/",3);
			
			isPresent = this.openChecking(validString(args[1]), validString(args[2]), convertStringToDouble(args[3]), convertStringToInteger(date[0]), 
			convertStringToInteger(date[1]), convertStringToInteger(date[2]), convertStringToBoolean(args[5]));
			
			if(isPresent == false) {
				System.out.println("Account is already in the database.");
			}
			else {
				System.out.println("Account opened and added to the database.");
			}
			
			break;
			
		case "OS":
			
			if(checkNumberOfInputs(args, numberOfArgumentsForOCandOS) != numberOfArgumentsForOCandOS) {
				break;
			}
			
			if (validString(args[1]) == null || validString(args[2]) == null || convertStringToDouble(args[3]) == null || 
			validDate(args[4]) == null || convertStringToBoolean(args[5])) {
				break;
			}
			
			date = args[4].split("/",3);

			
			isPresent = this.openSaving(validString(args[1]), validString(args[2]), convertStringToDouble(args[3]), convertStringToInteger(date[0]), 
			convertStringToInteger(date[1]), convertStringToInteger(date[2]), convertStringToBoolean(args[5]));
			
			if(isPresent == false) {
				System.out.println("Account is already in the database.");
			}
			else {
				System.out.println("Account opened and added to the database.");
			}
			
			break;
			
		case "OM":
				
			if(checkNumberOfInputs(args, numberOfArgumentsForOM) != numberOfArgumentsForOM) {
				break;
			}
			
			
			if (validString(args[1]) == null || validString(args[2]) == null || convertStringToDouble(args[3]) == null || 
			validDate(args[4]) == null) {
				break;
			}
			
			date = args[4].split("/",3);
			
			isPresent = this.openMoneyMarket(validString(args[1]), validString(args[2]), convertStringToDouble(args[3]), convertStringToInteger(date[0]), 
			convertStringToInteger(date[1]), convertStringToInteger(date[2]));
			
			if(isPresent == false) {
				System.out.println("Account is already in the database.");
			}
			else {
				System.out.println("Account opened and added to the database.");
			}
			
			break;
			
		case "CC":
			
			if(checkNumberOfInputs(args, numberOfArgumentsForClose) != numberOfArgumentsForClose) {
				break;
			}
			
			if(validString(args[1]) == null || validString(args[2]) == null) {
				break;
			}
			
			accountExists = this.closeChecking(validString(args[1]), validString(args[2]));
			
			if(accountExists == false) {
				System.out.println("Account does not exist.");
			}
			else {
				System.out.println("Account closed and removed from the database.");
			}
			
			break;
			
		case "CS":
			
			if(checkNumberOfInputs(args, numberOfArgumentsForClose) != numberOfArgumentsForClose) {
				break;
			}
			
			if(validString(args[1]) == null || validString(args[2]) == null) {
				break;
			}
			
			accountExists = this.closeSaving(validString(args[1]), validString(args[2]));
			
			if(accountExists == false) {
				System.out.println("Account does not exist.");
			}
			else {
				System.out.println("Account closed and removed from the database.");
			}
			
			break;
			
		case "CM":
			
			if(checkNumberOfInputs(args, numberOfArgumentsForClose) != numberOfArgumentsForClose) {
				break;
			}
			
			if(validString(args[1]) == null || validString(args[2]) == null) {
				break;
			}
			
			accountExists = this.closeMoneyMarket(validString(args[1]), validString(args[2]));
			
			if(accountExists == false) {
				System.out.println("Account does not exist.");
			}
			else {
				System.out.println("Account closed and removed from the database.");
			}
			
			break;
			
		case "DC":
				
			if(checkNumberOfInputs(args, numberOfArgumentsForDepositAndWithdraw) != numberOfArgumentsForDepositAndWithdraw) {
				break;
			}
			
			if(validString(args[1]) == null || validString(args[2]) == null || convertStringToDouble(args[3]) == null) {
				break;
			}
			
			moneyDeposited = this.depositChecking(validString(args[1]), validString(args[2]), convertStringToDouble(args[3]));
			
			if(moneyDeposited == false) {
				System.out.println("Account does not exist.");
			}
			else {
				System.out.println(args[3] + " deposited to account.");
			}
			
			break;
			
		case "DS":
			
			if(checkNumberOfInputs(args, numberOfArgumentsForDepositAndWithdraw) != numberOfArgumentsForDepositAndWithdraw) {
				break;
			}
			
			if(validString(args[1]) == null || validString(args[2]) == null || convertStringToDouble(args[3]) == null) {
				break;
			}
			
			moneyDeposited = this.depositSaving(validString(args[1]), validString(args[2]), convertStringToDouble(args[3]));
			
			if(moneyDeposited == false) {
				System.out.println("Account does not exist.");
			}
			else {
				System.out.println(args[3] + " deposited to account.");
			}
			
			break;
		case "DM":
			
			if(checkNumberOfInputs(args, numberOfArgumentsForDepositAndWithdraw) != numberOfArgumentsForDepositAndWithdraw) {
				break;
			}
			
			if(validString(args[1]) == null || validString(args[2]) == null || convertStringToDouble(args[3]) == null) {
				break;
			}
			
			moneyDeposited = this.depositMoneyMarket(validString(args[1]), validString(args[2]), convertStringToDouble(args[3]));
			
			if(moneyDeposited == false) {
				System.out.println("Account does not exist.");
			}
			else {
				System.out.println(args[3] + " deposited to account.");
			}
			
			break;
			
		case "WC":
			
			if(checkNumberOfInputs(args, numberOfArgumentsForDepositAndWithdraw) != numberOfArgumentsForDepositAndWithdraw) {
				break;
			}
			
			if(validString(args[1]) == null || validString(args[2]) == null || convertStringToDouble(args[3]) == null) {
				break;
			}
			accountStatus = this.withdrawChecking(validString(args[1]), validString(args[2]), convertStringToDouble(args[3]));
			if(accountStatus == 1) {
				System.out.println("Insufficient funds.");
			}
			else if(accountStatus == 0) {
				System.out.println(args[3] + " withdrawn from account.");
			}
			else {
				System.out.println("Account does not exist.");
			}
			
			break;
			
		case "WS":
			if(checkNumberOfInputs(args, numberOfArgumentsForDepositAndWithdraw) != numberOfArgumentsForDepositAndWithdraw) {
				break;
			}
			
			if(validString(args[1]) == null || validString(args[2]) == null || convertStringToDouble(args[3]) == null) {
				break;
			}
			
			accountStatus = this.withdrawSaving(validString(args[1]), validString(args[2]), convertStringToDouble(args[3]));
			
			if(accountStatus == 1) {
				System.out.println("Insufficient funds.");
			}
			else if(accountStatus == 0) {
				System.out.println(args[3] + " withdrawn from account.");;
			}
			else {
				System.out.println("Account does not exist.");
			}
			
			break;
			
		case "WM":
			
			if(checkNumberOfInputs(args, numberOfArgumentsForDepositAndWithdraw) != numberOfArgumentsForDepositAndWithdraw) {
				break;
			}
			
			if(validString(args[1]) == null || validString(args[2]) == null || convertStringToDouble(args[3]) == null) {
				break;
			}
			
			accountStatus = this.withdrawMoneyMarket(validString(args[1]), validString(args[2]), convertStringToDouble(args[3]));
			
			if(accountStatus == 1) {
				System.out.println("Insufficient funds.");
			}
			
			else if(accountStatus == 0) {
				System.out.println(args[3] + " withdrawn from account.");
			}
			
			else {
				System.out.println("Account does not exist.");
			}
			
			break;
			
		case "PA":
			
			if(this.accountDatabase.getsize() == 0) {
				System.out.println("Database is empty");
				break;
			}
			
			System.out.println("--Listing accounts in the database--");
			this.accountDatabase.printAccounts();
			System.out.println("--end of listing--");
			
			break;
			
		case "PD":
			
			if(this.accountDatabase.getsize() == 0) {
				System.out.println("Database is empty");
				break;
			}
			
			System.out.println("--Printing statements by date open--");
			this.accountDatabase.printByDateOpen();
			System.out.println("--end of printing--");
			break;
			
		case "PN":
			
			if(this.accountDatabase.getsize() == 0) {
				System.out.println("Database is empty");
				break;
			}
			
			System.out.println("--Printing statements by last name--");
			this.accountDatabase.printByLastName();
			System.out.println("--end of printing--");
			break;
			
		case "Q":
			System.out.println("Transaction processing completed");
			// Return false to break the loop in run()
			return false;
			
		default:
			System.out.printf("Command %s not supported!", command);
			System.out.println();
		}
		
		// Return true to continue loop in run()
		return true;
	}
	
	/**
	* runs the transaction manager
	*/
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
