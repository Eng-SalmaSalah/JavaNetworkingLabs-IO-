/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmicalculatorserverside;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author salma
 */
public class RMICalculatorServerSide {

    /**
     * @param args the command line arguments
     */
    public RMICalculatorServerSide() {
        try {
            CalculatorImplementer calc = new CalculatorImplementer();
            Registry reg = LocateRegistry.getRegistry();
            reg.rebind("CalculatorService", calc);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new RMICalculatorServerSide();
    }

}
