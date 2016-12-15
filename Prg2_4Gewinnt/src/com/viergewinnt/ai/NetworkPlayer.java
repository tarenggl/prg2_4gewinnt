package com.viergewinnt.ai;

import java.awt.Color;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

import com.viergewinnt.gameobjects.GameProperties;
import com.viergewinnt.gameobjects.Player;

public class NetworkPlayer extends Player {

	GameProperties gameProperties;
	private ServerSocket server;
	private Socket client;
	
	
	public NetworkPlayer(GameProperties gameProperties, String name, Socket client, ServerSocket server) {
		super(Color.RED, name);
	}

	@Override
	public int makeTurn() {
		return new Random().nextInt(gameProperties.getColumns()); 
	}
	
	
}
