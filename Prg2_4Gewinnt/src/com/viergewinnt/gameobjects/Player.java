package com.viergewinnt.gameobjects;

import java.awt.Color;

public abstract class Player {
	private Color color;
	protected int columnSelection;
	
	
	public Player(Color color) {
		this.color = color;
		columnSelection = 0;
	}
	
	public abstract int makeTurn();

	public Color getColor() {
		return color;
	}
	
	public void makeColSelection(int col) {
		columnSelection = col;
	}	
}
