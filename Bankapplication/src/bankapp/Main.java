package bankapp;

import java.util.ArrayList;
import java.util.List;

import bankapp.atm.ATM;
import bankapp.bank.Account;
import bankapp.bank.Bank;
import bankapp.bank.Customer;
import bankapp.cli.BankCLI;

public class Main {
	
	private static final String BANK_NAME = "UBS";
	private static final String PIN = "123";
	private static List<Account> accList = new ArrayList<>();
	
	
	public static void main(String[] args) {
		Bank ubs = new Bank(BANK_NAME);

		Customer cust1 = ubs.registerCustomer("Oliver", PIN);
		for(int i=0; i<5; i++) {
			accList.add(ubs.openPersonalAccount(cust1, PIN));
		}
		ubs.deposit(accList.get(1).getNr(), 1000);
		System.out.println(cust1);
		ATM atm = new ATM(ubs);
		BankCLI ubsCli = new BankCLI(ubs);
		ubsCli.run();
		atm.close();
	}
}
