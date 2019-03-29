/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiemployeeclient;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmiemployeecommon.Employee;
import rmiemployeecommon.EmployeeServicesInterface;

/**
 *
 * @author salma
 */
public class RMIEmployeeClient {

    /**
     * @param args the command line arguments
     */
    ArrayList<Employee> employeesList;
    Employee employee;

    public RMIEmployeeClient() {
        Employee employee1 = new Employee("salma", 1, 6000);
        Employee employee2 = new Employee("ahmed", 2, 5000);
        Employee employee3 = new Employee("noran", 3, 4000);
        Employee employee4 = new Employee("amr", 4, 8000);

        try {
            Registry registry = LocateRegistry.getRegistry();
            EmployeeServicesInterface employeeServiceRefrence
                    = (EmployeeServicesInterface) registry.lookup("EmployeeService");
            employeeServiceRefrence.addEmployee(employee1);
            employeeServiceRefrence.addEmployee(employee2);
            employeeServiceRefrence.addEmployee(employee3);
            employeeServiceRefrence.addEmployee(employee4);
            employeesList = employeeServiceRefrence.getEmployeeList();
            printList();
            employeeServiceRefrence.removeEmployee(3);
            employeeServiceRefrence.updateEmployee(4, 2000, "radya");
            employeesList = employeeServiceRefrence.getEmployeeList();
            System.out.println("List after editing: ");
            printList();
            employee = employeeServiceRefrence.getEmployee(1);
            System.out.println("Employees name: " + employee.getName() +"\n" +"Employees Salary: " + employee.getSalary());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void printList() {
        for (int i = 0; i < employeesList.size(); i++) {
            System.out.println("Employee's id: " + employeesList.get(i).getId() + "\n" 
                    + "Employee's name: " + employeesList.get(i).getName() + "\n"
                    + "Employee's Salary: " + employeesList.get(i).getSalary() + "\n");
        }
    }

    public static void main(String[] args) {
        new RMIEmployeeClient();
    }

}
