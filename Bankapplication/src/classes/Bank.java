package classes;

/**
 * Class Bank
 * @author Oliver.Herzig
 *
 */
public class Bank {
	
	public static final int MAX_ACCOUNTS = 100;
	public static final int MAX_CUSTOMERS = 100;
	
	private Account[] accounts;
	private Customer[] customers;
	private String name;
	private int numAccounts;
	private int numCustomers;
	
	/**
	 * Constructs a bank account.
	 * @param name - the bank name
	 */
	public Bank(String name) {
		this.name = name;
		
		accounts = new Account[MAX_ACCOUNTS];
		customers = new Customer[MAX_CUSTOMERS];
		this.numAccounts = 0;
		this.numCustomers = 0;
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
		if(!validateAccountNr(accountNr)) {
			return false;
		}
		Account acc = this.findAccount(accountNr);
		return acc.deposit(amount);
	}
	
	/**
	 * Withdraws money from an account.
	 * @param accountNr - the account number
	 * @param pin - the PIN of the account
	 * @param amount - the amount of money to withdraw
	 * @return true if the amount has been withdrawn, false if an error occurred
	 */
	public boolean withdraw(int accountNr, String pin, double amount) {
		if(!validateAccountNr(accountNr)) {
			return false;
		}
		Account acc = this.findAccount(accountNr);
		if(!acc.checkPin(pin)) {
			return false;
		}
		return acc.withdraw(amount);
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
		if(!this.validateAccountNr(debitAccountNr) || !this.validateAccountNr(creditAccountNr)) {
			return false;
		}
		Account debitAcc = this.findAccount(debitAccountNr);
		Account creditAcc = this.findAccount(creditAccountNr);
		if (!debitAcc.checkPin(pin)) {
			return false;
		}
		return debitAcc.withdraw(amount) && creditAcc.deposit(amount);
	}
	
	/**
	 * Finds a bank account.
	 * @param accountNr - the account number
	 * @return the found account, or null if the account does not exist
	 */
	private Account findAccount(int accountNr) {
		if(accountNr > this.numAccounts) {
			return null;
		}
		return this.accounts[accountNr];
	}
	
	/**
	 * Validate if the given accountNr is an actual account.
	 * @param accountNr - the account number
	 * @return true if valid accountNr, false otherwise
	 */
	private boolean validateAccountNr(int accountNr) {
		return accountNr <= this.numAccounts && accountNr >= 0;
	}
	
	/**
	 * Validate if the given customerNr is an actual customer.
	 * @param customerNr - the customer number
	 * @return true if valid customerNr, false otherwise
	 */
	private boolean validateCustomerNr(int customerNr) {
		return customerNr <= this.numCustomers && customerNr >= 0;

	}
	
	/**
	 * Authenticates a bank customer. 
	 * @param customerNr - the customer number
	 * @param password - the password of the customer
	 * @return the authenticated customer if the authentication was successful, false otherwise
	 */
	public Customer authCustomer(int customerNr, String password) {
		if(!this.validateCustomerNr(customerNr)) {
			return null;
		}
		Customer customer = this.customers[customerNr];
		if(customer.checkPassword(password)) {
			return customer;
		}
		return null;
	}
	
	/**
	 * Gets the balance of an account.
	 * @param accountNr - the account number
	 * @param pin - the PIN of the account
	 * @return the account balance, or null if an error occurred.
	 */
	public Double getBalance(int accountNr, String pin) {
		Account acc = this.findAccount(accountNr);
		if(acc.checkPin(pin)) {
			return acc.getBalance();
		}
		return null;
	}
	
	/**
	 * Opens a bank account.
	 * @param customer - the customer of the account
	 * @param pin - the PIN of the account
	 * @return the opened account
	 */
	public Account openAccount(Customer customer, String pin) {
		Account account = new Account(this.numAccounts, pin);
		this.accounts[this.numAccounts++] = account;
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
		Customer customer = new Customer(this.numCustomers, name, password);
		this.customers[this.numCustomers++] = customer;
		return customer;
	}
}
