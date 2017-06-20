package com.kuhy.nameless_quest.game;

import com.badlogic.gdx.Gdx;
import com.kuhy.nameless_quest.game.entities.Player;
import com.kuhy.nameless_quest.game.entities.WorldEntity;
import com.kuhy.nameless_quest.states.State;

/**
 * Created by Kuhy on 15.6.2017.
 */

public class GameState implements State {
    Room room;
    GameUI gameUI;

    @Override
    public void onEnter() {
        room = new Room("testmap.tmx");
        RoomManager roomManager = new RoomManager(room);
        WorldEntity.setRoomManager(roomManager);
        Player player = new Player("mario.png");
        player.setPosition(2, 6);
        player.setSize(1, 1);
        room.addActor(player);
        gameUI = new GameUI(player);
        gameUI.onEnter();
    }

    @Override
    public void onResume() {
        Gdx.input.setInputProcessor(gameUI);
    }

    @Override
    public void onPause() {

    }

    @Override
    public void update(float elapsedTime) {
        gameUI.act();
        room.act();
    }

    @Override
    public void render() {
        room.draw();
        gameUI.draw();
    }

    @Override
    public void onExit() {
        room.onExit();
        gameUI.onExit();
    }
}
