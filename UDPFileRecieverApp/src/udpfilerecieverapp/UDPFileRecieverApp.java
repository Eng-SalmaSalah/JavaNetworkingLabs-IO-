/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpfilerecieverapp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UDPFileRecieverApp {

    DatagramSocket datagramSocket;
    DatagramPacket dgtagramPacket;
    byte[] data;

    public UDPFileRecieverApp() {
        data = new byte[1000];

        try {
            datagramSocket = new DatagramSocket(5000);
            while (true) {
                data = new byte[1000];
                DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
                try {
                    datagramSocket.receive(datagramPacket);
                    System.out.println(new String(datagramPacket.getData()));
                    
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
        finally{
        if(datagramSocket!=null)
            datagramSocket.close();
        }

    }

    public static void main(String[] args) {
        UDPFileRecieverApp recieverApp = new UDPFileRecieverApp();
    }

}
