package com.jedabero.tiledgame.states;

import com.jedabero.tiledgame.gfx.Assets;

import java.awt.*;

/**
 * GameState
 * Created by jedabero on 25/10/15.
 */
public class GameState implements State {

    public GameState() { }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.dirt, 0, 0, null);
    }
}
