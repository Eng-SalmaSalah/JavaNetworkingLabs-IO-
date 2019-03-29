/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmicalculatorcommoninterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author salma
 */
public interface ArithmeticOperationsInterface extends Remote {
    
    int addNumbers(int first,int second)throws RemoteException;
    int subtractNumbers(int first,int second)throws RemoteException;
    int multiplyNumbers(int first,int second)throws RemoteException;
    int divideNumbers(int first,int second)throws RemoteException;
    
}
