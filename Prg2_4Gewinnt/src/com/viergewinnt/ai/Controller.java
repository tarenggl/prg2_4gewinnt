package com.viergewinnt.ai;

import java.util.ArrayList;

import com.viergewinnt.gameobjects.GameProperties;
import com.viergewinnt.gameobjects.Player;
import com.viergewinnt.gameobjects.Stone;

public class Controller {
	private ArrayList<Stone> stoneList;
	private Player player1;
	private Player player2;
	private GameProperties game;
	
	public Controller(ArrayList<Stone> stoneList, Player player1, Player player2, GameProperties game) {
		this.stoneList = stoneList;
		this.player1 = player1;
		this.player2 = player2;		
		this.game = game;
	}
	
	public void startGame() {
		while(!gameFinished()) {
						
		}
	}
	
	public boolean gameFinished() {
		return true;
		
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
	
	public boolean diagonalLeftWin() {
		return true;
		
	}
	
	public boolean diagonalRightWin() {
		return true;
	}
	
	
	
	
	public void play(){
		
	}
}
