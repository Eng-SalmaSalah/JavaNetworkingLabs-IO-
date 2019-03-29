/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializationexample;

import java.io.Serializable;

/**
 *
 * @author salma
 */
public class MyData implements Serializable {

    String s;
    int i;
    double d;
    transient String demo = "Non Transient Attribute";

    public MyData(String s, int i, double d) {
        this.s = s;
        this.i = i;
        this.d = d;
    }

    @Override
    public String toString() {
        return "s=" + s + "; i=" + i + "; d=" + d + "; demo = " + demo;
    }


}
