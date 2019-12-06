package bankapp.ebanking;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LoginPane extends BorderPane {
    private final static int SPACING = 10;
    private final static int LABEL_WIDTH = 80;
    private final static String LABEL_CUSTOMER_NR = "Customer Nr.";
    private final static String LABEL_PASSWORD = "Password";
    private final static String LABEL_CUSTOMER_NAME = "Customer Name";
    private final static String BUTTON_LOGIN = "Login";
    private final static String BUTTON_REGISTER = "Register";
    private final static String BANK_NAME = "EASYbank";

    public LoginPane(){
        VBox vBox = new VBox(SPACING);
        this.setCenter(vBox);

        Label bankName = new Label(BANK_NAME);
        bankName.setFont(Font.font("Default", FontWeight.BOLD, 16));

        VBox loginForm = new LHCustomLogin(LABEL_CUSTOMER_NR, LABEL_PASSWORD, BUTTON_LOGIN);
        VBox registerForm = new LHCustomLogin(LABEL_CUSTOMER_NAME, LABEL_PASSWORD, BUTTON_REGISTER);

        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().setAll(bankName, loginForm, registerForm);

    }

    private class LHCustomLogin extends VBox{
        private LHCustomLogin(String label1, String label2, String buttonLabel){
            super(SPACING);
            HBox firstLine = new LHLabelWithTF(label1);
            HBox secondLine = new LHLabelWithTF(label2);
            Button button = new Button(buttonLabel);
            this.getChildren().setAll(firstLine, secondLine, button);

        }
    }

    private class LHLabelWithTF extends HBox{
        private LHLabelWithTF(String label){
            super(SPACING);
            TextField tf = new TextField();
            Label l = new Label(label);
            l.setPrefWidth(LABEL_WIDTH);
            this.getChildren().addAll(l, tf);
        }

    }
}
