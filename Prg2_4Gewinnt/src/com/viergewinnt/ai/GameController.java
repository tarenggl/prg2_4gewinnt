package com.viergewinnt.ai;

import com.viergewinnt.gameobjects.GameProperties;
import com.viergewinnt.gameobjects.Player;
import com.viergewinnt.gameobjects.Stone;

public class GameController implements Runnable{
	private Player player1;
	private Player player2;
	private GameProperties game;
	private Stone winner;
	
	public GameController(GameProperties properties, Player player, Player oponent) {
		player1 = player;
		player2 = oponent;
		game = properties;
		winner = null;
	}
	
	@Override
	public void run() {
		game.setActivePlayer(player1);
		while(!gameFinished()) {
			try {
				int column = game.getActivePlayer().makeTurn();
				game.addStone(column);			
				switchPlayer();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}
	}
	
	private void switchPlayer() {
		if(game.getActivePlayer() == player1)
			game.setActivePlayer(player2);
		else
			game.setActivePlayer(player1);
	}
	
	public boolean gameFinished() {
		for(Stone s : game.getStoneList()) {
			if(verticalWin(s) || horizontalWin(s) || diagonalLeftWin(s) || diagonalRightWin(s)) {
				winner = s;
				return true;
			}
		}
		return false;
		
	}
	
	public boolean horizontalWin(Stone stone) {
		int row = stone.getRow();
		int column = stone.getColumn();
		Stone currentStone;
		for(int i = column+1; i <= column + 3; i++){
			currentStone = game.getStoneAt(i, row);
			if(currentStone == null || currentStone.getColor() != stone.getColor()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean verticalWin(Stone stone) {
		int row = stone.getRow();
		int column = stone.getColumn();
		Stone currentStone;
		
		for(int i = row + 1; i <= row + 3; i++) {
			currentStone = game.getStoneAt(column, i);
			if(currentStone == null || currentStone.getColor() != stone.getColor()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean diagonalLeftWin(Stone stone) {
		int row = stone.getRow();
		int column = stone.getColumn();
		Stone currentStone;
		for(int i = 1; i <= 3; i++) {
			currentStone = game.getStoneAt(column-i, row+i);
			if(currentStone == null || currentStone.getColor() != stone.getColor()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean diagonalRightWin(Stone stone) {
		int row = stone.getRow();
		int column = stone.getColumn();
		Stone currentStone;
		for(int i = 1; i <= 3; i++) {
			currentStone = game.getStoneAt(column+i, row+i);
			if(currentStone == null || currentStone.getColor() != stone.getColor()) {
				return false;
			}
		}
		return true;
	}
	
	
	
	
	public void play(){
		
	}
}
