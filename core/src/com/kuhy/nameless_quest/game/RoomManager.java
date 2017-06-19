package com.kuhy.nameless_quest.game;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.kuhy.nameless_quest.game.entities.WorldEntity;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

/**
 * Created by Kuhy on 18.6.2017.
 */

public class RoomManager {
    private Room room;

    public RoomManager(Room room) {
        this.room = room;
    }

    public boolean moveWorldEntity(final WorldEntity worldEntity, WorldEntity.Direction direction) {
        if(worldEntity.isMoving())
            return false;
        worldEntity.addAction(sequence(Actions.moveTo(worldEntity.getX() + direction.getX(), worldEntity.getY() + direction.getY(), worldEntity.getSpeed()), run(new Runnable() {
            public void run () {
                worldEntity.stoppedMoving();
            }
        })));
        return true;
    }
}
