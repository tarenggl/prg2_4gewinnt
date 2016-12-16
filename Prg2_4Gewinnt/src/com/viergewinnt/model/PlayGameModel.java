package com.viergewinnt.model;

import java.awt.event.MouseListener;

import com.viergewinnt.ai.GameController;
import com.viergewinnt.gameobjects.GameProperties;
import com.viergewinnt.gameobjects.Player;

public class PlayGameModel {

	private GameProperties gameProperties;
	private MouseListener stonepressed;
	private GameController gameController;
	private Player player1;
	private Player player2;

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

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
}
