package com.viergewinnt.controller.playgame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.viergewinnt.ai.LocalPlayer;
import com.viergewinnt.ai.NetworkPlayer;
import com.viergewinnt.controller.base.DrawableController;
import com.viergewinnt.controller.base.PlayGameController;
import com.viergewinnt.gameobjects.GameProperties;
import com.viergewinnt.gameobjects.Player;
import com.viergewinnt.gui.GameFrame;
import com.viergewinnt.gui.dialog.ChooseGamePropertyDialog;
import com.viergewinnt.gui.panel.network.JoinGameNameDialog;
import com.viergewinnt.network.data.GameHosterData;

public class PlayNetworkGameController extends PlayGameController implements DrawableController{

	private GameHosterData gameHoster;
	private GameFrame gameFrame;

	public PlayNetworkGameController(GameFrame gameFrame, GameHosterData gameHoster) {
		super(gameFrame);
		this.gameFrame = gameFrame;
		this.gameHoster = gameHoster;
	}
	
	public void setGameHoster(GameHosterData gameHosterData) {
		this.gameHoster = gameHosterData;
	}
	
	public void show() {
		if(gameHoster == null) {
			startServer();
		} else {
			startClient();
		}
	}
	
	public void startServer() {
		try {
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(12344);
			Socket client = serverSocket.accept();
			ObjectInputStream clientObjectInput = new ObjectInputStream(client.getInputStream());
			Player clientPlayer = (Player)clientObjectInput.readObject();
			ChooseGamePropertyDialog dialog = new ChooseGamePropertyDialog(model.getGameProperties(), frame);
			dialog.setVisible(true);
			Player localPlayer = new LocalPlayer(dialog.getPlayerName());
			ObjectOutputStream outputClient = new ObjectOutputStream(client.getOutputStream());
			outputClient.writeObject(model.getGameProperties());
			outputClient.flush();
			outputClient.writeObject(localPlayer);
			outputClient.flush();
			NetworkPlayer networkPlayer = new NetworkPlayer(model.getGameProperties(), clientPlayer.getName(), client);
			initializeModel(localPlayer, networkPlayer);
			startGame();			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void startClient() {
		try {
			JoinGameNameDialog playerName = new JoinGameNameDialog(gameFrame);
			playerName.setVisible(true);
			Socket client = new Socket(gameHoster.getHostAddress(), gameHoster.getGamePort());
			ObjectOutputStream outputClient = new ObjectOutputStream(client.getOutputStream());
			Player localPlayer = new LocalPlayer("Client");
			outputClient.writeObject(localPlayer);
			outputClient.flush();
			ObjectInputStream clientObjectInput = new ObjectInputStream(client.getInputStream());
			GameProperties hostGameProperties = (GameProperties)clientObjectInput.readObject();
			model.setGameProperties(hostGameProperties);			
			Player hostPlayer = (Player)clientObjectInput.readObject();
			NetworkPlayer networkPlayer = new NetworkPlayer(model.getGameProperties(), hostPlayer.getName(), client);
			initializeModel(networkPlayer, localPlayer);
			startGame();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
