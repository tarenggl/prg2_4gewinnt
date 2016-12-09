package com.viergewinnt.model;

import java.awt.event.MouseListener;

import com.viergewinnt.ai.GameController;
import com.viergewinnt.gameobjects.GameProperties;

public class PlayGameModel {

	private GameProperties gameProperties;
	private MouseListener stonepressed;
	private GameController gameController;

	public GameProperties getGameProperties() {
		return gameProperties;
	}

	public void setGameProperties(GameProperties gameProperties) {
		this.gameProperties = gameProperties;
	}

	public MouseListener getStonepressed() {
		return stonepressed;
	}

	public void setStonepressed(MouseListener stonepressed) {
		this.stonepressed = stonepressed;
	}

	public GameController getGameController() {
		return gameController;
	}

	public void setGameController(GameController gameController) {
		this.gameController = gameController;
	}
	
}
