/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmicommonchat;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author salma
 */
public interface clientInterface extends Remote{
    public void recieve(String message) throws RemoteException;
    
}
