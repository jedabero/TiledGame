package com.jedabero.tiledgame.states;

import com.jedabero.tiledgame.GameHandler;
import com.jedabero.tiledgame.common.Renderable;
import com.jedabero.tiledgame.common.Updateable;

/**
 * State
 * Created by jedabero on 25/10/15.
 */
public abstract class State implements Updateable, Renderable {

    protected GameHandler handler;

    public State(GameHandler handler) {
        this.handler = handler;
    }
}
