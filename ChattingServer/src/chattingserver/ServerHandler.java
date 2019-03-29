/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chattingserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author salma
 */
public class ServerHandler implements Runnable {

    private static ArrayList<ServerHandler> clientsArray = new ArrayList<ServerHandler>();
    private Socket incoming;

    public ServerHandler(Socket incomingSocket) {
        clientsArray.add(this);
        incoming = incomingSocket;

    }

    @Override
    public void run() {
        Scanner scanner = null;
        try (InputStream inStream = this.incoming.getInputStream(); OutputStream outStream = this.incoming.getOutputStream()) {
            scanner = new Scanner(inStream, "UTF-8");
            boolean done = false;
            while (!done && scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (ServerHandler c : clientsArray) {
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream, "UTF-8"), true);
                    out.println(line);
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
