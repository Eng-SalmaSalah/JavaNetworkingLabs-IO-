/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserverside;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmicommoninterfaces.SayHelloInterface;


/**
 *
 * @author salma
 */
public class SayHelloImplementation extends UnicastRemoteObject implements SayHelloInterface {

    public SayHelloImplementation() throws RemoteException {
    }

    @Override
    public String sayHello(String name ) throws RemoteException {
        return "Hello"+name;
    }

}
