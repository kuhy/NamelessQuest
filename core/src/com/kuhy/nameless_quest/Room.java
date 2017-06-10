package com.kuhy.nameless_quest;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;

import java.util.ArrayList;

/**
 * Created by Kuhy on 9.6.2017.
 */

public class Room {
    OrthographicCamera camera;
    private TiledMap map;
    private OrthogonalTiledMapRendererWithSprites renderer;
    private ArrayList<WorldEntity> worldEntities;

    public Room(TiledMap map, ArrayList<WorldEntity> worldEntities) {
        this.map = map;
        this.worldEntities = worldEntities;
        camera = new OrthographicCamera();
        configureCamera();
        renderer = new OrthogonalTiledMapRendererWithSprites(map);
        renderer.setSprites(worldEntities);
    }

    public void render() {
        camera.update();
        renderer.setView(camera);
        renderer.render();
    }

    private void configureCamera() {
        camera.setToOrtho(false, 25, 15);
    }
}
