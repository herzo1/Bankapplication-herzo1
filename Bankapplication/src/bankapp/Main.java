package bankapp;

import bankapp.atm.ATM;
import bankapp.bank.Account;
import bankapp.bank.Bank;
import bankapp.bank.Customer;
import bankapp.cli.BankCLI;
import bankapp.ebanking.Controller;
import bankapp.ebanking.LoginPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
	private static final String LOGIN_STAGE_TITLE = "E-Banking";
	
	private static final String BANK_NAME = "EASYBank";
	private static final String PIN = "123";
	private static List<Account> accList = new ArrayList<>();

	private Bank easyBank;
	private ATM atm;

	@Override
	public void init() throws Exception{
		easyBank = new Bank(BANK_NAME);

		/*
		Customer cust1 = easyBank.registerCustomer("Oliver", PIN);
		for(int i=0; i<5; i++) {
			accList.add(easyBank.openPersonalAccount(cust1, PIN));
		}

		easyBank.deposit(accList.get(1).getNr(), 1000);
		System.out.println(cust1);
		 */
		atm = new ATM(easyBank);
		// BankCLI bankCli = new BankCLI(easyBank);
		// bankCli.run();
	}

	@Override
	public void start(Stage stage) throws Exception{
		Controller controller = new Controller(stage, easyBank);
		controller.showLoginPane();
	    /*
		BorderPane root = new LoginPane();

		stage.setScene(new Scene(root, 400, 400));
		stage.setTitle(LOGIN_STAGE_TITLE);
		stage.show();
	     */
	}

	@Override
	public void stop() throws Exception{
	    atm.close();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
