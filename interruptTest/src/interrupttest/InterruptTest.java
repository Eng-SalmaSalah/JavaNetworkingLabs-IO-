/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interrupttest;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salma
 */
public class InterruptTest {

    static void threadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n", threadName, message);
    }

    private static class MessageLoop implements Runnable {

        @Override
        public void run() {
            String importantInfo[] = {
                "Waking up at 5:00",
                "Taking a shawer at 5:15",
                "Taking breakfast at 6:00",
                "Going to work at 6:30"
            };
            for (int i = 0; i < importantInfo.length; i++) {
                try {
                    // Pause for 4 seconds
                    Thread.sleep(4000);
                    // Print a message
                    threadMessage(importantInfo[i]);
                } catch (InterruptedException ex) {
                    System.out.println("h2of");
                    
                    Thread.currentThread().stop();
                }

            }

        }

    }

    public static void main(String[] args)  {
        long patience = 1000 * 60 * 60;
        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        
        t.start();
        while (t.isAlive()) {
            threadMessage("Still waiting...");
            //main thread btsht8l mkan t thread every 1 sec (bec t is sleeping 4 secs 7sl kda 4 mrat)
            //awl still waiting etb3t 3latol w b3d snya etb3t tany w hakza
            t.interrupt();
            
            try {
                t.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(InterruptTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(t.isInterrupted());
            
            //m3naha estne sanya w esht8le mkan t
            if (((System.currentTimeMillis()
                    - startTime) > patience) && t.isAlive()) {
                try {
                    threadMessage("Tired of waiting!");
                    t.interrupt();
// Shouldn't be long now
// -- wait indefinitely
t.join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(InterruptTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           
        }
         threadMessage("Finally!");

    }
}
