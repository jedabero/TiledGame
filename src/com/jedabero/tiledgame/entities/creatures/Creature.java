package com.jedabero.tiledgame.entities.creatures;

import com.jedabero.tiledgame.entities.Entity;

/**
 * Creature
 * Created by jedabero on 25/10/15.
 */
public abstract class Creature extends Entity {

    private int health;

    public Creature(float x, float y) {
        super(x, y);
        health = 10;
    }
}
