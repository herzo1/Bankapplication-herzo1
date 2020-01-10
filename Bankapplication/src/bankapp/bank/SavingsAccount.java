package bankapp.bank;

public class SavingsAccount extends Account {
	private static final double DEFAULT_LIMIT = 2000;
	private static final double MIN_LIMIT = 100;

	private double limit;
	
	public SavingsAccount(int nr, String pin) {
		this(nr, pin, DEFAULT_LIMIT);
	}

	public SavingsAccount(int nr, String pin, double limit) {
		super(nr, pin);
		if(limit < MIN_LIMIT) {
			this.limit = DEFAULT_LIMIT;
		} else {
			this.limit = limit;
		}
	}
	
	/**
	 * Withdraws money from the account.
	 * @param amount - the amount of money to withdraw
	 * @return true if the withdrawal was successful, false otherwise
	 */
	protected void withdraw(double amount) throws BankException {
	    if(amount > super.balance){
	    	throw new BankException("Insufficient funds");
		}
	    if(amount > this.limit){
	    	throw new BankException("Withdrawal limit exceeded");
		}
		super.withdraw(amount);
	}
	
	/**
	 * Gets the actual limit of the savings account
	 * @return limit
	 */
	public double getLimit() {
		return this.limit;
	}
	
	/**
	 * Set the limit of the savings account
	 * @param limit - amount to set as limit
	 * @return true if limit was successfully set, false otherwise
	 */
	public boolean setLimit(double limit) {
		if(limit < MIN_LIMIT) {
			return false;
		}
		this.limit = limit;
		return true;
		
	}
	
	/**
	 * Generates a string representation of the account.
	 * @return a string representing the account
	 */
	public String toString() {
		return "Savings " + super.toString();
	}

}
