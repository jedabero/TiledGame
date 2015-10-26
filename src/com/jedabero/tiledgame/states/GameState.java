package com.jedabero.tiledgame.states;

import com.jedabero.tiledgame.Game;
import com.jedabero.tiledgame.entities.creatures.Player;
import com.jedabero.tiledgame.tiles.TileManager;

import java.awt.Graphics;

/**
 * GameState
 * Created by jedabero on 25/10/15.
 */
public class GameState extends State {

    private Player player;

    public GameState(Game game) {
        super(game);
        player = new Player(game, 100, 100);
    }

    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics graphics) {
        TileManager.tiles[0].render(graphics, 0, 0);
        player.render(graphics);
    }
}
