package com.jedabero.tiledgame.states;

import com.jedabero.tiledgame.entities.creatures.Player;

import java.awt.Graphics;

/**
 * GameState
 * Created by jedabero on 25/10/15.
 */
public class GameState extends State {

    private Player player;

    public GameState() {
        player = new Player(100, 100);
    }

    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics graphics) {
        player.render(graphics);
    }
}
