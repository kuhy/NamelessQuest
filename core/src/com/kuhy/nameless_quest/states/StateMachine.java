package com.kuhy.nameless_quest.states;

import com.kuhy.nameless_quest.game.GameState;
import com.kuhy.nameless_quest.in_game_menu.InGameMenuState;
import com.kuhy.nameless_quest.main_menu.MainMenuState;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Kuhy on 15.6.2017.
 */

public class StateMachine
{
    private static StateMachine instance;
    EnumMap<States, State> states = null;
    State currentState = null;

    public enum States {
        GAME(false), MAIN_MENU(false), IN_GAME_MENU(false);
        boolean started;
        States(boolean started) {this.started = started;}

        public boolean isStarted() {
            return started;
        }

        protected void setStarted(boolean started) {
            this.started = started;
        }
    }

    private StateMachine() {
    }

    public void setup() {
        states = new EnumMap<States, State>(States.class);
        currentState = null;
        states.put(States.GAME, new GameState());
        states.put(States.MAIN_MENU, new MainMenuState());
        states.put(States.IN_GAME_MENU, new InGameMenuState());
        for(States enumState: States.values())
            enumState.setStarted(false);
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
        onExit();
        if(states != null)
            currentState = states.get(stateEnum);
        if(currentState != null) {
            if(stateEnum.isStarted())
                onExit();
            stateEnum.setStarted(true);
            currentState.onEnter();
            currentState.onResume();
        }
    }

    public void change(States stateEnum, boolean onEnter, boolean onExit)
    {
        if(currentState != null) {
            getEnumByState(currentState).setStarted(false);
            currentState.onPause();
            if (onExit)
                currentState.onExit();
        }
        if(states != null)
            currentState = states.get(stateEnum);
        if(currentState != null) {
            if(stateEnum.isStarted() && onEnter)
                currentState.onExit();
            stateEnum.setStarted(true);
            if(onEnter)
                currentState.onEnter();
            currentState.onResume();
        }
    }

    public void onExit() {
        if(currentState != null) {
            getEnumByState(currentState).setStarted(false);
            currentState.onPause();
            currentState.onExit();
        }
    }

    private States getEnumByState(State state) {
        for (Map.Entry<States, State> entry : states.entrySet()) {
            if (state.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void dispose() {
        for(States enumState: States.values())
            if(enumState.isStarted())
                states.get(enumState).onExit();
    }
}