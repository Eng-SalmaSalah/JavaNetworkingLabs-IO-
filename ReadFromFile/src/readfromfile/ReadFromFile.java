/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readfromfile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author salma
 */
public class ReadFromFile {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str ;
        int i = 0;
        String[] inputArray = new String[100];
        do {
            str = br.readLine();
            if (!str.equals("stop")) {
                inputArray[i] = str;
                i++;
            }
            
        } while (!str.equals("stop"));

        for (int itr = 0; itr < i; itr++) {
            System.out.println(inputArray[itr]);
        }

    }

}
