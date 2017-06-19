package com.kuhy.nameless_quest.game;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.kuhy.nameless_quest.game.entities.WorldEntity;

/**
 * Created by Kuhy on 18.6.2017.
 */

public class RoomManager {
    private Room room;

    public RoomManager(Room room) {
        this.room = room;
    }

    public boolean moveWorldEntity(WorldEntity worldEntity, WorldEntity.Direction direction) {
        if(worldEntity.isMoving())
            return false;
        switch (direction) {
            case up:
                worldEntity.addAction(Actions.moveTo(worldEntity.getX(), worldEntity.getY() + 1, worldEntity.getSpeed()));
                break;
            case down:
                worldEntity.addAction(Actions.moveTo(worldEntity.getX(), worldEntity.getY() - 1, worldEntity.getSpeed()));
                break;
            case left:
                worldEntity.addAction(Actions.moveTo(worldEntity.getX() - 1, worldEntity.getY(), worldEntity.getSpeed()));
                break;
            case right:
                worldEntity.addAction(Actions.moveTo(worldEntity.getX() + 1, worldEntity.getY(), worldEntity.getSpeed()));
                break;
        }
        return true;
    }
}
