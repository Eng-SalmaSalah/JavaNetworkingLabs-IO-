/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsidechatapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author salma
 */
public class ClientSideChatApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        ClientSideAppDesignBase root = new ClientSideAppDesignBase(primaryStage);
        Scene scene = new Scene(root, 600, 450);
        primaryStage.setTitle("Chatting Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
