/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingfromserver;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salma
 */
public class ReadingFromServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Socket socket = null;
        InputStream inputStream=null;
        DataInputStream socketDIS=null;
        
        try {
            socket = new Socket(InetAddress.getLocalHost(), 1286);
            inputStream = socket.getInputStream();
            socketDIS = new DataInputStream(inputStream);
            String testString = new String(socketDIS.readUTF());
            System.out.println(testString);
            
        } catch (IOException ex) {
            //System.out.println("Cannot Create Socket !!");
            ex.printStackTrace();
        } finally{
        
            try {
                socketDIS.close();
                inputStream.close();
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadingFromServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
