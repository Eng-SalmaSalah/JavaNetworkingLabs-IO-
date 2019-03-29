/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiemployeecommon;

import java.io.Serializable;

/**
 *
 * @author salma
 */
public class Employee implements Serializable {
    private String name;
    private int id;
    private int salary;

    public Employee(String name, int id,int salary) {
        this.name = name;
        this.id = id;
        this.salary=salary;
    }
  
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }
    
    
    
    
}
