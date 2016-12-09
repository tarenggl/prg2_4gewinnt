package com.viergewinnt.gameobjects;

import java.awt.Color;

public abstract class Player {
	private Color color;
	
	public Player(Color color) {
		this.color = color;
	}
	
	public abstract int makeTurn();
}
