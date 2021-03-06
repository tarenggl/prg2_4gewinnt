package com.viergewinnt.ai;

import java.awt.Color;
import java.util.ArrayList;

import com.viergewinnt.gameobjects.GameProperties;
import com.viergewinnt.gameobjects.Player;
import com.viergewinnt.gameobjects.Stone;

public class Controller {
	private ArrayList<Stone> stoneList;
	private Player player1;
	private Player player2;
	private GameProperties game;
	private Stone winner;
	
	public Controller(int columns, int rows) {
		//GamePanel parameter is missing
		player1 = new Player(Color.RED);
		player2 = new Player(Color.YELLOW);
		game = new GameProperties(columns, rows);
		this.stoneList = game.getStoneList();
		winner = null;
	}
	
	public void startGame() {
		
		while(!gameFinished()) {
			
		}
	}
	
	public boolean gameFinished() {
		for(Stone s : stoneList) {
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
