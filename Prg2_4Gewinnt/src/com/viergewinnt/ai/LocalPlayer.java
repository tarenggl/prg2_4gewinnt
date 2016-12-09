package com.viergewinnt.ai;

import java.awt.Color;
import java.util.Random;

import com.viergewinnt.gameobjects.GameProperties;
import com.viergewinnt.gameobjects.Player;

public class LocalPlayer extends Player {

	GameProperties gameProperties;
	
	public LocalPlayer(String name) {
		super(Color.YELLOW);
	}

	@Override
	public int makeTurn() {
		return new Random().nextInt(gameProperties.getColumns()); 
	}
	
	
}
