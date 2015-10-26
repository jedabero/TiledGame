package com.jedabero.tiledgame;

import com.jedabero.tiledgame.display.Display;
import com.jedabero.tiledgame.gfx.ImageLoader;
import com.jedabero.tiledgame.gfx.SpriteSheet;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

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

    private BufferedImage testFace;
    private SpriteSheet sheet;
    private void init() {
        display = new Display(title, width, height);
        testFace = ImageLoader.loadImage("/textures/sheet.png");
        sheet = new SpriteSheet(testFace);
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

        graphics.drawImage(sheet.crop(0,0,32,32),10, 50, null);
        graphics.drawImage(sheet.crop(32,0,32,32),50, 10, null);

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
