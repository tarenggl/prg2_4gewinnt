package com.viergewinnt.gameobjects;

public class Stone {

	private Player player;
	private int column;
	private int row;
	
	public Stone(Player player, int column, int row) {
		this.player = player;
		this.column = column;
		this.row = row;
	}
}
