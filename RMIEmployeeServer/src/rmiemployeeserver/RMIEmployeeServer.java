/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiemployeeserver;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author salma
 */
public class RMIEmployeeServer {

    /**
     * @param args the command line arguments
     */
    
    public RMIEmployeeServer() {
        
        try {
            EmployeeServiceImplementer employeeService = new EmployeeServiceImplementer();
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("EmployeeService", employeeService);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new RMIEmployeeServer();
    }
    
}
