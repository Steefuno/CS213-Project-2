import java.text.DecimalFormat;

public class AccountDatabase {
	private Account[] accounts;
	private int size;

	private static final int GROW_SIZE = 5;

	public AccountDatabase() {
		this.size = 0;
		this.accounts = new Account[5];
	}

	private int find(Account account) {
		for (int i = 0; i < this.size; i++) {
			if (accounts[i] == account) {
				return i;
			}
		}
		return -1;
	}
	
	private void grow() {
		Account[] expandedAccounts = new Account[this.accounts.length + GROW_SIZE];
		System.arraycopy(this.accounts, 0, expandedAccounts, 0, this.accounts.length);
		this.accounts = expandedAccounts;
	}
	
	public boolean add(Account account) {
		if (this.find(account) != -1) {
			return false;
		}
		
		if ((size + 1) % GROW_SIZE == 0) {
			this.grow();
		}
		
		this.accounts[size] = account;
		size++;
		return true;
	}
	
	public boolean remove(Account account) {
		int accountIndex = this.find(account);
		if (accountIndex == -1) {
			return false;
		}
		
		for (int i = accountIndex; i < size; i++) {
			accounts[i] = accounts[i + 1];
		}
		
		size--;
		accounts[size] = null;
		return true;
	}
	
	public boolean deposit(Account account, double amount) {
		int accountIndex = this.find(account);
		if (accountIndex == -1) {
			return false;
		}
		
		account = accounts[accountIndex];
		
		account.credit(amount);
		return true;
	}
	
	public int withdrawal(Account account, double amount) {
		int accountIndex = this.find(account);
		if (accountIndex == -1) {
			return -1;
		}
		
		account = accounts[accountIndex];
		if (account.getBalance() - amount < 0) {
			return 1;
		}
		
		account.debit(amount);
		return 0;
	}

	/*private void sortByDateOpenHelper(int startIndex, int endIndex) {
		int pivotIndex = endIndex - 1;
		
		if (pivotIndex <= startIndex)
			return;
		
		Date pivot = accounts[pivotIndex].getOpenDate();
		int smallerIndex = startIndex;
		
		for (int i = startIndex; i < endIndex; i++) {
			Account account = accounts[i];
			Date date = account.getOpenDate();
			
			int dateComparison = date.compareTo(pivot);
			if (dateComparison < 0) {
				accounts[i] = accounts[smallerIndex];
				accounts[smallerIndex] = account;
				smallerIndex++;
			}
		}
		
		Account account = accounts[smallerIndex];
		accounts[smallerIndex] = accounts[pivotIndex];
		accounts[pivotIndex] = account;
		
		sortByLastNameHelper(startIndex, smallerIndex);
		sortByLastNameHelper(smallerIndex + 1, endIndex);
		return;
	}
	
	private void sortByDateOpen() {
		sortByDateOpenHelper(0, size);
	}*/
	
	private void sortByLastNameHelper(int startIndex, int endIndex) {
		int pivotIndex = endIndex - 1;
		
		if (pivotIndex <= startIndex)
			return;
		
		Profile pivot = accounts[pivotIndex].getProfile();
		int smallerIndex = startIndex;
		
		for (int i = startIndex; i < endIndex; i++) {
			Account account = accounts[i];
			Profile profile = account.getProfile();
			
			int nameComparison = profile.compareTo(pivot);
			if (nameComparison < 0) {
				accounts[i] = accounts[smallerIndex];
				accounts[smallerIndex] = account;
				smallerIndex++;
			}
		}
		
		Account account = accounts[smallerIndex];
		accounts[smallerIndex] = accounts[pivotIndex];
		accounts[pivotIndex] = account;
		
		sortByLastNameHelper(startIndex, smallerIndex);
		sortByLastNameHelper(smallerIndex + 1, endIndex);
		return;
	}
	
	private void sortByLastName() {
		sortByLastNameHelper(0, this.size);
	}
	
	private void updateAccount(int accountIndex) {
		Account account = accounts[accountIndex];
		double interest = account.monthlyInterest();
		double fee = account.monthlyFee();
		double newBalance = account.getBalance() + interest - fee;
		
		String priceFormat = "$ #.#";
		DecimalFormat formattedPrice = new DecimalFormat(priceFormat);
		formattedPrice.setMinimumFractionDigits(2);
		
		System.out.println(
			String.format(
				"\n%s\n-interest: %s\n-fee: %s\n-new balance: %s",
				account,
				formattedPrice.format(interest),
				formattedPrice.format(fee),
				formattedPrice.format(newBalance)
			)
		);
		
		account.credit(interest);
		account.debit(fee);
		return;
	}
	
	/*public void printByDateOpen() {
		sortByDateOpen();
		
		System.out.println("--Printing statements by last name--");
		
		for (int i = 0; i < this.size; i++) {
			updateAccount(i);
		}
		
		System.out.println("--end of printing--");
		return;
	}*/
	
	public void printByLastName() {
		sortByLastName();
		
		System.out.println("--Printing statements by last name--");
		
		for (int i = 0; i < this.size; i++) {
			updateAccount(i);
		}
		
		System.out.println("--end of printing--");
		return;
	}
	
	public void printAccounts() {
		System.out.println("--Listing accounts in the database--");
		
		for (int i = 0; i < this.size; i++) {
			System.out.println(accounts[i]);
		}
		
		System.out.println("--end of listing--");
		return;
	}
}