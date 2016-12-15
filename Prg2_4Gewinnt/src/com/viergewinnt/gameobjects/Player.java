package com.viergewinnt.gameobjects;

import java.awt.Color;

public abstract class Player {
	private Color color;
	protected int columnSelection;
	private String name;
	
	
	public Player(Color color, String name) {
		this.color = color;
		columnSelection = 0;
		this.name = name;
		name = "";
	}
	
	public abstract int makeTurn();

	public Color getColor() {
		return color;
	}
	
	public String getName() {
		return name;
	}
	
	public void makeColSelection(int col) {
		columnSelection = col;
	}	
}
