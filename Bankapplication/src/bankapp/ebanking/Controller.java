package bankapp.ebanking;

import bankapp.bank.Customer;
import bankapp.bank.EBankingInterface;
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

    public void showCustomerPane(){
        // TODO: implement logic
    }

    public void showLoginPane(){
        // TODO: implement logic
    }

    private void showPane(Pane pane){
        // TODO: implement logic
    }
}
