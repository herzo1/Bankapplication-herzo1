package classes;

public class Bank {
	
	public static final int MAX_ACCOUNTS = 100;
	public static final int MAX_CUSTOMERS = 100;
	
	private Account[] accounts;
	private Customer[] customers;
	private String name;
	private int numAccounts;
	private int numCustomers;
	
	public Bank(String name) {
		this.name = name;
		
		accounts = new Account[MAX_ACCOUNTS];
		customers = new Customer[MAX_CUSTOMERS];
		this.numAccounts = 0;
		this.numCustomers = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean deposit(int accountNr, double amount) {
		if(!validateAccountNr(accountNr)) {
			return false;
		}
		Account acc = this.findAccount(accountNr);
		if (acc.deposit(amount)) {
			return true;
		}
		return false;
	}
	
	public boolean withdraw(int accountNr, String pin, double amount) {
		if(!validateAccountNr(accountNr)) {
			return false;
		}
		Account acc = this.findAccount(accountNr);
		if (acc.withdraw(amount)) {
			return true;
		}
		return false;
	}
	
	public boolean transfer(int debitAccountNr, int creditAccountNr, double amount) {
		if(!this.validateAccountNr(debitAccountNr) || !this.validateAccountNr(creditAccountNr)) {
			return false;
		}
		Account debitAcc = this.findAccount(debitAccountNr);
		Account creditAcc = this.findAccount(creditAccountNr);
		if(!debitAcc.withdraw(amount)) {
			return false;
		}
		if(!creditAcc.deposit(amount)) {
			return false;
		}
		return true;
	}
	
	private Account findAccount(int accountNr) {
		if(accountNr > this.numAccounts) {
			return null;
		}
		return this.accounts[accountNr];
	}
	
	private boolean validateAccountNr(int accountNr) {
		return accountNr <= this.numAccounts && accountNr >= 0;
	}
	
	private boolean validateCustomerNr(int customerNr) {
		return customerNr <= this.numCustomers && customerNr >= 0;

	}
	
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
	
	public double getBalance(int accountNr, String pin) {
		Account acc = this.findAccount(accountNr);
		if(acc.checkPin(pin)) {
			return acc.getBalance();
		}
		return -1;
	}
	
	public Account openAccount(Customer customer, String pin) {
		Account account = new Account(this.numAccounts, pin);
		this.accounts[this.numAccounts++] = account;
		customer.addAccount(account);
		return account;
	}
	
	public Customer registerCustomer(String name, String password) {
		Customer customer = new Customer(this.numCustomers, name, password);
		this.customers[this.numCustomers++] = customer;
		return customer;
	}
}
