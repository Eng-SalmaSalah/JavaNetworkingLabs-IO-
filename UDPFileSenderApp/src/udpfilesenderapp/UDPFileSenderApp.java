/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpfilesenderapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 *
 * @author salma
 */
public class UDPFileSenderApp {

    /**
     * @param args the command line arguments
     */
    DatagramSocket datagramSocket;
    DatagramPacket datagramPacket;
    FileReader fileReader;
    Scanner scanner;
    String line;
    InetAddress inetAddress;
    byte[] data;

    public UDPFileSenderApp() {
        data = new byte[1000];
        try {
            datagramSocket = new DatagramSocket();
            try {

                scanner = new Scanner(new File("C:\\Users\\salma\\Desktop\\salma.txt"));

                while (scanner.hasNext()) {
                    line = scanner.nextLine();
                    data = line.getBytes();
                    sendData(data);
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        } finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }

    }

    public void sendData(byte[] dataArray) {

        try {
            datagramPacket = new DatagramPacket(dataArray, dataArray.length, inetAddress.getLocalHost(), 5000);
            datagramSocket.send(datagramPacket);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UDPFileSenderApp senderApp = new UDPFileSenderApp();

    }
}
