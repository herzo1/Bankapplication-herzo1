package bfh.bank;

/**
 * Class Customer
 * @author Oliver.Herzig
 *
 */
public class Customer {
	
	static final int MAX_ACCOUNTS = 10;
	
	private final Account[] accounts;
	private final String name;
	private final int nr;
	private int numAccounts;
	private String password;
	
	/**
	 * Constructs a bank customer.
	 * @param nr - the customer number
	 * @param name - the customer name
	 * @param password - the password of the customer
	 */
	public Customer(int nr, String name, String password){
		this.nr = nr;
		this.name = name;
		this.password = (password==null)?"" : password;
		this.accounts = new Account[MAX_ACCOUNTS];
		this.numAccounts = 0;
	}
	
	/**
	 * Gets the accounts of the customer.
	 * @return the customer accounts
	 */
	public Account[] getAccounts() {
		/*
		 * Don't do 'return this.accounts'! In this case you will return
		 * the pointer to the accounts-array and you can override 
		 * the variables inside the array form the outside.
		 */
		Account[] rtrnArray = new Account[this.numAccounts+1];
		for(int i=0; i<=this.numAccounts; i++) {
			rtrnArray[i] = this.accounts[i];
		}
		return rtrnArray;
	}

	/**
	 * Gets the name of the customer.
	 * @return the customer name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the number of the customer.
	 * @return the customer number
	 */
	public int getNr() {
		return this.nr;
	}
	
	/**
	 * Adds an account to the customer.
	 * @param account - the account to be added
	 * @return true if the addition was successful, false otherwise
	 */
	public boolean addAccount(Account account) {
		if(this.numAccounts >= MAX_ACCOUNTS || account == null) {
			return false;
		}
		this.accounts[this.numAccounts++] = account;
		return true;
	}
	
	/**
	 * Checks the password of the customer.
	 * @param password - the password to check
	 * @return true if the password is valid, false otherwise
	 */
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
	
	/**
	 * Gets the total balance of the accounts.
	 * @return the total balance
	 */
	public double getTotalBalance() {
		double totalBalance = 0;
		for(int i=0; i<this.numAccounts; i++) {
			totalBalance += this.accounts[i].getBalance();
		}
		return totalBalance;
	}
	
	/**
	 * Generates a string representation of the customer.
	 * @return a string representing the customer
	 */
	public String toString() {
		String s = "Customer: " +
				"nr=" + this.nr + ", "+
				"name=" + this.name + ", " +
				"totalBalance=" + String.format("%.2f\n", this.getTotalBalance());
		
		for(Account account : this.accounts) {
			if(account != null) {
				s += " - " + account.toString();
			}
		}
		return s;
	}
	
	
}
