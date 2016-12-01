package com.viergewinnt.gameobjects;

import java.awt.Color;

public class Stone {

	private Player player;
	private Color color;
	private int column;
	private int row;
	
	public Stone(Player player, Color color, int column, int row) {
		this.player = player;
		this.setColor(color);
		this.setColumn(column);
		this.setRow(row);
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}


	

	
}
