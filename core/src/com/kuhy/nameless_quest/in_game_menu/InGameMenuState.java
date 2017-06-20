package com.kuhy.nameless_quest.in_game_menu;

import com.badlogic.gdx.Gdx;
import com.kuhy.nameless_quest.main_menu.MainMenuUI;
import com.kuhy.nameless_quest.states.State;

/**
 * Created by Kuhy on 20.6.2017.
 */

public class InGameMenuState implements State {
    InGameMenuUI inGameMenuUI;

    @Override
    public void onEnter() {
        inGameMenuUI = new InGameMenuUI();
        inGameMenuUI.onEnter();
    }

    @Override
    public void onResume() {
        Gdx.input.setInputProcessor(inGameMenuUI);
    }

    @Override
    public void onPause() {

    }

    @Override
    public void update(float elapsedTime) {
        inGameMenuUI.act();
    }

    @Override
    public void render() {
        inGameMenuUI.draw();
    }

    @Override
    public void onExit() {
        inGameMenuUI.onExit();
    }
}
