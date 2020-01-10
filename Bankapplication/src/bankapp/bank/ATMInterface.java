package bankapp.bank;

public interface ATMInterface {
	
	public String getName();
	
	public Double getBalance(int accountNr, String pin) throws BankException;
	
	public void deposit(int accountNr, double amount) throws BankException;
	
	public void withdraw(int accountNr, String pin, double amount) throws BankException;

}
