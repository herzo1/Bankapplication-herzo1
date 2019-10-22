package bankapp;

import bankapp.bank.Bank;
import bankapp.cli.BankCLI;

public class Main {
	public static void main(String[] args) {
		/*
		Bank baloise = new Bank("baloise");
		
		Customer bob = baloise.registerCustomer("bob", "alice86");
		Account bobsAcc = baloise.openAccount(bob, "8686");
		
		int bobsAccountNr = bobsAcc.getNr();
		
		baloise.deposit(bobsAccountNr, 1500);
		
		System.out.println(bob);
		
		Account bobsAcc2 = baloise.openAccount(bob, "1234");
		int bobsAccountNr2 = bobsAcc2.getNr();
		baloise.transfer(bobsAccountNr, "8686", bobsAccountNr2, 500);
		
		System.out.println(bob);
		
		Customer eve = baloise.registerCustomer("Eve", "password");
		Account eveAcc = baloise.openAccount(eve, "0000");
		eveAcc.deposit(1000000);
		
		System.out.println(eve);
		*/
		Bank ubs = new Bank("UBS");
		BankCLI ubsCli = new BankCLI(ubs);
	}
}
