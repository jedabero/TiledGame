package com.jedabero.tiledgame.entities;

import com.jedabero.tiledgame.common.Point;
import com.jedabero.tiledgame.common.Renderable;
import com.jedabero.tiledgame.common.Updateable;

import java.awt.Dimension;

/**
 * Entity
 * Created by jedabero on 25/10/15.
 */
public abstract class Entity implements Updateable, Renderable {

    protected Point position;
    protected Dimension size;

    public Entity(float x, float y, int width, int height) {
        position = new Point(x, y);
        size = new Dimension(width, height);
    }

    public Point getPosition() {
        return position;
    }

    public void setPositionX(float x) {
        position.x = x;
    }

    public void setPositionY(float y) {
        position.y = y;
    }

    public Dimension getSize() {
        return size;
    }

    public void setWidth(int width) {
        size.width = width;
    }

    public void setHeight(int height) {
        size.height = height;
    }

}
