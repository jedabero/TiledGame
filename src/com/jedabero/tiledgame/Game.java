package com.jedabero.tiledgame;

import com.jedabero.tiledgame.display.Display;
import com.jedabero.tiledgame.gfx.Assets;
import com.jedabero.tiledgame.gfx.GameCamera;
import com.jedabero.tiledgame.states.*;

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

    private GameState gameState;
    private MenuState menuState;
    private SettingsState settingsState;

    private KeyManager keyManager;

    private GameCamera gameCamera;

    private GameHandler handler;

    public Game (String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        keyManager = new KeyManager();
    }

    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        handler = new GameHandler(this);
        gameCamera = new GameCamera(handler, 0, 0);

        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        settingsState = new SettingsState(handler);
        StateManager.setState(gameState);
    }

    private void tick() {
        keyManager.tick();

        if (StateManager.getState() != null)
            StateManager.getState().tick();
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
        if (StateManager.getState() != null)
            StateManager.getState().render(graphics);
        /* End Drawing section */
        bufferStrategy.show();
        graphics.dispose();
    }

    @Override
    public void run() {
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            long diff = now - lastTime;
            delta += diff / timePerTick;
            timer += diff;
            lastTime = now;

            if (delta >= 1) {
                //System.out.println(String.format("Ticks and Frames: %d", ticks));
                tick();
                render();
                delta--;
                ticks++;
            } else {
                long sleepTime = (long)(timePerTick - diff - 1)/1000000;
                //System.out.println(String.format("sleepTime: %d", sleepTime));
                if (sleepTime > 0) {
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
            if (timer >= 1000000000){
                //System.out.println(String.format("Ticks and Frames: %d", ticks));
                ticks = 0;
                timer = 0;
            }
            //System.out.println(String.format("Timer: %d", timer));
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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }
}
