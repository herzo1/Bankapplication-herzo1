package classes;

public class Customer {
	private Account[] accounts;
	private static int MAX_ACCOUNTS = 10;
	private String name;
	private int nr;
	private int numAccounts = 0;
	private String password;
	
	Customer(int nr, String name, String password){
		this.nr = nr;
		this.name = name;
		this.password = password;
		this.accounts = new Account[MAX_ACCOUNTS];
	}
	
	public boolean addAccount(Account account) {
		boolean success = false;
		if(this.numAccounts < Customer.MAX_ACCOUNTS) {
			this.accounts[this.numAccounts] = account;
			this.numAccounts++;
			success = true;
		}
		return success;
	}
	
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
	
	public Account[] getAccounts() {
		return this.accounts;
	}

	public String getName() {
		return this.name;
	}
	
	public int getNr() {
		return this.nr;
	}
	
	public double getTotalBalance() {
		// TODO: implement this method
		double totalBalance = 0;
		for(int i=0; i<this.numAccounts; i++) {
			totalBalance = this.accounts[i].getBalance();
		}
		return totalBalance;
	}
	
	public String toString() {
		// TODO: implement this method
		return "[" + this.nr + ", " + this.name + ", " + this.numAccounts + "]";
	}
	
	
}
