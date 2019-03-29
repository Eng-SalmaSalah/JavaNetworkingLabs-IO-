/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmicalculatorserverside;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmicalculatorcommoninterfaces.ArithmeticOperationsInterface;

/**
 *
 * @author salma
 */
public class CalculatorImplementer extends UnicastRemoteObject implements ArithmeticOperationsInterface {

    public CalculatorImplementer() throws RemoteException {
    }

    @Override
    public int addNumbers(int first, int second) throws RemoteException {
        return first + second;
    }

    @Override
    public int subtractNumbers(int first, int second) throws RemoteException {
        return first - second;
    }

    @Override
    public int multiplyNumbers(int first, int second) throws RemoteException {
        return first * second;
    }

    @Override
    public int divideNumbers(int first, int second) throws RemoteException {
        return first / second;
    }

}
