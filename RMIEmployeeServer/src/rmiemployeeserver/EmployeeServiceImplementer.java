/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiemployeeserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import rmiemployeecommon.Employee;
import rmiemployeecommon.EmployeeServicesInterface;

/**
 *
 * @author salma
 */
public class EmployeeServiceImplementer extends UnicastRemoteObject implements EmployeeServicesInterface {

    static ArrayList<Employee> employeesList = new ArrayList<Employee>();

    public EmployeeServiceImplementer() throws RemoteException {
    }

    @Override
    public void addEmployee(Employee employee) throws RemoteException {
        employeesList.add(employee);
    }

    @Override
    public void removeEmployee(int id) throws RemoteException {
        for (int i = 0; i < employeesList.size(); i++) {
            if (employeesList.get(i).getId() == id) {
                employeesList.remove(employeesList.get(i));
            }
        }

    }

    @Override
    public void updateEmployee(int id, int salary, String name) throws RemoteException {
        for (int i = 0; i < employeesList.size(); i++) {
            if (employeesList.get(i).getId() == id) {
                employeesList.get(i).setName(name);
                employeesList.get(i).setSalary(salary);
            }
        }
    }

    @Override
    public Employee getEmployee(int id) throws RemoteException {
        Employee selectedEmployee=null;
        for (int i = 0; i < employeesList.size(); i++) {
            if (employeesList.get(i).getId() == id) {
                selectedEmployee= employeesList.get(i);
            }
        }
        return selectedEmployee;
    }

    @Override
    public ArrayList<Employee> getEmployeeList() throws RemoteException {
        return employeesList;
    }

}
