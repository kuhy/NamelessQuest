package com.kuhy.nameless_quest.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.kuhy.nameless_quest.game.entities.Player;
import com.kuhy.nameless_quest.game.entities.WorldEntity;
import com.kuhy.nameless_quest.states.UserInterface;

/**
 * Created by Kuhy on 18.6.2017.
 */

public class GameUI extends Stage implements UserInterface {
    private TextureAtlas arrowsAtlas;
    private Skin arrowSkin;
    final static float ARROWS_DISTANCE = 70f;
    private Player player;

    public GameUI(Player player) {
        super(new StretchViewport(800, 500));
        this.player = player;
    }

    @Override
    public void onEnter() {
        clear();
        Gdx.input.setInputProcessor(this);
        arrowsAtlas = new TextureAtlas(Gdx.files.internal("arrows.atlas"));
        arrowSkin = new Skin();
        arrowSkin.addRegions(arrowsAtlas);
        makeButton(WorldEntity.Direction.up, "arrow-up-off", "arrow-up-on", ARROWS_DISTANCE, 2 * ARROWS_DISTANCE);
        makeButton(WorldEntity.Direction.down, "arrow-down-off", "arrow-down-on", ARROWS_DISTANCE, 0);
        makeButton(WorldEntity.Direction.left, "arrow-left-off", "arrow-left-on", 0, ARROWS_DISTANCE);
        makeButton(WorldEntity.Direction.right, "arrow-right-off", "arrow-right-on", 2 * ARROWS_DISTANCE, ARROWS_DISTANCE);
    }

    private void makeButton(final WorldEntity.Direction direction, String up, String down, float x, float y) {
        Button.ButtonStyle buttonStyle = new Button.ButtonStyle();
        buttonStyle.up = arrowSkin.getDrawable(up);
        buttonStyle.down = arrowSkin.getDrawable(down);
        Button button = new Button(buttonStyle);
        button.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                player.move(direction);
                return true;
            }
        });
        button.setPosition(x, y);
        addActor(button);
    }

    @Override
    public void onExit() {
        dispose();
    }

    @Override
    public void dispose() {
        super.dispose();
        arrowSkin.dispose();
        arrowsAtlas.dispose();
    }
}
