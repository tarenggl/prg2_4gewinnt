package com.viergewinnt.controller.creategame.network;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import javax.swing.JTextField;

import com.viergewinnt.controller.playgame.PlayNetworkGameController;
import com.viergewinnt.network.NetworkDatagramHelper;
import com.viergewinnt.network.data.GameHosterData;

public class HostNetworkGameAction implements ActionListener {

	private JTextField gameName;
	private PlayNetworkGameController networkGameController;
	
	public HostNetworkGameAction(JTextField gameName, PlayNetworkGameController networkGameController) {
		this.gameName = gameName; 
		this.networkGameController = networkGameController;
	}
	
	private boolean udpServerStarted = false;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(udpServerStarted)
			return;
		Thread serverThread = new Thread(new Runnable() {

			@Override
			public void run() {
				udpServerStarted = true;
				try {
					DatagramSocket serverDatagrammsocket = new DatagramSocket(12345);
					byte[] byteBuffer = new byte[1024];
					DatagramPacket recievedRequest = new DatagramPacket(byteBuffer, 1024);
					GameHosterData gameHoster = new GameHosterData(gameName.getText(), InetAddress.getLocalHost().getHostAddress(), 12344);
					System.out.println("Server starts listening");
					serverDatagrammsocket.receive(recievedRequest);
					String received = new String(recievedRequest.getData());
					System.out.println("Client requestMessage: " + received);
					NetworkDatagramHelper.send(gameHoster, serverDatagrammsocket, recievedRequest);
					networkGameController.show();
				} catch (SocketException ex) {
					ex.printStackTrace();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				udpServerStarted = false;
			}
		});
		serverThread.start();
	}

}
