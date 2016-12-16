package com.viergewinnt.ai;

import java.awt.Color;
import java.util.Random;

import com.viergewinnt.gameobjects.GameProperties;
import com.viergewinnt.gameobjects.Player;

public class ComputerPlayer extends Player {

	private GameProperties gameProperties;
	private int depth = 4;
	
	public ComputerPlayer(GameProperties gameProperties) {
		super(Color.RED, "Computer");
		this.gameProperties = gameProperties;
	}

	@Override
	public int makeTurn() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Random().nextInt(gameProperties.getColumns())+1; 
	}
	
	public int max() {
		int maxValue = -100;
		generateMove();
		
		return 1;
	}
	
	public int generateMove(){
		
		return new Random().nextInt(gameProperties.getColumns())+1;
	}
	
}
