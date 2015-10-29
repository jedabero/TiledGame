package com.jedabero.tiledgame.entities.creatures;

import com.jedabero.tiledgame.GameHandler;
import com.jedabero.tiledgame.gfx.Assets;

import java.awt.*;

/**
 * Player
 * Created by jedabero on 25/10/15.
 */
public class Player extends Creature {

    public Player(GameHandler handler, float x, float y) {
        super(handler, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;
        if (handler.getKeyManager().up) {
            yMove = -speed;
        }
        if (handler.getKeyManager().down) {
            yMove = speed;
        }
        if (handler.getKeyManager().left) {
            xMove = -speed;
        }
        if (handler.getKeyManager().right) {
            xMove = speed;
        }
    }

    @Override
    public void tick() {
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    @Override
    public void render(Graphics graphics) {
        int x = (int) (position.x - handler.getGameCamera().getxOffset());
        int y = (int) (position.y - handler.getGameCamera().getyOffset());
        graphics.drawImage(Assets.player1, x, y, getSize().width, getSize().height, null);
    }

}
