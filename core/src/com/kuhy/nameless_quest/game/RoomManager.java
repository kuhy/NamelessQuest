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
                worldEntity.addAction(sequence(Actions.moveTo(worldEntity.getX(), worldEntity.getY() + 1, worldEntity.getSpeed()), run(new Runnable() {
                    public void run () {
                        worldEntity.stoppedMoving();
                    }
                })));
                break;
            case down:
                worldEntity.addAction(sequence(Actions.moveTo(worldEntity.getX(), worldEntity.getY() - 1, worldEntity.getSpeed()), run(new Runnable() {
                    public void run () {
                        worldEntity.stoppedMoving();
                    }
                })));
                break;
            case left:
                worldEntity.addAction(sequence(Actions.moveTo(worldEntity.getX() - 1, worldEntity.getY(), worldEntity.getSpeed()), run(new Runnable() {
                    public void run () {
                        worldEntity.stoppedMoving();
                    }
                })));
                break;
            case right:
                worldEntity.addAction(sequence(Actions.moveTo(worldEntity.getX() + 1, worldEntity.getY(), worldEntity.getSpeed()), run(new Runnable() {
                    public void run () {
                        worldEntity.stoppedMoving();
                    }
                })));
                break;
        }
        return true;
    }
}
