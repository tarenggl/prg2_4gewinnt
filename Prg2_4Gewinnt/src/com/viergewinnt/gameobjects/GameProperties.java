package com.viergewinnt.gameobjects;

import java.util.ArrayList;

public class GameProperties {
	
	private int columns;
	private int rows;
	private ArrayList<Stone> stoneList;
	
	
	public GameProperties(int columns, int rows) {
		this.setColumns(columns < 5 ? 5 : columns);
		this.setRows(rows < 5 ? 5 : rows);
		stoneList = new ArrayList<>(this.getColumns()*this.getRows());
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
	
}
