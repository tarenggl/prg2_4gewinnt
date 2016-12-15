package com.viergewinnt.controller.playgame;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.viergewinnt.ai.ComputerPlayer;
import com.viergewinnt.ai.GameController;
import com.viergewinnt.ai.NetworkPlayer;
import com.viergewinnt.controller.base.DrawableController;
import com.viergewinnt.controller.base.PlayGameController;
import com.viergewinnt.gameobjects.GameProperties;
import com.viergewinnt.gameobjects.Player;
import com.viergewinnt.gui.GameFrame;
import com.viergewinnt.network.data.GameHosterData;

public class PlayNetworkGameController extends PlayGameController implements DrawableController{

	private GameFrame frame;
	private GameHosterData gameHoster;

	public PlayNetworkGameController(GameFrame gameFrame, GameHosterData gameHoster) {
		frame = gameFrame;
		this.gameHoster = gameHoster;
	}
	
	public void show() {
		
		GameController game = new GameController(model.getGameProperties(), localPlayer, new ComputerPlayer(model.getGameProperties()));
		model.setGameController(game);
		view.start();
		Thread td = new Thread(game);
		td.start();
	}
	
	public void start() {
		
		ServerSocket serverSocket = new ServerSocket(12344);
		
		try {
			Socket client = serverSocket.accept();
			ObjectInputStream clientObjectInput = new ObjectInputStream(BufferedReader(new InputStreamReader(client.getInputStream())));
			Player clientPlayer = (Player)clientObjectInput.readObject();
			NetworkPlayer networkPlayer = new NetworkPlayer(model.getGameProperties(), clientPlayer.getName(), client, serverSocket);
			GameController game = new GameController(model.getGameProperties(), model., oponent)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
