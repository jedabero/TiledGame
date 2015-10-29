package com.jedabero.tiledgame;

import com.jedabero.tiledgame.gfx.GameCamera;
import com.jedabero.tiledgame.world.World;

/**
 * GameHandler
 * Created by jedabero on 28/10/15.
 */
public class GameHandler {

    private Game game;
    private World world;

    public GameHandler(Game game) {
        this.game = game;
    }

    public int getWidth() {
        return game.getWidth();
    }

    public int getHeight() {
        return game.getHeight();
    }

    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }

    public GameCamera getGameCamera() {
        return game.getGameCamera();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
