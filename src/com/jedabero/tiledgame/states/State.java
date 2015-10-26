package com.jedabero.tiledgame.states;

import java.awt.Graphics;

/**
 * State
 * Created by jedabero on 25/10/15.
 */
public interface State {

    void tick();

    void render(Graphics graphics);

}
