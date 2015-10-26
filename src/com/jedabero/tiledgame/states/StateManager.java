package com.jedabero.tiledgame.states;

/**
 * StateManager
 * Created by jedabero on 25/10/15.
 */
public class StateManager {

    private static State currentState = null;

    public static void setState(State state) {
        currentState = state;
    }

    public static State getState() {
        return currentState;
    }

}
