package com.jedabero.tiledgame;

import com.jedabero.tiledgame.display.Display;
import com.jedabero.tiledgame.gfx.Assets;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 * Game
 * Created by jedabero on 25/10/15.
 */
public class Game implements Runnable {

    private Display display;
    private String title;
    private int width, height;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bufferStrategy;
    private Graphics graphics;

    public Game (String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    private void init() {
        display = new Display(title, width, height);
        Assets.init();
    }

    private void tick() {

    }

    private void render() {
        bufferStrategy = display.getCanvas().getBufferStrategy();
        if (bufferStrategy == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = bufferStrategy.getDrawGraphics();
        /* Clear screen */
        graphics.clearRect(0, 0, width, height);
        /* Drawing section */

        graphics.drawImage(Assets.dirt, 10, 10, null);
        graphics.drawImage(Assets.tree, 100, 10, null);

        /* ENd Drawing section */
        bufferStrategy.show();
        graphics.dispose();
    }

    @Override
    public void run() {
        init();

        while (running) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tick();
            render();
        }

        stop();
    }

    public synchronized void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
