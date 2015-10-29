package com.jedabero.tiledgame.gfx;

import com.jedabero.tiledgame.Game;
import com.jedabero.tiledgame.entities.Entity;

/**
 * GameCamera
 * Created by jedabero on 28/10/15.
 */
public class GameCamera {

    private Game game;
    private float xOffset, yOffset;

    public GameCamera(Game game, float xOffset, float yOffset) {
        this.game = game;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void move(float dx, float dy) {
        xOffset += dx;
        yOffset += dy;
    }

    public void centerOnEntity(Entity entity) {
        xOffset = entity.getPosition().x - game.getWidth() / 2 + entity.getSize().width / 2;
        yOffset = entity.getPosition().y - game.getHeight() / 2 + entity.getSize().height /2;
    }

    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}
