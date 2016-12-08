package com.viergewinnt.gui.panel.network;

import java.awt.Color;
import java.awt.Font;
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

import com.viergewinnt.model.HostGameModel;
import com.viergewinnt.network.NetworkDatagramHelper;
import com.viergewinnt.network.data.GameHosterData;

public class HostGamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton hostGame;
	
	public HostGamePanel(HostGameModel model) {
		setLayout(null);
		model.getGameName().setBounds(30, 50, 250, 40);
		model.getGameName().setFont(new Font("Arial", Font.PLAIN, 30));
		hostGame = new JButton("Spiel erstellen");
		hostGame.setBounds(30, 160, 250, 40);
		hostGame.setFont(new Font("Arial", Font.PLAIN, 30));
		hostGame.addActionListener(model.getStartServer());
		add(model.getGameName());
		add(hostGame);
		setBackground(Color.GRAY.brighter());
	}
}
