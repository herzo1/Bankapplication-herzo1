package bankapp.bank;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Bank
 * @author Oliver.Herzig
 *
 */
public class Bank implements ATMInterface, EBankingInterface {
	private static final int ACCOUNT_OFFSET = 100;
	private static final int CUSTOMER_OFFSET = 10;
	
	private List<Account> accounts;
	private List<Customer> customers;
	private String name;
	
	/**
	 * Constructs a bank account.
	 * @param name - the bank name
	 */
	public Bank(String name) {
		this.name = name;
		
		this.accounts = new ArrayList<>();
		this.customers = new ArrayList<>(); 
	}
	/**
	 * Gets the name of the bank.
	 * @return the bank name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Deposits money into an account.
	 * @param accountNr - the account number
	 * @param amount - the amount of money to deposit
	 * @return true if the amount has been deposited, or false if an error occurred
	 */
	public boolean deposit(int accountNr, double amount) {
		Account acc = this.findAccount(accountNr);
		return acc != null? acc.deposit(amount) : false;
	}
	
	/**
	 * Withdraws money from an account.
	 * @param accountNr - the account number
	 * @param pin - the PIN of the account
	 * @param amount - the amount of money to withdraw
	 * @return true if the amount has been withdrawn, false if an error occurred
	 */
	public boolean withdraw(int accountNr, String pin, double amount) {
		Account acc = this.findAccount(accountNr);
		return acc != null && acc.checkPin(pin) && acc.withdraw(amount);
	}
	
	/**
	 * Transfers money from an account to another account.
	 * @param debitAccountNr - the number of the debit account
	 * @param pin - the PIN of the debit account
	 * @param creditAccountNr - the number of the credit account
	 * @param amount - the amount of money to withdraw
	 * @return true if the amount has been transfered, false if an error occurred
	 */
	public boolean transfer(int debitAccountNr, String pin, int creditAccountNr, double amount) {
		if (this.findAccount(debitAccountNr)==null || this.findAccount(creditAccountNr) == null) {
			return false;
		}
		return this.withdraw(debitAccountNr, pin, amount) && this.deposit(creditAccountNr, amount);
	}
	
	/**
	 * Finds a bank account.
	 * @param accountNr - the account number
	 * @return the found account, or null if the account does not exist
	 */
	public Account findAccount(int accountNr) {
		accountNr -= ACCOUNT_OFFSET;
		if(accountNr < 0 || accountNr >= this.accounts.size()) {
			return null;
		}
		return this.accounts.get(accountNr);
	}
	/**
	 * Authenticates a bank customer. 
	 * @param customerNr - the customer number
	 * @param password - the password of the customer
	 * @return the authenticated customer if the authentication was successful, false otherwise
	 */
	public Customer authenticateCustomer(int customerNr, String password) {
		customerNr -= CUSTOMER_OFFSET;
		if(customerNr < 0 || customerNr >= this.customers.size()) {
			return null;
		}
		Customer customer = this.customers.get(customerNr); 
		return customer.checkPassword(password)? customer : null;
	}
	
	/**
	 * Gets the balance of an account.
	 * @param accountNr - the account number
	 * @param pin - the PIN of the account
	 * @return the account balance, or null if an error occurred.
	 */
	public Double getBalance(int accountNr, String pin) {
		Account acc = this.findAccount(accountNr);
		return acc != null && acc.checkPin(pin)? acc.getBalance() : null;
	}
	
	/**
	 * Opens a saving bank account.
	 * @param customer - the customer of the account
	 * @param pin - the PIN of the account
	 * @return the opened account
	 */
	public Account openSavingsAccount(Customer customer, String pin, double limit) {
		return this.addAccount(customer, new SavingsAccount(this.accounts.size() + ACCOUNT_OFFSET, pin, limit));
	}
	
	/**
	 * Opens a personal bank account.
	 * @param customer - the customer of the account
	 * @param pin - the PIN of the account
	 * @return the opened account
	 */
	public Account openPersonalAccount(Customer customer, String pin) {
		return addAccount(customer, new PersonalAccount(this.accounts.size() + ACCOUNT_OFFSET, pin));
	}
	
	private Account addAccount(Customer customer, Account account) {
		this.accounts.add(account);
		customer.addAccount(account);
		return account;
	}
	
	/**
	 * Registers a customer with the bank.
	 * @param name - the customer name
	 * @param password - the password of the customer
	 * @return the registered customer
	 */
	public Customer registerCustomer(String name, String password) {
		Customer customer = new Customer(this.customers.size() + CUSTOMER_OFFSET, name, password); 
		this.customers.add(customer);
		return customer;
	}
	
}
