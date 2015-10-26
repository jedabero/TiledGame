package com.jedabero.tiledgame;

/**
 * TiledGame Launcher
 * Created by jedabero on 25/10/15.
 */
public class Launcher {

    public static void main(String[] args) {
        Game game = new Game("TiledGame", 640, 360);
        game.start();
    }

}
