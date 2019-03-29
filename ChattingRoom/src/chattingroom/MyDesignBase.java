package chattingroom;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MyDesignBase extends AnchorPane {
//buffered reader w datainput stream w random access dol high level yst2blo l stream nfso gwa

    protected TextField textField;
    protected TextArea textArea;
    protected Button button;
    OutputStream outStream = null;
    PrintWriter printWriter;
    Socket socket;
    String inputMessage;
    String outputMessage;
    Thread thread;

    public MyDesignBase(Stage primaryStage) {

        textField = new TextField();
        textArea = new TextArea();
        button = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        textField.setLayoutX(72.0);
        textField.setLayoutY(338.0);
        textField.setPrefHeight(31.0);
        textField.setPrefWidth(259.0);

        textArea.setLayoutX(72.0);
        textArea.setLayoutY(38.0);
        textArea.setPrefHeight(278.0);
        textArea.setPrefWidth(453.0);

        button.setLayoutX(381.0);
        button.setLayoutY(338.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(31.0);
        button.setPrefWidth(144.0);
        button.setText("Send");

        getChildren().add(textField);
        getChildren().add(textArea);
        getChildren().add(button);

        try {
            socket = new Socket("localhost", 8000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        button.setOnAction((ActionEvent e) -> {

            try {

                outStream = socket.getOutputStream();
                printWriter = new PrintWriter(outStream);
                outputMessage = textField.getText();
                textField.clear();
                printWriter.write(outputMessage);

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        Runnable runnable = () -> {
            Scanner scanner = null;
            try (InputStream inStream = socket.getInputStream()) {

                scanner = new Scanner(inStream, "UTF-8");
                while (true) {

                    if (scanner.hasNext()) {
                        inputMessage = scanner.nextLine();
                        System.out.println(inputMessage);
                        textArea.appendText(inputMessage);
                        textArea.appendText("\n");
                    }

                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        };
        thread = new Thread(runnable);

        thread.start();

    }
}
