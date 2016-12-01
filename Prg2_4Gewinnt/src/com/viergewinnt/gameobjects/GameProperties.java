package com.viergewinnt.gameobjects;

import java.util.ArrayList;

public class GameProperties {
	
	private int columns;
	private int rows;
	private ArrayList<Stone> stoneList;
	
	
	public GameProperties(int columns, int rows) {
		this.columns = columns < 5 ? 5 : columns;
		this.rows = rows < 5 ? 5 : rows;
		stoneList = new ArrayList<>(this.columns*this.rows);
	}
	
	public ArrayList<Stone> getStoneList(){
		return this.stoneList;
	}
	
}
