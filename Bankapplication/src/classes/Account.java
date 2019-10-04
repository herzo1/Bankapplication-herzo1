package classes;

public class Account {
	private double balance;
	private static double ZERO_BALANCE = 0;
	private int nr;
	private String pin;
	
	Account(int nr, String pin){
		this(nr, pin, ZERO_BALANCE);
	}
	
	Account(int nr, String pin, double balance){
		this.nr = nr;
		this.pin = pin;
		this.balance = balance;
	}
	
	public boolean checkPin(String pin) {
		return this.pin.equals(pin);
	}
	
	public boolean deposit(double amount) {
		// TODO: implement this method
		return false;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public int getNr() {
		return this.nr;
	}
	
	public boolean withdraw(double amount) {
		// TODO: implement this method
		return false;
	}
	
	public String toString() {
		// TODO: implement this method
		return "";
	}
	
}
