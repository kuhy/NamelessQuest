package com.kuhy.nameless_quest.states;

import java.util.HashMap;

/**
 * Created by Kuhy on 15.6.2017.
 */

public class StateMachine
{
    HashMap<String, State> states = new HashMap<String, State>();
    State currentState = null;

    public StateMachine(String name, State state) {
        states.put(name, state);
        currentState = state;
        state.onEnter();
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

    public void change(String stateName)
    {
        currentState.onExit();
        currentState = states.get(stateName);
        currentState.onEnter();
    }

    public void add(String name, State state)
    {
        states.put(name, state);
    }

    public void onExit() {
        currentState.onExit();
    }
}
