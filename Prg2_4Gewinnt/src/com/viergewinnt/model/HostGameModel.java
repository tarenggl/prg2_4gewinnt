package com.viergewinnt.model;

import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class HostGameModel {

	
	private JTextField gameName;
	private ActionListener startServer;

	public ActionListener getStartServer() {
		return startServer;
	}

	public void setStartServer(ActionListener startServer) {
		this.startServer = startServer;
	}

	public JTextField getGameName() {
		return gameName;
	}

	public void setGameName(JTextField gameName) {
		this.gameName = gameName;
	}
	
}
