package com.viergewinnt.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import com.viergewinnt.network.data.GameHoster;

public class FindHoster {

	public List<GameHoster> searchForHostedGames() {
		List<GameHoster> foundServers = new ArrayList<>();
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
					GameHoster gameHostInfo = (GameHoster) serverAnswer;
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
