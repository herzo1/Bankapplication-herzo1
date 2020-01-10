package bankapp.cli;

import java.util.List;

import bankapp.bank.Bank;
import bankapp.bank.BankException;
import bankapp.bank.Customer;
import bankapp.bank.Transaction;

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

	private Command[] commands;
	
	/**
	 * Cunstructs a command-line interface.
	 * @param bank - the interfaced bank
	 */
	public BankCLI(Bank bank) {
		this.bank = bank;
		this.commands = new Command[] {
				new CustomerRegistration(), 
				new CustomerLogin(),
				new OpenAccount(),
				new TransactionRecord(),
				new Deposit(),
				new Withdraw(),
				new Transfer()};
	}
	/**
	 * Runs the command-line interface.
	 */
	public void run() {
		while (true) {
			int choice = ConsoleHelper.displayMenu(this.bank.getName(), "Register", "Login", "Exit");
			if(choice == 3) {
				return;
			}
			this.commands[choice-1].execute();
			if (this.customer != null) this.runSession();
		}
	}

	/**
	 * Runs a session for the logged in customer.
	 */
	private void runSession() {
		while (true) {
			ConsoleHelper.writeData(customer);
			int choice = ConsoleHelper.displayMenu(bank.getName(),
					"Open Account", "Transaction Record", "Deposit", "Withdraw", "Transfer", "Logout");
			if(choice == 5) {
				return;
			}
			commands[choice+1].execute();
		}
	}

	private class CustomerRegistration extends Command{

		@Override
		public void execute() {
			String customerName = ConsoleHelper.readString("Name > ");
			String customerPassword = ConsoleHelper.readString("Password > ");
			customer = bank.registerCustomer(customerName, customerPassword);
			ConsoleHelper.writeMessage("Customer registered!");
		}
		
	}
	
	private class CustomerLogin extends Command{

		@Override
		public void execute() {
			int customerNr = ConsoleHelper.readInteger("Customer Nr.: > ");
			String customerPassword = ConsoleHelper.readString("Password > ");
			customer = bank.authenticateCustomer(customerNr, customerPassword);
			ConsoleHelper.writeMessage(customer != null? "Customer logged in" : "Login failed");
		}
		
	}
	
	private class OpenAccount extends Command{
		Command[] openAccCommands;
		
		public OpenAccount() {
			openAccCommands = new Command[] {
					new openPersonalAccount(),
					new openSavingsAccount()
			};
		}
		
		@Override
		public void execute() {
			while (true) {
				int choice = ConsoleHelper.displayMenu("Choose Account type", "Personal Account", "Savings Account", "Exit");
				if(choice == 3) {
					return;
				}
				openAccCommands[choice-1].execute();
			}
		}
	}
	
	private class openPersonalAccount extends Command{

		@Override
		public void execute() {
			String accPin = ConsoleHelper.readString("Pin > ");
			bank.openPersonalAccount(customer, accPin);
			ConsoleHelper.writeMessage("Successfully opened personal account!");
		}
	}

	private class openSavingsAccount extends Command{

		@Override
		public void execute() {
			double limit = ConsoleHelper.readDecimal("Withdraw Limit > ");
			String accPin = ConsoleHelper.readString("Pin > ");
			bank.openSavingsAccount(customer, accPin, limit);
			ConsoleHelper.writeMessage("Successfully opened savings account!");
		}
	}

	private class Deposit extends Command{

		@Override
		public void execute() {
			int accountNr = ConsoleHelper.readInteger("Account Nr.: > ");
			double amount = ConsoleHelper.readDecimal("Amount > ");
			try {
				bank.deposit(accountNr, amount);
				ConsoleHelper.writeMessage("Amount deposited");
			}
			catch (BankException e){
				ConsoleHelper.writeMessage("Error: " + e.getMessage());
			}

		}
	}
	
	private class Withdraw extends Command{

		@Override
		public void execute() {
			int accountNr = ConsoleHelper.readInteger("Account Nr.: > ");
			String pin = ConsoleHelper.readString("Pin > ");
			double amount = ConsoleHelper.readDecimal("Amount > ");
			try{
				bank.withdraw(accountNr, pin, amount);
				ConsoleHelper.writeMessage("Amount withdrawal");
			}
			catch (BankException e){
				ConsoleHelper.writeMessage("Error: " + e.getMessage());
			}
		}
	}
	
	private class Transfer extends Command{

		@Override
		public void execute() {
			int debitAccountNr = ConsoleHelper.readInteger("Debit account Nr.: > ");
			String pin = ConsoleHelper.readString("Pin > ");
			int creditAccountNr = ConsoleHelper.readInteger("Credit account Nr.: > ");
			double amount = ConsoleHelper.readDecimal("Amount > ");
			try {
				bank.transfer(debitAccountNr, pin, creditAccountNr, amount);
				ConsoleHelper.writeMessage("Amount transferred");
			}
			catch (BankException e){
				ConsoleHelper.writeMessage("Error: " + e.getMessage());
			}

		}
		
	}
	
	private class TransactionRecord extends Command{
		@Override
		public void execute() {
			try{
				int accountNr = ConsoleHelper.readInteger("Account Nr.: > ");
				List<Transaction> transactionRecord = bank.findAccount(accountNr).getTransactions();
				if(transactionRecord.size() == 0) {
					ConsoleHelper.writeMessage("Error occurred");
				} else {
					ConsoleHelper.writeMessage("Transaction Record:");
					ConsoleHelper.writeMessage("-------------------");
					for(Transaction record : transactionRecord) {
						ConsoleHelper.writeData(record);
					}
					ConsoleHelper.writeMessage("-------------------");
				}
			}
			catch (BankException e){
				ConsoleHelper.writeMessage("Error: " + e.getMessage());
			}

		}
	}

}