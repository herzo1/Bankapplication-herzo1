package banktest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bankapp.bank.Account;
import bankapp.bank.Bank;
import bankapp.bank.Customer;

class BankTestDoz {

	private static final String BANK_NAME = "EASYBank";
	private static final String CUSTOMER_NAME = "John Smith";
	private static final String PASSWORD = "****";
	private static final String PIN = "1234";
	private static final double AMOUNT = 1000.0;
	private static final double DELTA = 0.001;
	private static final double LIMIT = 1000;

	private Bank bank;
	private Customer customer;
	private Account account1, account2, account3;

	@BeforeEach
	void init() {
		bank = new Bank(BANK_NAME);
		customer = bank.registerCustomer(CUSTOMER_NAME, PASSWORD);
		account1 = bank.openPersonalAccount(customer, PIN);
		account2 = bank.openPersonalAccount(customer, PIN);
		account3 = bank.openSavingsAccount(customer, PIN, LIMIT);
	}
	
	/* TODO: test-method for savingsAccount (account3) */
	
	@Test
	void testRegistration() {
		assertTrue(customer.getNr() > 0);
		assertEquals(CUSTOMER_NAME, customer.getName());
	}

	@Test
	void testAuthentication() {
		assertNotNull(bank.authCustomer(customer.getNr(), PASSWORD));
	}

	@Test
	void testAuthenticationWithInvalidNr() {
		assertNull(bank.authCustomer(0, PASSWORD));
	}

	@Test
	void testAuthenticationWithInvalidPassword() {
		assertNull(bank.authCustomer(customer.getNr(), ""));
	}

	@Test
	public void testAccountOpening() {
		assertTrue(account1.getNr() > 0);
		assertEquals(0, account1.getBalance(), DELTA);
	}

	@Test
	public void testBalanceCheck() {
		assertEquals(0, bank.getBalance(account1.getNr(), PIN), DELTA);
	}

	@Test
	public void testBalanceCheckWithInvalidNr() {
		assertNull(bank.getBalance(0, PIN));
	}

	@Test
	public void testBalanceCheckWithInvalidPin() {
		assertNull(bank.getBalance(account1.getNr(), ""));
	}

	@Test
	public void testDeposit() {
		assertTrue(bank.deposit(account1.getNr(), AMOUNT));
		assertEquals(AMOUNT, bank.getBalance(account1.getNr(), PIN), DELTA);
	}

	@Test
	public void testDepositWithInvalidNr() {
		assertFalse(bank.deposit(0, AMOUNT));
	}

	@Test
	public void testDepositWithInvalidAmount() {
		assertFalse(bank.deposit(account1.getNr(), -AMOUNT));
		assertEquals(0, bank.getBalance(account1.getNr(), PIN), DELTA);
	}

	@Test
	public void testWithdrawal() {
		assertTrue(bank.withdraw(account1.getNr(), PIN, AMOUNT));
		assertEquals(-AMOUNT, bank.getBalance(account1.getNr(), PIN), DELTA);
	}

	@Test
	public void testWithdrawalWithInvalidNr() {
		assertFalse(bank.withdraw(0, PIN, AMOUNT));
	}

	@Test
	public void testWithdrawalWithInvalidPIN() {
		assertFalse(bank.withdraw(account1.getNr(), "", AMOUNT));
		assertEquals(0, bank.getBalance(account1.getNr(), PIN), DELTA);
	}

	@Test
	public void testWithdrawalWithInvalidAmount() {
		assertFalse(bank.withdraw(account1.getNr(), PIN, -AMOUNT));
		assertEquals(0, bank.getBalance(account1.getNr(), PIN), DELTA);
	}

	@Test
	public void testTransfer() {
		assertTrue(bank.transfer(account1.getNr(), PIN, account2.getNr(), AMOUNT));
		assertEquals(-AMOUNT, bank.getBalance(account1.getNr(), PIN), DELTA);
		assertEquals(AMOUNT, bank.getBalance(account2.getNr(), PIN), DELTA);
	}

	@Test
	public void testTransferWithInvalidDebitAccountNr() {
		assertFalse(bank.transfer(0, PIN, account2.getNr(), AMOUNT));
		assertEquals(0, bank.getBalance(account2.getNr(), PIN), DELTA);
	}

	@Test
	public void testTransferWithInvalidPin() {
		assertFalse(bank.transfer(account1.getNr(), "", account2.getNr(), AMOUNT));
		assertEquals(0, bank.getBalance(account1.getNr(), PIN), DELTA);
		assertEquals(0, bank.getBalance(account2.getNr(), PIN), DELTA);
	}

	@Test
	public void testTransferWithInvalidCreditAccountNr() {
		assertFalse(bank.transfer(account1.getNr(), PIN, 0, AMOUNT));
		assertEquals(0, bank.getBalance(account1.getNr(), PIN), 0.001);
	}

	@Test
	public void testTransferWithInvalidAmount() {
		assertFalse(bank.transfer(account1.getNr(), PIN, account2.getNr(), -AMOUNT));
		assertEquals(0, bank.getBalance(account1.getNr(), PIN), DELTA);
		assertEquals(0, bank.getBalance(account2.getNr(), PIN), DELTA);
	}
}
