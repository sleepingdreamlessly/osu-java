package com.sleepingdreamlessly.osu;

import com.sleepingdreamlessly.osu.graphics.GameCamera;
import com.sleepingdreamlessly.osu.input.InputManager;

public class Handler
{
	private Game game;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	
	public InputManager getInputManager() {
		return game.getInputManager();
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public Game getGame() {
		return game;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
}
