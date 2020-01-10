package bankapp.bank;

public interface EBankingInterface {
	
	public Customer authenticateCustomer(int customerNr, String password) throws BankException;
	
	public String getName();
	
	public Account openPersonalAccount(Customer customer, String pin);
	
	public Account openSavingsAccount(Customer customer, String pin, double limit);
	
	public Customer registerCustomer(String name, String password);
	
	public void transfer(int debitAccountNr, String pin, int creditAccountNr, double amount) throws BankException;
}
