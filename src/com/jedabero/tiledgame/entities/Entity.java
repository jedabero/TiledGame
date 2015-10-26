package com.jedabero.tiledgame.entities;

import com.jedabero.tiledgame.common.Renderable;
import com.jedabero.tiledgame.common.Updateable;

import java.awt.geom.Point2D;

/**
 * Entity
 * Created by jedabero on 25/10/15.
 */
public abstract class Entity implements Updateable, Renderable {

    protected Point2D.Float position;

    public Entity(float x, float y) {
        position = new Point2D.Float(x, y);
    }

}
