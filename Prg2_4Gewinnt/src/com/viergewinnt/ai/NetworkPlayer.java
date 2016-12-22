package com.viergewinnt.ai;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.viergewinnt.gameobjects.GameProperties;
import com.viergewinnt.gameobjects.Player;

public class NetworkPlayer extends Player {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GameProperties gameProperties;
	private Socket client;	
	
	public NetworkPlayer(GameProperties gameProperties, String name, Socket client) {
		super(Color.RED, name);
		this.client = client;
	}

	@Override
	public int makeTurn() {
		try {
			ObjectInputStream input = new ObjectInputStream(client.getInputStream());
			Integer turn = (Integer)input.readObject();
			return turn.intValue();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public void notifyTurn(int column) {
		try {
			ObjectOutputStream clientOut = new ObjectOutputStream(client.getOutputStream());
			clientOut.writeObject(new Integer(column));
			clientOut.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
