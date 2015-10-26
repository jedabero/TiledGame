package com.jedabero.tiledgame.world;

import com.jedabero.tiledgame.common.Renderable;
import com.jedabero.tiledgame.common.Updateable;
import com.jedabero.tiledgame.tiles.Tile;
import com.jedabero.tiledgame.tiles.TileManager;

import java.awt.*;

/**
 * World
 * Created by jedabero on 26/10/15.
 */
public class World implements Updateable, Renderable {

    private int width, height;
    private int[][] map;

    public World(String path) {
        loadWorld(path);

    }

    private void loadWorld(String path) {
        width = 5;
        height = 5;
        map = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                map[i][j] = 1;
            }
        }
    }

    public Tile getTile(int i, int j) {
        Tile tile = TileManager.tiles[map[i][j]];
        if (tile == null)
            return TileManager.dirtTile;
        return tile;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                getTile(i, j).render(graphics, i * Tile.TILE_WIDTH, j * Tile.TILE_HEIGHT);
            }
        }

    }
}
