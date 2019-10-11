package main;

import classes.Account;
import classes.Customer;

public class Main {
	public static void main(String[] args) {
		Customer bob = new Customer(1 , "Bob", "alice85");
		Account acc1 = new Account(1, "1234", 1000);
		Account acc2 = new Account(2, "1234", 10000);
		Account acc3 = new Account(3, "1234", 100000);
		
		bob.addAccount(acc1);
		bob.addAccount(acc2);
		bob.addAccount(acc3);
		
		Account[] arrs = bob.getAccounts();
		arrs[0] = null;
		
		System.out.println(bob);
	}
}
