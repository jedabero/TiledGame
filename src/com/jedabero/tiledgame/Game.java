package com.jedabero.tiledgame;

import com.jedabero.tiledgame.display.Display;

/**
 * Game
 * Created by jedabero on 25/10/15.
 */
public class Game {

    private Display display;

    private String title;
    private int width, height;

    public Game (String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;

        display = new Display(title, width, height);
    }

}
