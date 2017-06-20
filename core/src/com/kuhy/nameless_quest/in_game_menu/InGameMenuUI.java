package com.kuhy.nameless_quest.in_game_menu;

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

public class InGameMenuUI extends Stage implements UserInterface {

    public InGameMenuUI() {
        super(new StretchViewport(800, 500));
    }

    @Override
    public void onEnter() {
        final TextButton continueButton = UITools.makeTextButton("Continue", 250, 260, 300, 40);
        final TextButton mainMenuButton = UITools.makeTextButton("Main menu", 250, 200, 300, 40);

        continueButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                StateMachine.getInstance().change(StateMachine.States.GAME, false, true);
            }
        });

        mainMenuButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                StateMachine.getInstance().change(StateMachine.States.MAIN_MENU);
            }
        });

        addActor(continueButton);
        addActor(mainMenuButton);
    }

    @Override
    public void onExit() {
        dispose();
    }
}
