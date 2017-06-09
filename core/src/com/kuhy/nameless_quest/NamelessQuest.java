package com.kuhy.nameless_quest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import java.util.ArrayList;

public class NamelessQuest extends ApplicationAdapter {
	private TiledMap map;
	private Room myRoom;

	@Override
	public void create () {
		map = new TmxMapLoader().load("testmap.tmx");
		Texture texture = new Texture(Gdx.files.internal("mario.png"));
		WorldEntity worldEntity = new WorldEntity(texture);
		ArrayList<WorldEntity> worldEntities = new ArrayList<WorldEntity>();
        worldEntity.setPosition(64, 192);
		worldEntities.add(worldEntity);
		myRoom = new Room(map, worldEntities);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		myRoom.render();
	}

	@Override
	public void dispose () {
		map.dispose();
	}
}
