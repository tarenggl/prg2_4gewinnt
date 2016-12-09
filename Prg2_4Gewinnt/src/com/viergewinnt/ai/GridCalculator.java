package com.viergewinnt.ai;

import java.awt.event.ActionEvent;

import com.viergewinnt.gameobjects.GameProperties;

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
}
