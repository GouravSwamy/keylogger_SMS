/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

/**
 *
 * @author RITIK
 */
public class keyStorage {
    private int keyCode;
    private boolean pressed;
    private long systemTimePresssedMillis;

    public keyStorage(int keyCode, boolean pressed, long systemTimePresssedMillis) {
        super();
        this.keyCode = keyCode;
        this.pressed = pressed;
        this.systemTimePresssedMillis = systemTimePresssedMillis;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public boolean isPressed() {
        return pressed;
    }

    public long getSystemTimePresssedMillis() {
        return systemTimePresssedMillis;
    }

    @Override
    public String toString() {
        return "keyStorage{" + "keyCode=" + keyCode + ", pressed=" + pressed + ", systemTimePresssedMillis=" + systemTimePresssedMillis + '}';
    }
    
}
