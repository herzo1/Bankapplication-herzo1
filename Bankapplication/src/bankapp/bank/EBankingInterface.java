package bankapp.bank;

public interface EBankingInterface {
	
	public Customer authenticateCustomer(int customerNr, String password);
	
	public String getName();
	
	public Account openPersonalAccount(Customer customer, String pin);
	
	public Account openSavingsAccount(Customer customer, String pin, double limit);
	
	public Customer registerCustomer(String name, String password);
	
	public boolean transfer(int debitAccountNr, String pin, int creditAccountNr, double amount);
}
