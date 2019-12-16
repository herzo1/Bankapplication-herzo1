package bankapp.ebanking;

import bankapp.bank.Customer;
import bankapp.bank.EBankingInterface;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller {
    private EBankingInterface bank;
    private Customer customer;
    private Stage stage;

    public Controller(Stage stage, EBankingInterface bank){
        this.bank = bank;
        this.stage = stage;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public void showLoginPane(){
        showPane(new LoginPane(this, bank));
    }

    public void showCustomerPane(){
        showPane(new CustomerPane(this, bank, customer));
    }

    private void showPane(Pane pane){
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
}
