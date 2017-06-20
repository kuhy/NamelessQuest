package com.kuhy.nameless_quest.main_menu;

import com.badlogic.gdx.Gdx;
import com.kuhy.nameless_quest.states.State;

/**
 * Created by Kuhy on 20.6.2017.
 */

public class MainMenuState implements State {
    MainMenuUI mainMenuUI;

    @Override
    public void onEnter() {
        mainMenuUI = new MainMenuUI();
        mainMenuUI.onEnter();
    }

    @Override
    public void onResume() {
        Gdx.input.setInputProcessor(mainMenuUI);
    }

    @Override
    public void onPause() {

    }

    @Override
    public void update(float elapsedTime) {
        mainMenuUI.act();
    }

    @Override
    public void render() {
        mainMenuUI.draw();
    }

    @Override
    public void onExit() {
        mainMenuUI.onExit();
    }
}
