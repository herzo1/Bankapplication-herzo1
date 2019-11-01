package bankapp.bank;

public class PersonalAccount extends Account {

	public PersonalAccount(int nr, String pin) {
		this(nr, pin, 0);
	}

	public PersonalAccount(int nr, String pin, double balance) {
		super(nr, pin, balance);
	}
	
	/**
	 * Generates a string representation of the account.
	 * @return a string representing the account
	 */
	public String toString() {
		String s = "Personal Account: " +
				"nr=" + this.nr + ", " +
				"balance=" + String.format("%.2f\n", this.balance);
		return s;
	}

}
