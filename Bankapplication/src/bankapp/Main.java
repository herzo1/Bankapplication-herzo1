package bankapp;

import bankapp.atm.ATM;
import bankapp.bank.Bank;
import bankapp.cli.BankCLI;

public class Main {
	
	private static final String BANK_NAME = "UBS";
	
	public static void main(String[] args) {

		Bank ubs = new Bank(BANK_NAME);

		new ATM(ubs);

		BankCLI ubsCli = new BankCLI(ubs);
		ubsCli.run();
		

		
	}
}
