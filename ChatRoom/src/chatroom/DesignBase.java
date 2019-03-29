package chatroom;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public abstract class DesignBase extends AnchorPane {

    protected final TextArea textArea;
    protected final TextField textField;
    protected final Button button;

    public DesignBase() {

        textArea = new TextArea();
        textField = new TextField();
        button = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        textArea.setLayoutX(28.0);
        textArea.setLayoutY(21.0);
        textArea.setPrefHeight(294.0);
        textArea.setPrefWidth(548.0);

        textField.setLayoutX(28.0);
        textField.setLayoutY(339.0);
        textField.setPrefHeight(31.0);
        textField.setPrefWidth(346.0);

        button.setLayoutX(427.0);
        button.setLayoutY(339.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(31.0);
        button.setPrefWidth(143.0);
        button.setText("Send");

        getChildren().add(textArea);
        getChildren().add(textField);
        getChildren().add(button);

    }
}
