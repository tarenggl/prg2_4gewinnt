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
import com.viergewinnt.network.data.GameHosterData;

public class PlayNetworkGameController extends PlayGameController implements DrawableController{

	private GameHosterData gameHoster;

	public PlayNetworkGameController(GameFrame gameFrame, GameHosterData gameHoster) {
		super(gameFrame);
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
			startGame(localPlayer, networkPlayer);
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void startClient() {
		try {
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
			startGame(networkPlayer, localPlayer);
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
