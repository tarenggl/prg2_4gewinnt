package com.viergewinnt.gameobjects;

import java.awt.Color;
import java.util.ArrayList;

import com.viergewinnt.ai.StoneMovement;

public class GameProperties {
	
	private int columns;
	private int rows;
	private ArrayList<Stone> stoneList;
	private int gridwidth;
	private int gridheight;
	private Player activePlayer;
	
	
	public GameProperties(int columns, int rows) {
		this.setColumns(columns < 5 ? 5 : columns);
		this.setRows(rows < 5 ? 5 : rows);
		stoneList = new ArrayList<>(this.getColumns()*this.getRows());
		activePlayer = new Player(Color.red);
	}
	
	public ArrayList<Stone> getStoneList(){
		return this.stoneList;
	}
	
	public Stone getStoneAt(int column, int row) {
		for(Stone s : stoneList) {
			if (s.getRow() == row) {
				if (s.getColumn() == column) {
					return s;
				}
			}
		}
		
		return null;
	}
	
	public void addStone(int column) throws ArrayIndexOutOfBoundsException {
		if(columnIsFull(column)) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Stone s = new Stone(activePlayer, activePlayer.getColor(), column, getFreeRow(column));
		StoneMovement move = new StoneMovement(s, this);
		move.start();
		stoneList.add(s);
	}
	
	private boolean columnIsFull(int col) {
		return (getFreeRow(col) > rows);
	}
	
	private int getFreeRow(int col) {
		int currentRow = 1;
		for(Stone s : stoneList) {
			currentRow = s.getColumn() == col ? ++currentRow : currentRow;
		}
		return currentRow;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getGridwidth() {
		return gridwidth;
	}

	public void setGridwidth(int gridwidth) {
		this.gridwidth = gridwidth;
	}

	public int getGridheight() {
		return gridheight;
	}

	public void setGridheight(int gridheight) {
		this.gridheight = gridheight;
	}
	
}
