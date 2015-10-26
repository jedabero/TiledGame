package com.jedabero.tiledgame.tiles;

import com.jedabero.tiledgame.common.RenderableTo;
import com.jedabero.tiledgame.common.Updateable;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Tile
 * Created by jedabero on 26/10/15.
 */
public class Tile implements Updateable, RenderableTo {

    public static final int TILE_WIDTH = 64;
    public static final int TILE_HEIGHT = 64;

    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;

        TileManager.tiles[id] = this;
    }

    public int getId() {
        return id;
    }

    public boolean isSolid() {
        return false;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics, int x, int y) {
        graphics.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

}
