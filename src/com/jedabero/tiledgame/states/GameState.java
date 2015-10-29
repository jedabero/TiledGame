package com.jedabero.tiledgame.states;

import com.jedabero.tiledgame.GameHandler;
import com.jedabero.tiledgame.entities.creatures.Player;
import com.jedabero.tiledgame.world.World;

import java.awt.*;

/**
 * GameState
 * Created by jedabero on 25/10/15.
 */
public class GameState extends State {

    private Player player;
    private World world;

    public GameState(GameHandler handler) {
        super(handler);
        world = new World(handler, "res/worlds/world2.txt");
        handler.setWorld(world);
        player = new Player(handler, 100, 100);
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
