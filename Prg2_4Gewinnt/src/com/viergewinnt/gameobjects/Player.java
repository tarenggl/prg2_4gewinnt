package com.viergewinnt.gameobjects;

import java.awt.Color;

public abstract class Player {
	private Color color;
	protected int columnSelection;
	private String name;
	
	
	public Player(Color color) {
		this.color = color;
		columnSelection = 0;
		name = "";
	}
	
	public abstract int makeTurn();

	public Color getColor() {
		return color;
	}
	
	public void makeColSelection(int col) {
		columnSelection = col;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
}
