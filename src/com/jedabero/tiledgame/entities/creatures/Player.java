package com.jedabero.tiledgame.entities.creatures;

import com.jedabero.tiledgame.Game;
import com.jedabero.tiledgame.gfx.Assets;

import java.awt.Graphics;

/**
 * Player
 * Created by jedabero on 25/10/15.
 */
public class Player extends Creature {

    private Game game;

    public Player(Game game, float x, float y) {
        super(x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
        this.game = game;
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;
        if (game.getKeyManager().up) {
            yMove = -speed;
        }
        if (game.getKeyManager().down) {
            yMove = speed;
        }
        if (game.getKeyManager().left) {
            xMove = -speed;
        }
        if (game.getKeyManager().right) {
            xMove = speed;
        }
    }

    @Override
    public void tick() {
        getInput();
        move();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.player1, (int)position.x, (int)position.y, getSize().width, getSize().height, null);
    }

}
