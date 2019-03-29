/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversidechatapp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author salma
 */
public class ServerSideChatApp {

    public static void main(String[] args) {

        Socket clientSocket;
        Thread thread;
        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            while (true) {
                clientSocket = serverSocket.accept();
                ServerHandler client = new ServerHandler(clientSocket);
                thread=new Thread(client);
                thread.start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
