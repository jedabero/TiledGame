package com.jedabero.tiledgame.states;

import com.jedabero.tiledgame.Game;
import com.jedabero.tiledgame.entities.creatures.Player;
import com.jedabero.tiledgame.tiles.TileManager;
import com.jedabero.tiledgame.world.World;

import java.awt.Graphics;

/**
 * GameState
 * Created by jedabero on 25/10/15.
 */
public class GameState extends State {

    private Player player;
    private World world;

    public GameState(Game game) {
        super(game);
        player = new Player(game, 100, 100);
        world = new World(game, "res/worlds/world2.txt");
    }

    @Override
    public void tick() {
        world.tick();
        player.tick();
    }

    @Override
    public void render(Graphics graphics) {
        world.render(graphics);
        player.render(graphics);
    }
}
