package com.viergewinnt.gameobjects;

import java.awt.Color;

public class Player {
	private Color color;
	
	public Player(Color color) {
		this.setColor(color);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
