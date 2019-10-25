package bankapp;

import bankapp.bank.Bank;
import bankapp.cli.BankCLI;

public class Main {
	public static void main(String[] args) {

		Bank ubs = new Bank("UBS");
		BankCLI ubsCli = new BankCLI(ubs);
		ubsCli.run();
		
	}
}
