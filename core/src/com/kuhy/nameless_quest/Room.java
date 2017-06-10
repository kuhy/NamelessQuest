package com.kuhy.nameless_quest;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;

/**
 * Created by Kuhy on 9.6.2017.
 */

public class Room {
    OrthographicCamera camera;
    private TiledMap map;
    private OrthogonalTiledMapRendererWithSprites renderer;
    private Stage worldEntities;

    public Room(TiledMap map) {
        this.map = map;
        camera = new OrthographicCamera();
        configureCamera();
        worldEntities = new Stage(new FitViewport(25, 15, camera));
        renderer = new OrthogonalTiledMapRendererWithSprites(map);
        renderer.setWorldEntities(worldEntities);
    }

    public void addWorldEntity(WorldEntity worldEntity) {
        worldEntities.addActor(worldEntity);
    }

    public void render() {
        worldEntities.act();
        camera.update();
        renderer.setView(camera);
        renderer.render();
    }

    private void configureCamera() {
        camera.setToOrtho(false, 25, 15);
    }
}
