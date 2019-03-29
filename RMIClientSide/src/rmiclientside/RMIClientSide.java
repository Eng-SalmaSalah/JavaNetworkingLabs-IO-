/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclientside;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmicommoninterfaces.SayHelloInterface;

/**
 *
 * @author salma
 */
public class RMIClientSide {

    /**
     * @param args the command line arguments
     */
    public RMIClientSide() {

        try {
            Registry reg
                    = LocateRegistry.getRegistry("127.0.0.1");
            SayHelloInterface helloRefrence = (SayHelloInterface) reg.lookup("HelloService");
            String str = helloRefrence.sayHello("JETS");
            System.out.println(str);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new RMIClientSide();
    }

}
