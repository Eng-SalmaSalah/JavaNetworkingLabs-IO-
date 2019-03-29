/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiemployeecommon;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author salma
 */
public interface EmployeeServicesInterface extends Remote {
    
    
    public void addEmployee (Employee employee) throws RemoteException;
    public void removeEmployee (int id) throws RemoteException;
    public void updateEmployee (int id,int salary,String name) throws RemoteException;
    public Employee getEmployee (int id) throws RemoteException;
    public ArrayList<Employee> getEmployeeList() throws RemoteException;

}
