package com.viergewinnt.controller.creategame.network;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.viergewinnt.network.data.GameHosterData;

public class JoinNetworkGame implements ActionListener {
	
	private GameHosterData selectedServer;
	
	@Override
	public void actionPerformed(ActionEvent e) {
	}

	public GameHosterData getSelectedServer() {
		return selectedServer;
	}

	public void setSelectedServer(GameHosterData selectedServer) {
		this.selectedServer = selectedServer;
	}

}
