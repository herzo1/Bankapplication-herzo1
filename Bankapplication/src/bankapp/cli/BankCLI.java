package bankapp.cli;

import bankapp.bank.Bank;
import bankapp.bank.Customer;

/**
 * The class BankCLI implements the command-line interface of a bank.
 */
public class BankCLI {

	/**
	 * The bank of the command-line interface.
	 */
	private Bank bank;

	/**
	 * The logged in customer.
	 */
	private Customer customer;
	
	/**
	 * Cunstructs a command-line interface.
	 * @param bank - the interfaced bank
	 */
	public BankCLI(Bank bank) {
		this.bank = bank;
		this.run();
	}
	/**
	 * Runs the command-line interface.
	 */
	public void run() {
		while (true) {
			int choice = ConsoleHelper.displayMenu(bank.getName(), "Register", "Login", "Exit");
			switch (choice) {
				case 1:
					registerCustomer();
					break;
				case 2:
					logonCustomer();
					break;
				default:
					return;
			}
			if (customer != null) runSession();
		}
	}

	/**
	 * Registers a bank customer.
	 */
	private void registerCustomer() {
		//TODO Implement method
		String customerName = ConsoleHelper.readString("Name > ");
		String customerPassword = ConsoleHelper.readString("Password > ");
		
		customer = bank.registerCustomer(customerName, customerPassword);
	}

	/**
	 * Logs on a bank customer.
	 */
	private void logonCustomer() {
		int customerNr = ConsoleHelper.readInteger("Customer Nr.: > ");
		String customerPassword = ConsoleHelper.readString("Password > ");
		
		customer = bank.authCustomer(customerNr, customerPassword);
	}

	/**
	 * Runs a session for the logged in customer.
	 */
	private void runSession() {
		while (true) {
			ConsoleHelper.writeData(customer);
			int choice = ConsoleHelper.displayMenu(bank.getName(),
					"Open Account", "Deposit", "Withdraw", "Transfer", "Logout");
			switch (choice) {
				case 1:
					openAccount();
					break;
				case 2:
					deposit();
					break;
				case 3:
					withdraw();
					break;
				case 4:
					transfer();
					break;
				default:
					return;
			}
		}
	}

	/**
	 * Opens a bank account.
	 */
	private void openAccount() {
		String accPin = ConsoleHelper.readString("Pin > ");
		bank.openAccount(customer, accPin);
	}

	/**
	 * Deposits money to a bank account.
	 */
	private void deposit() {
		int accountNr = ConsoleHelper.readInteger("Account Nr.: > ");
		double amount = ConsoleHelper.readDecimal("Amount > ");
		bank.deposit(accountNr, amount);
	}

	/**
	 * Withdraws money from a bank account.
	 */
	private void withdraw() {
		int accountNr = ConsoleHelper.readInteger("Account Nr.: > ");
		String pin = ConsoleHelper.readString("Pin > ");
		double amount = ConsoleHelper.readDecimal("Amount > ");
		bank.withdraw(accountNr, pin, amount);
	}

	/**
	 * Transfers money from a bank account to an other account.
	 */
	private void transfer() {
		int debitAccountNr = ConsoleHelper.readInteger("Debit account Nr.: > ");
		String pin = ConsoleHelper.readString("Pin > ");
		int creditAccountNr = ConsoleHelper.readInteger("Credit account Nr.: > ");
		double amount = ConsoleHelper.readDecimal("Amount > ");
		bank.transfer(debitAccountNr, pin, creditAccountNr, amount);
	}
}
