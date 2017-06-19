package com.kuhy.nameless_quest.game;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;

/**
 * Created by Kuhy on 9.6.2017.
 */

public class OrthogonalTiledMapRendererWithSprites extends OrthogonalTiledMapRenderer {
    private Stage worldEntities;
    private int drawSpritesAfterLayer = 2;

    public OrthogonalTiledMapRendererWithSprites(TiledMap map) {
        super(map, 1 / (float)map.getTileSets().getTile(1).getTextureRegion().getRegionHeight());
        worldEntities = new Stage();
    }

    public void setWorldEntities(Stage worldEntities) {
        this.worldEntities = worldEntities;
    }

    @Override
    public void render() {
        beginRender();
        int currentLayer = 0;
        for (MapLayer layer : map.getLayers()) {
            if (layer.isVisible()) {
                if (layer instanceof TiledMapTileLayer) {
                    renderTileLayer((TiledMapTileLayer)layer);
                    currentLayer++;
                    if(currentLayer == drawSpritesAfterLayer){
                        for(Actor actor: worldEntities.getActors())
                            actor.draw(batch, 1f);
                    }
                } else {
                    for (MapObject object : layer.getObjects()) {
                        renderObject(object);
                    }
                }
            }
        }
        endRender();
    }
}
