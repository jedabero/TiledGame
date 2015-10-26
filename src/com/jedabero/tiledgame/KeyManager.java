package com.jedabero.tiledgame;

import com.jedabero.tiledgame.common.Updateable;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * KeyManager
 * Created by jedabero on 25/10/15.
 */
public class KeyManager implements KeyListener, Updateable{

    private boolean[] keys;
    public boolean up, down, left, right;

    public KeyManager() {
        keys = new boolean[256];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void tick() {
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        System.out.println("Pressed " + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

}
