package bankapp.bank;

import java.time.LocalDate;

public class Transaction {
	private final double amount;
	private final double balance;
	private final LocalDate valuta;

	public Transaction(double amount, double balance) {
		this.amount = amount;
		this.balance = balance;
		this.valuta = LocalDate.now();
	}
	
	public double getAmount() {
		return this.amount;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public LocalDate getValuta() {
		return this.valuta;
	}
	
	public String toString() {
		return "Valuta: " + this.valuta + " Amount: " + this.amount + " Balance: " + this.balance;
	}
}
