package account;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This tests the methods of the MoneyMarket class
 * @author Steven Nguyen, Julian Romero
 */
class MoneyMarketTests {

	/**
	 * Tests if monthly interest is 1/12 of .05% of the balance
	 */
	@Test
	void monthlyInterestIsRight() {
		MoneyMarket moneyMarket;
		
		moneyMarket = new MoneyMarket("_", "_", 120000, 1, 1, 2000);
		assertEquals(65, moneyMarket.monthlyInterest(), "Monthly interest of a balance of 120,000 should be 65");
		
		moneyMarket = new MoneyMarket("_", "_", 0, 1, 1, 2000);
		assertEquals(0, moneyMarket.monthlyInterest(), "Monthly interest of a balance of 0 should be 0");
	}

	/**
	 * Tests if the minimum balance works properly
	 */
	@Test
	void monthlyFeeShouldBeWaivedIfBalanceIsHigh() {
		MoneyMarket moneyMarket;
		
		moneyMarket = new MoneyMarket("_", "_", 2500, 1, 1, 2000);
		assertEquals(0, moneyMarket.monthlyFee(), "MonthlyFee should be waived at 2500 balance");
		
		moneyMarket = new MoneyMarket("_", "_", 2501, 1, 1, 2000);
		assertEquals(0, moneyMarket.monthlyFee(), "MonthlyFee should be waived above 2500 balance");
		
		moneyMarket = new MoneyMarket("_", "_", 2499, 1, 1, 2000);
		assertEquals(12, moneyMarket.monthlyFee(), "MonthlyFee should 12 below 2500 balance");
	}
	
	/**
	 * Tests if withdrawals works properly
	 */
	@Test
	void monthlyFeeShouldNotBeWaivedWithMoreThan6Withdrawals() {
		MoneyMarket moneyMarket;
		moneyMarket = new MoneyMarket("_", "_", 3200, 1, 1, 2000);
		
		assertEquals(0, moneyMarket.monthlyFee(), "MonthlyFee should be waived with 3200 balance and no withdrawals");
		
		int withdrawals = 0;
		for (; withdrawals < 6; withdrawals++) {
			moneyMarket.debit(100);
		}
		
		assertEquals(0, moneyMarket.monthlyFee(), "MonthlyFee should be waived with 2600 balance and 6 withdrawals");
		
		moneyMarket.debit(100);
		assertEquals(12, moneyMarket.monthlyFee(), "MonthlyFee should not be waived with 2500 balance and 7 withdrawals");
	}
	
	/**
	 * Tests if .equals works properly
	 */
	@Test
	void moneyMarketAccountsWithTheSameNameShouldBeEqual() {
		MoneyMarket m1 = new MoneyMarket("B", "B", 100, 1, 1, 2000);
		MoneyMarket m2 = new MoneyMarket("A", "A", 150, 1, 1, 2000);
		MoneyMarket m3 = new MoneyMarket("B", "B", 1501, 1, 1, 2000);
		
		assertEquals(m1, m1, "A MoneyMarket account should equal itself");
		assertNotEquals(m1, m2, "MoneyMarket accounts with different names should not be equal");
		assertEquals(m1, m3, "MoneyMarket account with the same name should be equal");
	}
}
