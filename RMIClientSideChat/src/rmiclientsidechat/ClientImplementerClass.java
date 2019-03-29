/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclientsidechat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmicommonchat.clientInterface;

/**
 *
 * @author salma
 */
public class ClientImplementerClass extends UnicastRemoteObject implements  clientInterface{
    ClientGUIBase clientGui;
    public ClientImplementerClass(ClientGUIBase gui) throws RemoteException {
       clientGui=gui; 
    }

    @Override
    public void recieve(String message) throws RemoteException {
        clientGui.textArea.appendText(message);
        clientGui.textArea.appendText("\n");
    }
    
}
