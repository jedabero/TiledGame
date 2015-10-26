package com.jedabero.tiledgame.tiles;

/**
 * TileManager
 * Created by jedabero on 26/10/15.
 */
public class TileManager {

    public static Tile[] tiles = new Tile[256];

    public static Tile dirtTile = new DirtTile(0);
    public static Tile grassTile = new GrassTile(1);
    public static Tile stoneTile = new StoneTile(2);

}
