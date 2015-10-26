package com.jedabero.tiledgame.states;

import com.jedabero.tiledgame.Game;
import com.jedabero.tiledgame.common.Renderable;
import com.jedabero.tiledgame.common.Updateable;

/**
 * State
 * Created by jedabero on 25/10/15.
 */
public abstract class State implements Updateable, Renderable {

    protected Game game;

    public State(Game game) {
        this.game = game;
    }
}
