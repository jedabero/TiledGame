package com.jedabero.tiledgame.world;

import com.jedabero.tiledgame.GameHandler;
import com.jedabero.tiledgame.common.Renderable;
import com.jedabero.tiledgame.common.Updateable;
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

    private GameHandler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] map;

    public World(GameHandler handler, String path) {
        this.handler = handler;
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

        if (isOutsideMap(i, j)) {
            return TileManager.dirtTile;
        }

        Tile tile = TileManager.tiles[map[i][j]];
        if (tile == null)
            return TileManager.dirtTile;
        return tile;
    }

    public boolean isOutsideMap(int x, int y) {
        return x < 0 || y < 0 || x >= width || y >= height;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        int firstXTile = (int) (handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
        int xStart = Math.max(0, firstXTile);
        int firstYTile = (int) (handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
        int yStart = Math.max(0, firstYTile);
        int lastXTile = (int) ((handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
        int xEnd = Math.min(width,lastXTile);
        int lastYTile = (int) ((handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);
        int yEnd = Math.min(height, lastYTile);
        float xOffset = handler.getGameCamera().getxOffset();
        float yOffset = handler.getGameCamera().getyOffset();
        for (int j = yStart; j < yEnd; j++) {
            for (int i = xStart; i < xEnd; i++) {
                int xPos = (int) (i * Tile.TILE_WIDTH - xOffset);
                int yPos = (int) (j * Tile.TILE_HEIGHT - yOffset);
                getTile(i, j).render(graphics, xPos, yPos);
            }
        }

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
