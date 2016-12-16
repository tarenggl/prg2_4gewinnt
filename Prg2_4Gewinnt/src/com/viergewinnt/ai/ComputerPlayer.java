package com.viergewinnt.ai;

import java.awt.Color;
import java.util.Random;

import com.viergewinnt.gameobjects.GameProperties;
import com.viergewinnt.gameobjects.Player;
import com.viergewinnt.gameobjects.Stone;

public class ComputerPlayer extends Player {

	private GameProperties gameProperties;
	private int depth = 4;

	private static final long serialVersionUID = 1L;
	
	public ComputerPlayer(GameProperties gameProperties) {
		super(Color.RED, "Computer");
		this.gameProperties = gameProperties;
	}

	@Override
	public int makeTurn() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Random().nextInt(gameProperties.getColumns())+1; 
	}
	
	public int oppnentWinCol() {
		if ( horizontalWin(gameProperties.getLastSetStone())) {
			return gameProperties.getLastSetStone().getColumn()+3;
		}else if(verticalWin(gameProperties.getLastSetStone())){
			return gameProperties.getLastSetStone().getColumn();
		}else if(diagonalLeftWin(gameProperties.getLastSetStone())) {
			return 1;
		}else if(diagonalRightWin(gameProperties.getLastSetStone())) {
			return 1;
		}
		return 1;
	}
	
	public int generateMove(){
		
		return new Random().nextInt(gameProperties.getColumns())+1;
	}
	
	public boolean horizontalWin(Stone stone) {
		int row = stone.getRow();
		int column = stone.getColumn();
		Stone currentStone;
		for(int i = column+1; i <= column + 2; i++){
			currentStone = gameProperties.getStoneAt(i, row);
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
		
		for(int i = row + 1; i <= row + 2; i++) {
			currentStone = gameProperties.getStoneAt(column, i);
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
		for(int i = 1; i <= 2; i++) {
			currentStone = gameProperties.getStoneAt(column-i, row+i);
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
			currentStone = gameProperties.getStoneAt(column+i, row+i);
			if(currentStone == null || currentStone.getColor() != stone.getColor()) {
				return false;
			}
		}
		return true;
	}
	
	
	
}
