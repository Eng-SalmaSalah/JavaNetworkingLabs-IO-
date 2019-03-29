/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserverside;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salma
 */
public class RMIServerSide {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Registry registry=LocateRegistry.getRegistry();
            registry.rebind("HelloService", new SayHelloImplementation());
            System.out.println("Server Is Running");
            
        } catch (RemoteException ex) {
            
        }
    }
    
}
