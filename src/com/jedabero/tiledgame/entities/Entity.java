package com.jedabero.tiledgame.entities;

import com.jedabero.tiledgame.GameHandler;
import com.jedabero.tiledgame.common.*;

import java.awt.*;

/**
 * Entity
 * Created by jedabero on 25/10/15.
 */
public abstract class Entity implements Updateable, Renderable {

    protected GameHandler handler;
    protected float x, y;
    protected int width, height;

    protected Rectangle bounds;

    public Entity(GameHandler game, float x, float y, int width, int height) {
        this.handler = game;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        bounds = new Rectangle(width, height);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
