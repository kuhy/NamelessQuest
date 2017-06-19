package com.kuhy.nameless_quest.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.kuhy.nameless_quest.game.RoomManager;

/**
 * Created by Kuhy on 9.6.2017.
 */

public abstract class WorldEntity extends Actor {
    private Sprite sprite;
    private float speed;
    private Direction direction = null;
    private static RoomManager roomManager;

    public WorldEntity(String textureLocation) {
        Texture texture = new Texture(Gdx.files.internal(textureLocation));
        sprite = new Sprite(texture);
        speed = 0.5f;
    }

    static public void setRoomManager(RoomManager roomManager) {
        WorldEntity.roomManager = roomManager;
    }

    @Override
    public void draw (Batch batch, float parentAlpha) {
        sprite.setPosition(getX(), getY());
        sprite.draw(batch, parentAlpha);
    }

    @Override
    public void setSize(float width, float height) {
        super.setSize(width, height);
        sprite.setSize(width, height);
    }

    public void move(Direction direction) {
        if(roomManager.moveWorldEntity(this, direction))
            this.direction = direction;
    }

    public boolean isMoving() {
        if(direction == null)
            return  false;
        else
            return  true;
    }

    public void stoppedMoving() {
        this.direction = null;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public enum Direction {up, down, left, right}
}