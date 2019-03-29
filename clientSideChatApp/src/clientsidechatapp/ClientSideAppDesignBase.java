package clientsidechatapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ClientSideAppDesignBase extends AnchorPane {

    protected final TextArea textArea;
    protected final TextField textField;
    protected final Button button;
    Socket socket;
    OutputStream outputStream;
    DataOutputStream dataOutStream;
    InputStream inputStream;
    DataInputStream dataInStream;
    String outputMessage;
    String inputMessage;
    Thread reading;

    public ClientSideAppDesignBase(Stage stage) {

        textArea = new TextArea();
        textField = new TextField();
        button = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        textArea.setLayoutX(51.0);
        textArea.setLayoutY(31.0);
        textArea.setPrefHeight(273.0);
        textArea.setPrefWidth(503.0);

        textField.setLayoutX(51.0);
        textField.setLayoutY(327.0);
        textField.setPrefHeight(31.0);
        textField.setPrefWidth(335.0);

        button.setLayoutX(427.0);
        button.setLayoutY(327.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(31.0);
        button.setPrefWidth(116.0);
        button.setText("Send");

        getChildren().add(textArea);
        getChildren().add(textField);
        getChildren().add(button);

        try {
            socket = new Socket("localhost", 8000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        reading = new Thread(() -> {
            while (true) {
                try {
                    inputStream = socket.getInputStream();
                    dataInStream = new DataInputStream(inputStream);
                    inputMessage = dataInStream.readUTF();
                    textArea.appendText(inputMessage);
                    textArea.appendText("\n");

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }

        });
        reading.start();

        button.setOnAction((ActionEvent e) -> {
            try {
                outputStream = socket.getOutputStream();
                dataOutStream = new DataOutputStream(outputStream);
                outputMessage = textField.getText();
                textField.clear();
                dataOutStream.writeUTF(outputMessage);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
//closing
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                try {
                    
                    socket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
