package com.jedabero.tiledgame.gfx;

import com.jedabero.tiledgame.GameHandler;
import com.jedabero.tiledgame.entities.Entity;
import com.jedabero.tiledgame.tiles.Tile;

/**
 * GameCamera
 * Created by jedabero on 28/10/15.
 */
public class GameCamera {

    private GameHandler handler;
    private float xOffset, yOffset;

    public GameCamera(GameHandler handler, float xOffset, float yOffset) {
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void checkBlankSpace() {
        if (xOffset < 0) {
            xOffset = 0;
        } else {
            float rigthSide = handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth();
            if (xOffset > rigthSide) {
                xOffset = rigthSide;
            }
        }


        if (yOffset < 0) {
            yOffset = 0;
        } else {
            float bottomSide = handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight();
            if (yOffset > bottomSide) {
                yOffset = bottomSide;
            }
        }
    }

    public void move(float dx, float dy) {
        xOffset += dx;
        yOffset += dy;
        checkBlankSpace();
    }

    public void centerOnEntity(Entity entity) {
        xOffset = entity.getX() - handler.getWidth() / 2 + entity.getWidth() / 2;
        yOffset = entity.getY() - handler.getHeight() / 2 + entity.getHeight() / 2;
        checkBlankSpace();
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
