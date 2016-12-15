package com.viergewinnt.controller.creategame.network;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import com.viergewinnt.network.NetworkDatagramHelper;
import com.viergewinnt.network.data.GameHosterData;

public class SearchNetworkHoster implements ActionListener{

	DefaultListModel<GameHosterData> gameHoster;
	
	public SearchNetworkHoster(DefaultListModel<GameHosterData> gameHoster) {
		this.gameHoster = gameHoster;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gameHoster.clear();
		gameHoster.addElement(new GameHosterData("...", "", 0));
		Thread td = new Thread(new Runnable() {
			@Override
			public void run() {
				List<GameHosterData> foundHosts = searchForHostedGames();
				gameHoster.clear();
				if(foundHosts.size() == 0) {
					gameHoster.addElement(new GameHosterData("Nothing found", "", 0));
				}
				for (GameHosterData gameServerInfo : foundHosts) {
					gameHoster.addElement(gameServerInfo);
				}
			}
		});
		td.start();

	}
	
	public List<GameHosterData> searchForHostedGames() {
		List<GameHosterData> foundServers = new ArrayList<>();
		try {
			DatagramSocket clientSocket = new DatagramSocket();
			byte[] requestMessage = "Hello you listening?".getBytes();
			DatagramPacket initialRequest = new DatagramPacket(requestMessage, requestMessage.length,
					new InetSocketAddress("255.255.255.255", 12345));
			System.out.println("Client sends Broadcast:");
			clientSocket.send(initialRequest);
			clientSocket.setSoTimeout(1000);
			for (int i = 0; i < 4; i++) {
				try {
					Object serverAnswer = NetworkDatagramHelper.read(clientSocket);
					GameHosterData gameHostInfo = (GameHosterData) serverAnswer;
					foundServers.add(gameHostInfo);
				} catch (SocketTimeoutException ex) {
					System.out.println("No answer on on Broadcast. try " + i + "/3");
				} catch (Exception ex) {
					System.out.println("Received answor not parsable.");
					ex.printStackTrace();
				}
			}
		}  catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			System.out.println("Broeadcast konnte nicht gesendet werden.");
			ex.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return foundServers;
	}

	
}
