package com.kuhy.nameless_quest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import java.util.ArrayList;

public class NamelessQuest extends ApplicationAdapter {
	private TiledMap map;
	private Room myRoom;
	private TextureAtlas arrowsAtlas;
    private Skin arrowSkin;
    private Button bUp, bDown, bLeft, bRight;
    private Stage stage;
    WorldEntity mario;

	@Override
	public void create () {
        stage = new Stage(new StretchViewport(800, 500));
        stage.clear();
        Gdx.input.setInputProcessor(stage);

		map = new TmxMapLoader().load("testmap.tmx");
		Texture marioTexture = new Texture(Gdx.files.internal("mario.png"));
		mario = new WorldEntity(marioTexture);
		mario.setPosition(2, 6);
        mario.setSize(1, 1);
		myRoom = new Room(map);
        myRoom.addWorldEntity(mario);

        arrowsAtlas = new TextureAtlas(Gdx.files.internal("arrows.atlas"));
        arrowSkin = new Skin();
        arrowSkin.addRegions(arrowsAtlas);
        int aDistance = 70;

        Button.ButtonStyle upStyle = new Button.ButtonStyle();
        upStyle.up = arrowSkin.getDrawable("arrow-up-off");
        upStyle.down = arrowSkin.getDrawable("arrow-up-on");
        bUp = new Button(upStyle);
        bUp.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                up();
                return true;
            }
        });
        bUp.setPosition(aDistance, 2 * aDistance);
        stage.addActor(bUp);

        Button.ButtonStyle downStyle = new Button.ButtonStyle();
        downStyle.up = arrowSkin.getDrawable("arrow-down-off");
        downStyle.down = arrowSkin.getDrawable("arrow-down-on");
        bDown = new Button(downStyle);
        bDown.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                down();
                return true;
            }
        });
        bDown.setPosition(aDistance, 0);
        stage.addActor(bDown);

        Button.ButtonStyle leftStyle = new Button.ButtonStyle();
        leftStyle.up = arrowSkin.getDrawable("arrow-left-off");
        leftStyle.down = arrowSkin.getDrawable("arrow-left-on");
        bLeft = new Button(leftStyle);
        bLeft.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                left();
                return true;
            }
        });
        bLeft.setPosition(0, aDistance);
        stage.addActor(bLeft);

        Button.ButtonStyle rightStyle = new Button.ButtonStyle();
        rightStyle.up = arrowSkin.getDrawable("arrow-right-off");
        rightStyle.down = arrowSkin.getDrawable("arrow-right-on");
        bRight = new Button(rightStyle);
        bRight.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                right();
                return true;
            }
        });
        bRight.setPosition(2 * aDistance, aDistance);
        stage.addActor(bRight);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		myRoom.render();
        stage.act();
        stage.draw();
	}

    public void up() {
        if(mario.hasActions() == false)// !!!Později změnit podmínku!!!
            mario.addAction(Actions.moveTo(mario.getX(), mario.getY() + 1, mario.getSpeed()));
    }

    public void left() {
        if(mario.hasActions() == false)// !!!Později změnit podmínku!!!
            mario.addAction(Actions.moveTo(mario.getX() - 1, mario.getY(), mario.getSpeed()));
    }
    public void right() {
        if(mario.hasActions() == false)// !!!Později změnit podmínku!!!
            mario.addAction(Actions.moveTo(mario.getX() +  1, mario.getY(), mario.getSpeed()));
    }
    public void down() {
        if(mario.hasActions() == false)// !!!Později změnit podmínku!!!
            mario.addAction(Actions.moveTo(mario.getX(), mario.getY() - 1, mario.getSpeed()));
    }

	@Override
	public void dispose () {
		map.dispose();
        arrowSkin.dispose();
        arrowsAtlas.dispose();
        stage.dispose();
	}
}
