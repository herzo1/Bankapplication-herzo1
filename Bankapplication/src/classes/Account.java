package classes;

public class Account {
	private double balance;
	private int nr;
	private String pin;
	
	Account(int nr, String pin){
		this(nr, pin, 0);
	}
	
	Account(int nr, String pin, double balance){
		this.nr = nr;
		this.pin = pin;
		this.balance = balance;
	}
}
