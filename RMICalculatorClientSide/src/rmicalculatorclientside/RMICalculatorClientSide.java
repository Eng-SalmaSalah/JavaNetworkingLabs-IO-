/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmicalculatorclientside;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmicalculatorcommoninterfaces.ArithmeticOperationsInterface;

/**
 *
 * @author salma
 */
public class RMICalculatorClientSide {

    public RMICalculatorClientSide() {
        int firstOperand = 6;
        int secondOperand = 2;
        char operator = '+';
        int result;
        try {
            Registry reg
                    = LocateRegistry.getRegistry();
            ArithmeticOperationsInterface calcRefrence
                    = (ArithmeticOperationsInterface) reg.lookup("CalculatorService");
            switch (operator) {
                case '+':
                    result = calcRefrence.addNumbers(firstOperand, secondOperand);
                    System.out.println("summation result is:" + result);
                    break;
                case '-':
                    result = calcRefrence.subtractNumbers(firstOperand, secondOperand);
                    System.out.println("subtraction result is:" + result);
                    break;
                case '*':
                    result = calcRefrence.multiplyNumbers(firstOperand, secondOperand);
                    System.out.println("multiplication result is:" + result);
                    break;

                case '/':
                    result = calcRefrence.divideNumbers(firstOperand, secondOperand);
                    System.out.println("division result is:" + result);
                    break;
                default:
                    System.out.println("invalid operation");
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new RMICalculatorClientSide();
    }

}
