package bankapp.bank;

public interface ATMInterface {
	
	public String getName();
	
	public Double getBalance(int accountNr, String pin);
	
	public boolean deposit(int accountNr, double amount);
	
	public boolean withdraw(int accountNr, String pin, double amount);

}
