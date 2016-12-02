package com.viergewinnt.gui.panel.network;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.viergewinnt.network.NetworkHelper;
import com.viergewinnt.network.data.GameHoster;

public class HostGamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JTextField gameName;
	JButton hostGame;
	
	public HostGamePanel() {
		gameName = new JTextField();
		hostGame = new JButton("Spiel erstellen");
		add(gameName);
		add(hostGame);
		setBackground(Color.GRAY.brighter());
		initHostGameButton();
	}
	
	private void initHostGameButton() {
		hostGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
			}
		});

	}
}
