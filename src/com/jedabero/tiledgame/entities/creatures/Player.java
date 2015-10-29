package com.jedabero.tiledgame.entities.creatures;

import com.jedabero.tiledgame.Game;
import com.jedabero.tiledgame.gfx.Assets;

import java.awt.Graphics;

/**
 * Player
 * Created by jedabero on 25/10/15.
 */
public class Player extends Creature {

    public Player(Game game, float x, float y) {
        super(game, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
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
        game.getGameCamera().centerOnEntity(this);
    }

    @Override
    public void render(Graphics graphics) {
        int x = (int) (position.x - game.getGameCamera().getxOffset());
        int y = (int) (position.y - game.getGameCamera().getyOffset());
        graphics.drawImage(Assets.player1, x, y, getSize().width, getSize().height, null);
    }

}
