package com.kuhy.nameless_quest.states;

import com.kuhy.nameless_quest.game.GameState;

import java.util.EnumMap;

/**
 * Created by Kuhy on 15.6.2017.
 */

public class StateMachine
{
    private static StateMachine instance;
    EnumMap<States, State> states = new EnumMap<States, State>(States.class);
    State currentState = null;

    public enum States {GAME}

    private StateMachine() {
        states.put(States.GAME, new GameState());
    }

    public static StateMachine getInstance() {
        if (instance == null) {
            instance = new StateMachine();
        }
        return instance;
    }

    public void update(float elapsedTime)
    {
        if(currentState != null)
            currentState.update(elapsedTime);
    }

    public void render()
    {
        if(currentState != null)
            currentState.render();
    }

    public void change(States stateEnum)
    {
        if(currentState != null)
            currentState.onExit();
        currentState = states.get(stateEnum);
        currentState.onEnter();
    }

    public void onExit() {
        if(currentState != null)
            currentState.onExit();
    }
}