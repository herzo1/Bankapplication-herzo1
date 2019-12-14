package bankapp.ebanking;

import bankapp.bank.Customer;
import bankapp.bank.EBankingInterface;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CustomerPane extends BorderPane {
    private Controller controller;
    private EBankingInterface bank;
    private Customer customer;

    private VBox accountTable;
    private ComboBox<String> accountTypeBox;
    private Button logoutButton, openButton, refreshButton;
    private PasswordField pinField;
    private Label statusLabel;
    private TextField withdrawalLimitField;

    public CustomerPane(Controller controller, EBankingInterface bank, Customer customer){
        this.controller = controller;
        this.bank = bank;
        this.customer = customer;
    }

    private VBox createAccountOpeningForm(){
        // TODO: implement logc
        return null;
    }

    private void logout(){
        // TODO: implement logic
    }

    private void openAccount(){
        // TODO: implement logic
    }

    private void refreshAccounts(){
        // TODO: implement logic
    }
}
