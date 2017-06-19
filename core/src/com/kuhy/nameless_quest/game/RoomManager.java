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
        switch (direction) {
            case up:
                addMoveToAction(worldEntity, 0, 1);
                break;
            case down:
                addMoveToAction(worldEntity, 0, -1);
                break;
            case left:
                addMoveToAction(worldEntity, -1, 0);
                break;
            case right:
                addMoveToAction(worldEntity, 1, 0);
                break;
        }
        return true;
    }

    private void addMoveToAction(final WorldEntity worldEntity, int x, int y) {
        worldEntity.addAction(sequence(Actions.moveTo(worldEntity.getX() + x, worldEntity.getY() + y, worldEntity.getSpeed()), run(new Runnable() {
            public void run () {
                worldEntity.stoppedMoving();
            }
        })));
    }
}
