/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversidechatapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author salma
 */
public class ServerHandler implements Runnable {

    static ArrayList<ServerHandler> clientsArray = new ArrayList<ServerHandler>();
    Socket incoming;
    InputStream inputStream;
    DataInputStream dataInStream;
    OutputStream outputStream;
    DataOutputStream dataOutStream;
    String inputMessage;

    public ServerHandler(Socket incomingSocket) {
        clientsArray.add(this);
        this.incoming = incomingSocket;
    }

    public void broadcast(String input) {
        for (int i = 0; i < clientsArray.size(); i++) {
            try {
                outputStream = clientsArray.get(i).incoming.getOutputStream();
                dataOutStream = new DataOutputStream(outputStream);
                dataOutStream.writeUTF(input);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                inputStream = this.incoming.getInputStream();
                dataInStream = new DataInputStream(inputStream);
                inputMessage = dataInStream.readUTF();
                this.broadcast(inputMessage);

            } catch (IOException ex) {
                ex.printStackTrace();
            } 
        }

    }

}
