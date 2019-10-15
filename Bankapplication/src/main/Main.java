package main;

import classes.Account;
import classes.Bank;
import classes.Customer;

public class Main {
	public static void main(String[] args) {
		Bank baloise = new Bank("baloise");
		
		Customer customerOli = baloise.registerCustomer("Oli", "123");
		
		System.out.println(customerOli);
		
		Account accOli1 = baloise.openAccount(customerOli, "1234");
		Account accOli2 = baloise.openAccount(customerOli, "1234");
		
		System.out.println(customerOli);
		
		baloise.deposit(accOli1.getNr(), 10000);
		baloise.deposit(accOli2.getNr(), 50000);
		
		System.out.println(customerOli);
		
		baloise.transfer(accOli2.getNr(),"1234", accOli1.getNr(), 10000);
		
		System.out.println(customerOli);
		
	}
}
