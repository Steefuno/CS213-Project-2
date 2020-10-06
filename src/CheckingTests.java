import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests methods of the Checking class
 * @author Steven Nguyen, Julian Romero
 */
class CheckingTests {

	/**
	 * Tests if monthly interest is 1/12 of .05% of the balance
	 */
	@Test
	void monthlyInterestIsRight() {
		Checking checking;
		
		checking = new Checking("_", "_", 120000, 1, 1, 2000, false);
		assertEquals(5, checking.monthlyInterest(), "Monthly interest of a balance of 120,000 should be 5");
		
		checking = new Checking("_", "_", 0, 1, 1, 2000, false);
		assertEquals(0, checking.monthlyInterest(), "Monthly interest of a balance of 0 should be 0");
	}

	/**
	 * Tests if the minimum balance works properly
	 */
	@Test
	void monthlyFeeShouldBeWaivedIfBalanceIsHigh() {
		Checking checking;
		
		checking = new Checking("_", "_", 1500, 1, 1, 2000, false);
		assertEquals(0, checking.monthlyFee(), "MonthlyFee should be waived at 1500 balance");
		
		checking = new Checking("_", "_", 1501, 1, 1, 2000, false);
		assertEquals(0, checking.monthlyFee(), "MonthlyFee should be waived above 1500 balance");
		
		checking = new Checking("_", "_", 1499, 1, 1, 2000, false);
		assertEquals(25, checking.monthlyFee(), "MonthlyFee should 25 below 1500 balance");
	}
	
	/**
	 * Tests if the direct deposit attribute works properly
	 */
	@Test
	void monthlyFeeShouldBeWaivedWithDirectDeposit() {
		Checking checking;
		
		checking = new Checking("_", "_", 0, 1, 1, 2000, true);
		assertEquals(0, checking.monthlyFee(), "MonthlyFee should be waived with direct deposit");
		
		checking = new Checking("_", "_", 0, 1, 1, 2000, false);
		assertEquals(25, checking.monthlyFee(), "MonthlyFee below 1500 should not be waived without DirectDeposit");
	}
	
	/**
	 * Tests if .equals works properly
	 */
	@Test
	void checkingAccountsWithTheSameNameShouldBeEqual() {
		Checking c1 = new Checking("B", "B", 100, 1, 1, 2000, true);
		Checking c2 = new Checking("A", "A", 150, 1, 1, 2000, false);
		Checking c3 = new Checking("B", "B", 1501, 1, 1, 2000, false);
		
		assertEquals(c1, c1, "A checking account should equal itself");
		assertNotEquals(c1, c2, "Checking accounts with different names should not be equal");
		assertEquals(c1, c3, "Checking account with the same name should be equal");
	}
}
