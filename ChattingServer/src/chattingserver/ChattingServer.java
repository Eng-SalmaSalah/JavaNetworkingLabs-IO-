/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chattingserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author salma
 */
public class ChattingServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            
            while (true) {
                Socket incoming = serverSocket.accept();
                Runnable runnable = new ServerHandler(incoming);
                Thread thread = new Thread(runnable);
                thread.start();
                
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
