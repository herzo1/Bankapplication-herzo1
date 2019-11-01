package bankapp.bank;

public class SavingsAccount extends Account {
	private static final double DEFAULT_LIMIT = 2000;
	private double limit;
	
	public SavingsAccount(int nr, String pin) {
		this(nr, pin, DEFAULT_LIMIT);
	}

	public SavingsAccount(int nr, String pin, double limit) {
		super(nr, pin);
		this.limit = limit;
	}
	
	/**
	 * Withdraws money from the account.
	 * @param amount - the amount of money to withdraw
	 * @return true if the withdrawal was successful, false otherwise
	 */
	protected boolean withdraw(double amount) {
		double tempBalance = super.balance - amount;
		if(amount < 0 || tempBalance < 0 || amount > limit) {
			return false;
		}
		super.balance = tempBalance;
		return true;
	}

}
