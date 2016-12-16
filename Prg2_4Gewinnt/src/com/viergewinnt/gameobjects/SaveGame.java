package com.viergewinnt.gameobjects;

import java.io.Serializable;

public class SaveGame implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GameProperties gameProperties;
	private Player player1;
	private Player player2;
	
	public SaveGame(GameProperties properties, Player player1, Player player2) {
		this.gameProperties = properties;
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public GameProperties getGameProperties() {
		return gameProperties;
	}
	public void setGameProperties(GameProperties gameProperties) {
		this.gameProperties = gameProperties;
	}
	public Player getPlayer1() {
		return player1;
	}
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	
}
