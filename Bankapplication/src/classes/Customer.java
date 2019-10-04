package classes;

public class Customer {
	private Account[] accounts;
	private static int MAX_ACCOUNTS = 10;
	private String name;
	private int nr;
	private int numAccounts;
	private String password;
	
	Customer(int nr, String name, String password){
		this.nr = nr;
		this.name = name;
		this.password = password;
	}
	
	public boolean addAccount(Account account) {
		// TODO: implement this method
		return false;
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
		return 0;
	}
	
	public String toString() {
		// TODO: implement this method
		return "";
	}
	
	
}
