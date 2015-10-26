package com.jedabero.tiledgame.entities.creatures;

import com.jedabero.tiledgame.gfx.Assets;

import java.awt.Graphics;

/**
 * Player
 * Created by jedabero on 25/10/15.
 */
public class Player extends Creature {

    public Player(float x, float y) {
        super(x, y);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.player1, (int)position.x, (int)position.y, null);
    }

}
