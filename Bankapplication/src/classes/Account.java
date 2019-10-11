package classes;

/**
 * Class Account
 * @author oherz
 *
 */
public class Account {
	private double balance;
	private final int nr;
	private String pin;
	
	public Account(int nr, String pin){
		this(nr, pin, 0);
	}
	
	public Account(int nr, String pin, double balance){
		this.nr = nr;
		this.pin = (pin == null)? "" : pin;
		this.balance = balance;
	}
	
	public boolean checkPin(String pin) {
		return this.pin.equals(pin);
	}
	
	/**
	 * Deposit money to the account
	 * @param amount
	 * @return
	 */
	public boolean deposit(double amount) {
		if(amount < 0) {
			return false;
		}
		this.balance += amount;
		return true;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public int getNr() {
		return this.nr;
	}
	
	public boolean withdraw(double amount) {
		if(amount<0) {
			return false;
		}
		this.balance -= amount;
		return true;
	}
	
	public String toString() {
		String s = "Account: " +
				"nr=" + this.nr + ", " +
				"balance=" + String.format("%.2f\n", this.balance);
		return s;
	}
	
}
