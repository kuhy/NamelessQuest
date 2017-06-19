package com.kuhy.nameless_quest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.kuhy.nameless_quest.game.GameState;
import com.kuhy.nameless_quest.states.StateMachine;


public class NamelessQuest extends ApplicationAdapter {
	private StateMachine stateMachine;

	@Override
	public void create () {
		GameState gameState = new GameState();
        stateMachine = new StateMachine("game", gameState);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateMachine.update(Gdx.graphics.getDeltaTime());
        stateMachine.render();
	}

	@Override
	public void dispose () {
		stateMachine.onExit();
	}
}
