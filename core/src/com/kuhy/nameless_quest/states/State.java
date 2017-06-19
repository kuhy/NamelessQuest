package com.kuhy.nameless_quest.states;

/**
 * Created by Kuhy on 15.6.2017.
 */

public interface State
{
    void update(float elapsedTime);
    void render();
    void onEnter();
    void onExit();
}