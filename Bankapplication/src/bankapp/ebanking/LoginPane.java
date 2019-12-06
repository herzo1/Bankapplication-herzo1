package bankapp.ebanking;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LoginPane extends BorderPane {
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
        private LHCustomLogin(String label1, String label2, String buttonLabel){
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
        private LHLabelWithTF(String label){
            super(SPACING);
            TextField tf = new TextField();
            Label l = new Label(label);
            l.setPrefWidth(LABEL_WIDTH);
            this.setAlignment(Pos.CENTER);
            this.getChildren().addAll(l, tf);
        }

    }

    private class LHButtonAlignment extends HBox{
        private LHButtonAlignment(String buttonLabel){
            super(SPACING);
            Button button = new Button(buttonLabel);
            button.setPrefWidth(BUTTON_WIDTH);
            Label placeHolder = new Label();
            placeHolder.setPrefWidth(LABEL_WIDTH);
            this.setAlignment(Pos.CENTER);
            this.getChildren().setAll(placeHolder, button);
        }
    }
}
