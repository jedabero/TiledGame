package com.jedabero.tiledgame.world;

import com.jedabero.tiledgame.Game;
import com.jedabero.tiledgame.common.Renderable;
import com.jedabero.tiledgame.common.Updateable;
import com.jedabero.tiledgame.gfx.GameCamera;
import com.jedabero.tiledgame.tiles.Tile;
import com.jedabero.tiledgame.tiles.TileManager;
import com.jedabero.tiledgame.utils.FileLoader;
import com.jedabero.tiledgame.utils.Utils;

import java.awt.Graphics;

/**
 * World
 * Created by jedabero on 26/10/15.
 */
public class World implements Updateable, Renderable {

    private Game game;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] map;

    public World(Game game, String path) {
        this.game = game;
        loadWorld(path);

    }

    private void loadWorld(String path) {
        String file = FileLoader.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);
        map = new int[width][height];
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                map[i][j] = Utils.parseInt(tokens[(i + j * width) + 4]);
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
        float xOffset = game.getGameCamera().getxOffset();
        float yOffset = game.getGameCamera().getyOffset();
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                int xPos = (int) (i * Tile.TILE_WIDTH - xOffset);
                int yPos = (int) (j * Tile.TILE_HEIGHT - yOffset);
                getTile(i, j).render(graphics, xPos, yPos);
            }
        }

    }
}
