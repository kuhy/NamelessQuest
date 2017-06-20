package com.kuhy.nameless_quest.main_menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.kuhy.nameless_quest.states.StateMachine;
import com.kuhy.nameless_quest.states.UITools;
import com.kuhy.nameless_quest.states.UserInterface;

/**
 * Created by Kuhy on 20.6.2017.
 */

public class MainMenuUI extends Stage implements UserInterface {

    public MainMenuUI() {
        super(new StretchViewport(800, 500));
    }

    @Override
    public void onEnter() {
        final TextButton newGameButton = UITools.makeTextButton("New game", 250, 260, 300, 40);
        final TextButton exitButton = UITools.makeTextButton("Exit", 250, 200, 300, 40);

        newGameButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                StateMachine.getInstance().change(StateMachine.States.GAME);
            }
        });

        exitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                Gdx.app.exit();
            }
        });

        addActor(newGameButton);
        addActor(exitButton);
    }

    @Override
    public void onExit() {
        dispose();
    }
}
