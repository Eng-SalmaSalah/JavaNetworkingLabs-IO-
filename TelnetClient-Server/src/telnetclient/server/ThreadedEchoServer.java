/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telnetclient.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salma
 */
public class ThreadedEchoServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            int counter = 1;
            while (true) {
                Socket incoming = serverSocket.accept();
                System.out.println("Spawning "
                        + counter);
                Runnable runnable = new ThreadedEchoHandler(incoming);
                Thread thread = new Thread(runnable);
                thread.start();
                counter++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
