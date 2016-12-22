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
		if (opponentWinCol() > gameProperties.getColumns() || opponentWinCol() < 1) {
			System.out.println("RANDOM MOVE!!!");
			return generateMove();
		}else {
			return opponentWinCol();
		}
	}
	
	public int opponentWinCol() {
		
		for(Stone s : gameProperties.getStoneList()) {
			if (s.getColor() == Color.YELLOW) {
					if( horizontalRightWin(s)) {
						if(gameProperties.getStoneAt(s.getColumn()+3,s.getRow()) != null){
							return 0;
						}else {
							return s.getColumn()+3;
						}
					}else if(verticalWin(s)){
						if(gameProperties.getStoneAt(s.getColumn(),s.getRow()+3) != null){
							return 0;
						}else {
							return s.getColumn();
						}
					}else if(diagonalLeftWin(s)) {
						if(gameProperties.getStoneAt(s.getColumn()-3, s.getRow()+2) == null) {
							return 0;
						}else if(gameProperties.getStoneAt(s.getColumn()-3, s.getRow()+3) != null){
							return 0;
						}else {
							return (s.getColumn() - 3);
						}
					}else if(diagonalRightWin(s)) {
						if(gameProperties.getStoneAt(s.getColumn()+3, s.getRow()+2) == null) {
							return 0;
						}else if(gameProperties.getStoneAt(s.getColumn()+3, s.getRow()+3) != null){
							return 0;
						}else {
							return (s.getColumn() + 3);
						}
					}
				return 0;
			}
		}
		return 0;
	}
	
	public int generateMove(){
		
 		return new Random().nextInt(gameProperties.getColumns())+1;
	}
	
	public boolean horizontalRightWin(Stone stone) {
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
	
	public boolean horizontalLeftWin(Stone stone) {
		int row = stone.getRow();
		int column = stone.getColumn();
		Stone currentStone;
		for(int i = column-1; i <= column - 2; i--){
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
		for(int i = 1; i <= 2; i++) {
			currentStone = gameProperties.getStoneAt(column+i, row+i);
			if(currentStone == null || currentStone.getColor() != stone.getColor()) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void notifyTurn(int column) {
		
	}
	
}
