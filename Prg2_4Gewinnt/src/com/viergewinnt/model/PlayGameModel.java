package com.viergewinnt.model;

import java.awt.event.MouseListener;

import com.viergewinnt.gameobjects.GameProperties;

public class PlayGameModel {

	private GameProperties gameProperties;
	private MouseListener stonepressed;

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
	
}
