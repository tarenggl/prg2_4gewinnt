package com.viergewinnt.ai;

import java.awt.Color;
import java.util.Random;

import com.viergewinnt.gameobjects.GameProperties;
import com.viergewinnt.gameobjects.Player;

public class ComputerPlayer extends Player {

	GameProperties gameProperties;
	
	public ComputerPlayer(GameProperties gameProperties) {
		super(Color.RED);
	}

	@Override
	public int makeTurn() {
		return new Random().nextInt(gameProperties.getColumns()); 
	}
	
	
}
