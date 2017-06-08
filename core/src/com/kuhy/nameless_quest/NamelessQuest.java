package com.kuhy.nameless_quest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class NamelessQuest extends ApplicationAdapter {
	private float cameraWidth = 800;
	OrthographicCamera camera;
	private TiledMap map;
	private TiledMapRenderer renderer;
	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		configureCamera();
		map = new TmxMapLoader().load("testmap.tmx");
		renderer = new OrthogonalTiledMapRenderer(map);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		renderer.setView(camera);
		renderer.render();
	}

	private void configureCamera() {
		camera.setToOrtho(false, cameraWidth, cameraWidth * Gdx.graphics.getHeight() / Gdx.graphics.getWidth());
	}

	@Override
	public void dispose () {
		map.dispose();
	}
}
