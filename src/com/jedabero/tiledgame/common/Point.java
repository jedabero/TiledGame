package com.jedabero.tiledgame.common;

import java.awt.geom.Point2D;

/**
 * Point
 * Created by jedabero on 26/10/15.
 */
public class Point extends Point2D.Float {

    public Point(float x, float y) {
        super(x, y);
    }

    public void move(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void translate(float dx, float dy) {
        this.x += dx;
        this.y += dy;
    }

}
