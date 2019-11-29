package bankapp.bank;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Account
 * @author Oliver.Herzig
 *
 */
public class Account {
	private List<Transaction> transactions;
	protected double balance;
	protected final int nr;
	protected String pin;
	
	/**
	 * Constructs a bank account.
	 * @param nr - the account number
	 * @param pin - the PIN of the account
	 */
	public Account(int nr, String pin){
		this(nr, pin, 0);
	}
	
	/**
	 * Constructs a bank account.
	 * @param nr - the account number
	 * @param pin - the PIN of the account
	 * @param balance - the initial balance
	 */
	public Account(int nr, String pin, double balance){
		this.nr = nr;
		this.pin = (pin == null)? "" : pin;
		this.balance = balance;
		this.transactions = new ArrayList<>();
	}
	
	/**
	 * Checks the PIN of the account.
	 * @param pin - the PIN to check
	 * @return true if the PIN is valid, false otherwise
	 */
	public boolean checkPin(String pin) {
		return this.pin.equals(pin);
	}
	
	/**
	 * Deposits money into the account.
	 * @param amount - the amount of money to deposit
	 * @return true if the deposit was successful, false otherwise
	 */
	protected boolean deposit(double amount) {
		if(amount < 0) {
			return false;
		}
		this.balance += amount;
		this.transactions.add(new Transaction(amount, balance));
		return true;
	}
	
	/**
	 * Gets the balance of the account.
	 * @return the account balance
	 */
	public double getBalance() {
		return this.balance;
	}
	
	/**
	 * Gets the number of the account.
	 * @return the account number
	 */
	public int getNr() {
		return this.nr;
	}
	/**
	 * 
	 * @return
	 */
	public List<Transaction> getTransactions(){
		return this.transactions;
	}
	
	/**
	 * Withdraws money from the account.
	 * @param amount - the amount of money to withdraw
	 * @return true if the withdrawal was successful, false otherwise
	 */
	protected boolean withdraw(double amount) {
		if(amount < 0) {
			return false;
		}
		this.balance -= amount;
		this.transactions.add(new Transaction(amount, balance));
		return true;
	}
	
	/**
	 * Generates a string representation of the account.
	 * @return a string representing the account
	 */
	public String toString() {
		String s = "Account: " +
				"nr=" + this.nr + ", " +
				"balance=" + String.format("%.2f\n", this.balance);
		return s;
	}
	
}
