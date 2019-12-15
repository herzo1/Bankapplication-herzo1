package bankapp.ebanking;

import bankapp.bank.EBankingInterface;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LoginPane extends BorderPane {
    private final static int SPACING = 10;
    private final static int LABEL_WIDTH = 80;

    private Controller controller;
    private EBankingInterface bank;

    private Button loginButton, registerButton;
    private TextField nameField, numberField;
    private PasswordField pwField1, pwField2;
    private Label statusLabel;

    public LoginPane(Controller controller, EBankingInterface bank){
        this.controller = controller;
        this.bank = bank;

    }

    private VBox createLoginForm(){
        VBox vBoxLoginForm = new VBox(SPACING);
        HBox hBoxCustNr = new HBox(SPACING);
        Label labelCustNr = new Label("Customer Nr.");
        labelCustNr.setPrefWidth(LABEL_WIDTH);
        numberField = new TextField();
        hBoxCustNr.getChildren().setAll(labelCustNr, numberField);

        HBox hBoxPw = new HBox(SPACING);
        Label labelPw = new Label("Password");
        labelPw.setPrefWidth(LABEL_WIDTH);
        pwField1 = new PasswordField();
        hBoxPw.getChildren().setAll(labelPw, pwField1);

        HBox hBoxLoginBtn = new HBox(SPACING);
        Label labelPlaceholder = new Label("");
        labelPlaceholder.setPrefWidth(LABEL_WIDTH);
        loginButton = new Button("Login");
        loginButton.addEventHandler(ActionEvent.ACTION, event -> this.login());

        vBoxLoginForm.getChildren().setAll(hBoxCustNr, hBoxPw, hBoxLoginBtn);
        vBoxLoginForm.setAlignment(Pos.CENTER);
        return vBoxLoginForm;
    }

    private VBox createRegisterForm(){
        VBox vBoxRegisterForm = new VBox(SPACING);
        HBox hBoxCustName = new HBox(SPACING);
        Label labelCustName = new Label("Customer Name");
        labelCustName.setPrefWidth(LABEL_WIDTH);
        nameField = new TextField();
        hBoxCustName.getChildren().setAll(labelCustName, numberField);

        HBox hBoxPw = new HBox(SPACING);
        Label labelPw = new Label("Password");
        labelPw.setPrefWidth(LABEL_WIDTH);
        pwField2 = new PasswordField();
        hBoxPw.getChildren().setAll(labelPw, pwField2);

        HBox hBoxRegisterBtn = new HBox(SPACING);
        Label labelPlaceholder = new Label("");
        labelPlaceholder.setPrefWidth(LABEL_WIDTH);
        registerButton = new Button("Login");
        registerButton.addEventHandler(ActionEvent.ACTION, event -> this.register());

        vBoxRegisterForm.getChildren().setAll(hBoxCustName, hBoxPw, hBoxRegisterBtn);
        vBoxRegisterForm.setAlignment(Pos.CENTER);
        return vBoxRegisterForm;
    }

    private void login(){
        controller.setCustomer(bank.authenticateCustomer(Integer.parseInt(numberField.getText()), pwField1.getText()));
        controller.showCustomerPane();
    }

    private void register(){
        controller.setCustomer(bank.registerCustomer(nameField.getText(), pwField2.getText()));
        controller.showCustomerPane();
    }
    /*
    private final static int SPACING = 10;
    private final static int MAIN_SPACING = 30;
    private final static int LABEL_WIDTH = 120;
    private final static int BUTTON_WIDTH = 80;

    private final static String LABEL_CUSTOMER_NR = "Customer Nr.";
    private final static String LABEL_PASSWORD = "Password";
    private final static String LABEL_CUSTOMER_NAME = "Customer Name";
    private final static String BUTTON_LOGIN = "Login";
    private final static String BUTTON_REGISTER = "Register";
    private final static String BANK_NAME = "EASYbank";

    public LoginPane(){
        VBox vBox = new VBox(MAIN_SPACING);
        this.setCenter(vBox);

        Label bankName = new Label(BANK_NAME);
        bankName.setFont(Font.font("Default", FontWeight.BOLD, 16));
        VBox loginForm = new LHCustomLogin(LABEL_CUSTOMER_NR, LABEL_PASSWORD, BUTTON_LOGIN);
        VBox registerForm = new LHCustomLogin(LABEL_CUSTOMER_NAME, LABEL_PASSWORD, BUTTON_REGISTER);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().setAll(bankName, loginForm, registerForm);

    }

    private class LHCustomLogin extends VBox{
        public LHCustomLogin(String label1, String label2, String buttonLabel){
            super(SPACING);
            HBox firstLine = new LHLabelWithTF(label1);
            HBox secondLine = new LHLabelWithTF(label2);
            HBox button = new LHButtonAlignment(buttonLabel);
            this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            this.setPadding(new Insets(SPACING, SPACING, SPACING, SPACING));
            this.setAlignment(Pos.CENTER);
            this.getChildren().setAll(firstLine, secondLine, button);

        }
    }

    private class LHLabelWithTF extends HBox{
        public LHLabelWithTF(String label){
            super(SPACING);
            TextField tf = new TextField();
            Label l = new Label(label);
            l.setPrefWidth(LABEL_WIDTH);
            this.setAlignment(Pos.CENTER);
            this.getChildren().addAll(l, tf);
        }

    }

    private class LHButtonAlignment extends HBox{
        public LHButtonAlignment(String buttonLabel){
            super(SPACING);
            Button button = new Button(buttonLabel);
            button.setPrefWidth(BUTTON_WIDTH);
            Label placeHolder = new Label();
            placeHolder.setPrefWidth(LABEL_WIDTH);
            this.setAlignment(Pos.CENTER);
            this.getChildren().setAll(placeHolder, button);
        }
    }

     */
}
