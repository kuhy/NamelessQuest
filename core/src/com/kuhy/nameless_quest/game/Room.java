package com.kuhy.nameless_quest.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;


/**
 * Created by Kuhy on 9.6.2017.
 */

public class Room extends Stage{
    private TiledMap map;
    private OrthogonalTiledMapRendererWithSprites renderer;
    private OrthographicCamera camera;

    public Room(String mapLocation) {
        super(new FitViewport(25, 15, new OrthographicCamera()));
        camera = (OrthographicCamera) getCamera();
        map = new TmxMapLoader().load(mapLocation);
        configureCamera();
        renderer = new OrthogonalTiledMapRendererWithSprites(map);
        renderer.setWorldEntities(this);
    }

    @Override
    public void draw() {
        camera.update();
        renderer.setView(camera);
        renderer.render();
    }

    private void configureCamera() {
        camera.setToOrtho(false, 25, 15);
    }

    public void onExit() {
        dispose();
    }

    @Override
    public void dispose() {
        super.dispose();
        map.dispose();
        renderer.dispose();
    }
}
