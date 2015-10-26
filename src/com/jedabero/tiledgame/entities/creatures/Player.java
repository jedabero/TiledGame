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
        super(x, y);
        this.game = game;
    }

    @Override
    public void tick() {
        if (game.getKeyManager().up) {
            position.y -= 3;
        }
        if (game.getKeyManager().down) {
            position.y += 3;
        }
        if (game.getKeyManager().left) {
            position.x -= 3;
        }
        if (game.getKeyManager().right) {
            position.x += 3;
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.player1, (int)position.x, (int)position.y, null);
    }

}
