/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingfromserver;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author salma
 */
public class MyServer {

    public static void main(String args[]) {

        try {
            ServerSocket serverSocket = new ServerSocket(1286);
            Socket socket = serverSocket.accept();
            OutputStream socketOutStream = socket.getOutputStream();
            DataOutputStream socketDOS = new DataOutputStream(socketOutStream);
            socketDOS.writeUTF("Hello world!");
            socketDOS.close();
            socketOutStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
