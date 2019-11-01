package banktest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bankapp.bank.Account;
import bankapp.bank.Bank;
import bankapp.bank.Customer;

class BankTest {
	private static final String BANKNAME = "Testbank";
	private static final String CUSTOMER_NAME = "Testcustomer";
	private static final String PASSWORD = "12345";
	private static final String PIN = "123";
	
	Bank testBank = new Bank(BANKNAME);
	Customer testCustomer = testBank.registerCustomer(CUSTOMER_NAME, PASSWORD);
	Account testAccount = testBank.openAccount(testCustomer, PIN);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetName() {
		assertEquals(BANKNAME, testBank.getName());
	}
	
	@Test
	void testRegisterCustomer() {
		assertEquals(CUSTOMER_NAME, testCustomer.getName());
		assertEquals(true, testCustomer.checkPassword(PASSWORD));
	}
	
	@Test
	void testOpenAccount() {
		assertEquals(true, testAccount.checkPin(PIN));
	}

	@Test
	void testDeposit() {
		double amount = 1000;
		assertEquals(true, testBank.deposit(testAccount.getNr(), amount));
		assertEquals(amount, testBank.getBalance(testAccount.getNr(), PIN));
	}
	@Test
	void testNegativeDeposit() {
		double negAmount = -1000;
		assertEquals(false, testBank.deposit(testAccount.getNr(), negAmount));
	}

	@Test
	void testWithdraw() {
		double withAmount = 1000;
		double initBalance = testAccount.getBalance();
		assertEquals(true, testBank.withdraw(testAccount.getNr(), PIN, withAmount));
		assertEquals(initBalance - withAmount, testBank.getBalance(testAccount.getNr(), PIN), 0.0001);
	}
	
	@Test
	void testNegativeWithdraw() {
		double negWithAmount = -100;
		assertEquals(false, testBank.withdraw(testAccount.getNr(), PIN, negWithAmount));
	}

	@Test
	void testTransfer() {
		Account transferTestAccount = testBank.openAccount(testCustomer, PIN);
		double amount = 1000;
		testBank.deposit(testAccount.getNr(), amount);
		testBank.deposit(transferTestAccount.getNr(), amount);
		assertEquals(true, testBank.transfer(testAccount.getNr(), PIN, transferTestAccount.getNr(), amount));
		assertEquals(0, testBank.getBalance(testAccount.getNr(), PIN));
		assertEquals(2*amount, testBank.getBalance(transferTestAccount.getNr(), PIN));
	}
	
	@Test
	void testNegativeTransfer() {
		Account transferTestAccount = testBank.openAccount(testCustomer, PIN);
		double amount = -1000;
		testBank.deposit(testAccount.getNr(), amount);
		testBank.deposit(transferTestAccount.getNr(), amount);
		assertEquals(false, testBank.transfer(testAccount.getNr(), PIN, transferTestAccount.getNr(), amount));
	}

	@Test
	void testAuthCustomer() {
		assertEquals(testCustomer, testBank.authCustomer(testCustomer.getNr(), PASSWORD));
	}
	
	@Test
	void testFalseAuthCustomer() {
		assertEquals(null, testBank.authCustomer(testCustomer.getNr(), PASSWORD + "false stuff"));
	}

	@Test
	void testGetBalance() {
		Account getBalanceAccount = testBank.openAccount(testCustomer, PIN);
		double amount = 1000;
		testBank.deposit(getBalanceAccount.getNr(), amount);
		assertEquals(amount, testBank.getBalance(getBalanceAccount.getNr(), PIN));
	}
}
