package com.viergewinnt.gameobjects;

import java.awt.Color;
import java.io.Serializable;

public abstract class Player implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color color;
	protected int columnSelection;
	private String name;
	
	
	public Player(Color color, String name) {
		this.color = color;
		columnSelection = 0;
		this.name = name;
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

	public void notifyTurn(int column) {
		
	}	
}
