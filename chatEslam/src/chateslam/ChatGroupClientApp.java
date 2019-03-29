import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.*;
import java.net.*;
import java.util.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class ChatGroupClientApp extends Application 
{
    Button sendButton;
    TextArea chatArea;
    TextField chatMessage;
    Socket socket;
    @Override
    public void start(Stage primaryStage) 
    {
        try
        {
            socket = new Socket("localhost", 8189);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        Thread readingThread = new Thread(()->{
                                                   //Socket socket = null;
                                                   InputStream inStream = null;
                                                   BufferedReader dataInStream = null;
                                                   try
                                                   {
                                                        //socket = new Socket("localhost", 8189);
                                                        while(true)
                                                        {    
                                                            inStream = socket.getInputStream();
                                                            dataInStream = new BufferedReader(new InputStreamReader(inStream));
                                                            if(dataInStream.ready())
                                                            {    
                                                                String chatString = dataInStream.readLine();
                                                                chatArea.appendText(chatString + "\n");
                                                            }
                                                        }
                                                            
                                                    }
                                                    catch(IOException e)
                                                    {
                                                        e.printStackTrace();
                                                    }
                                                    /*finally
                                                    {
                                                        try
                                                        {    
                                                            if(dataInStream != null && inStream != null && socket != null)
                                                            {    
                                                                dataInStream.close();
                                                                inStream.close();
                                                                socket.close();
                                                            }
                                                        }
                                                        catch(IOException e)
                                                        {
                                                            e.printStackTrace();
                                                        }
                                                    }*/
                                              });
        sendButton = new Button();
        sendButton.setText("Send");
        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) 
            {
                String currentMessage = chatMessage.getText();
                try
                {
                    OutputStream outStream = socket.getOutputStream();
                    BufferedWriter outWriter = new BufferedWriter(new OutputStreamWriter(outStream));
                    outWriter.write(currentMessage, 0, currentMessage.length());
                    outWriter.newLine();
                    outWriter.flush();
                    chatMessage.setText("");
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
        });
        
        chatArea = new TextArea(); 
        chatMessage = new TextField();
        BorderPane root = new BorderPane(chatArea, null, sendButton, chatMessage, null);
        //root.getChildren().add();
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("ChattingApplication");
        primaryStage.setScene(scene);
        primaryStage.show();
        readingThread.start();
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
    
}