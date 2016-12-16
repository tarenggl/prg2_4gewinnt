package com.viergewinnt.ai;

import java.util.ArrayList;

import com.viergewinnt.gameobjects.GameProperties;
import com.viergewinnt.gameobjects.Stone;

public class GridCalculator {	
	
	public static double getColSize(GameProperties game) {
		return (game.getGridwidth()/game.getColumns());
	}
	
	public static double getRowSize(GameProperties game) {
		return (game.getGridheight()/game.getRows()+1);
	}
	
	public static double getStoneXPositionAt(GameProperties game, int col) {
		return ((game.getGridwidth()/game.getColumns())*col - (game.getGridwidth()/game.getColumns())*3/4);
	}
	
	public static double getStoneYPositionAt(GameProperties game, int row) {
		return  (((game.getGridheight()/(game.getRows()+1))*(game.getRows() - row + 1) - (game.getGridheight()/(game.getRows()+1))*3/4) + game.getGridheight()/(game.getRows()+1));
	}
	
	public static int getActiveColumn(GameProperties game, int x) {
		int activeStoneCol = 0;
		for(int i = 1 ;  i <= game.getColumns(); i++) {
			if(x <= (game.getGridwidth()/game.getColumns())*i) {
				activeStoneCol = i;
				break;
			}
		}
		return activeStoneCol;
	}
	

	
	public static ArrayList<Stone> horizontalWin(GameProperties game, Stone stone) {
		ArrayList<Stone> winningList = new ArrayList<>();
		winningList.add(stone);
		int row = stone.getRow();
		int column = stone.getColumn();
		Stone currentStone;
		for(int i = column+1; i <= column + 3; i++){
			currentStone = game.getStoneAt(i, row);
			winningList.add(currentStone);
			if(currentStone == null || currentStone.getColor() != stone.getColor()) {
				winningList.clear();
				return winningList;
			}
		}
		return winningList;
	}
	
	public static ArrayList<Stone> verticalWin(GameProperties game, Stone stone) {
		ArrayList<Stone> winningList = new ArrayList<>();
		winningList.add(stone);
		int row = stone.getRow();
		int column = stone.getColumn();
		Stone currentStone;
		
		for(int i = row + 1; i <= row + 3; i++) {
			currentStone = game.getStoneAt(column, i);
			winningList.add(currentStone);
			if(currentStone == null || currentStone.getColor() != stone.getColor()) {
				winningList.clear();
				return winningList;
			}
		}
		return winningList;
	}
	
	public static ArrayList<Stone> diagonalLeftWin(GameProperties game, Stone stone) {
		ArrayList<Stone> winningList = new ArrayList<>();
		winningList.add(stone);
		int row = stone.getRow();
		int column = stone.getColumn();
		Stone currentStone;
		for(int i = 1; i <= 3; i++) {
			currentStone = game.getStoneAt(column-i, row+i);
			winningList.add(currentStone);
			if(currentStone == null || currentStone.getColor() != stone.getColor()) {
				winningList.clear();
				return winningList;
			}
		}
		return winningList;
	}
	
	public static ArrayList<Stone> diagonalRightWin(GameProperties game, Stone stone) {
		ArrayList<Stone> winningList = new ArrayList<>();
		winningList.add(stone);
		int row = stone.getRow();
		int column = stone.getColumn();
		Stone currentStone;
		for(int i = 1; i <= 3; i++) {
			currentStone = game.getStoneAt(column+i, row+i);
			winningList.add(currentStone);
			if(currentStone == null || currentStone.getColor() != stone.getColor()) {
				winningList.clear();
				return winningList;
			}
		}
		return winningList;
	}	
	
	public static ArrayList<Stone> getWinningStones(GameProperties game) {
		ArrayList<Stone> winningStones = new ArrayList<>();
		for(Stone s: game.getStoneList()) {
			winningStones = diagonalLeftWin(game, s);
			if(winningStones.size() > 0)
				break;
			winningStones = diagonalRightWin(game, s);
			if(winningStones.size() > 0)
				break;
			winningStones = verticalWin(game, s);
			if(winningStones.size() > 0)
				break;
			winningStones = horizontalWin(game, s);
			if(winningStones.size() > 0)
				break;
		}
		return winningStones;		
	}
}
