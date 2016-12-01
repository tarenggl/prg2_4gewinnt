package com.viergewinnt.start;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;

import com.viergewinnt.gui.GameFrame;
import com.viergewinnt.network.GameHoster;
import com.viergewinnt.network.NetworkHelper;

public class StartUp {
	public static void main(String[] args) {
		new GameFrame();
		Thread serverThread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					DatagramSocket serverDatagrammsocket = new DatagramSocket(12345);
					byte[] byteBuffer = new byte[1024];
					DatagramPacket recievedRequest = new DatagramPacket(byteBuffer, 1024);
					GameHoster gameHoster = new GameHoster("Spiel von Alois", InetAddress.getLocalHost().getHostAddress());
					for (int i = 0; i < 5; i++) {
						System.out.println("Server starts listening");
						serverDatagrammsocket.receive(recievedRequest);
						String received = new String(recievedRequest.getData());
						System.out.println("Client requestMessage: " + received);
						NetworkHelper.send(gameHoster, serverDatagrammsocket, recievedRequest);
					}
				} catch (SocketException ex) {
					ex.printStackTrace();
				} catch (IOException ex) {
					ex.printStackTrace();
				}

			}
		});
		serverThread.start();

		try {
			DatagramSocket clientSocket = new DatagramSocket();
			byte[] requestMessage = "Hello you listening?".getBytes();
			DatagramPacket initialRequest = new DatagramPacket(requestMessage, requestMessage.length,
					new InetSocketAddress("255.255.255.255", 12345));
			for (int i = 0; i < 5; i++) {
				try {
					System.out.println("Client sends Broadcast:");
					clientSocket.send(initialRequest);
					Object serverAnswer = NetworkHelper.read(clientSocket);
					try {
						GameHoster gameHostInfo = (GameHoster)serverAnswer;
						System.out.println("Someone replied: " + gameHostInfo.getGameName() + "  -- " + gameHostInfo.getHostAddress());
					} catch(Exception ex) {
						ex.printStackTrace();
					}
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
