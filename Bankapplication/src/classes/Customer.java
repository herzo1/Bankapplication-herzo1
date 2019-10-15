package classes;

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
	 * Constructor of the Customer class
	 * @param nr
	 * @param name
	 * @param password
	 */
	public Customer(int nr, String name, String password){
		// this -> Pointer auf aktuelle Instanz der Klasse
		this.nr = nr;
		this.name = name;
		this.password = (password==null)?"" : password;
		this.accounts = new Account[MAX_ACCOUNTS];
		this.numAccounts = 0;
	}
	
	/**
	 * Return all accounts of the customer
	 * @return
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

	
	public String getName() {
		return this.name;
	}

	public int getNr() {
		return this.nr;
	}
	
	/**
	 * Add new account to the customer
	 * @param account
	 * @return
	 */
	public boolean addAccount(Account account) {
		if(this.numAccounts >= MAX_ACCOUNTS || account == null) {
			return false;
		}
		this.accounts[this.numAccounts++] = account;
		return true;
	}
	
	/**
	 * Check typed password
	 * @param password
	 * @return
	 */
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
	
	/**
	 * Get the total balance over all accounts
	 * @return
	 */
	public double getTotalBalance() {
		double totalBalance = 0;
		for(int i=0; i<this.numAccounts; i++) {
			totalBalance += this.accounts[i].getBalance();
		}
		return totalBalance;
	}
	
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
