package com.viergewinnt.ai;

import java.awt.Color;
import java.util.Random;

import com.viergewinnt.gameobjects.GameProperties;
import com.viergewinnt.gameobjects.Player;

public class NetworkPlayer extends Player {

	GameProperties gameProperties;
	
	public NetworkPlayer(GameProperties gameProperties) {
		super(Color.RED);
	}

	@Override
	public int makeTurn() {
		return new Random().nextInt(gameProperties.getColumns()); 
	}
	
	
}
