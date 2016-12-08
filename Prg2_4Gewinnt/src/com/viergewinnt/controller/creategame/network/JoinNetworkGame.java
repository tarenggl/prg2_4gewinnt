package com.viergewinnt.controller.creategame.network;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

import com.viergewinnt.gui.dialog.ChooseGamePropertyDialog;
import com.viergewinnt.network.data.GameHosterData;

public class JoinNetworkGame implements ActionListener {
	
	private JList<GameHosterData> hosterList;
	
	public JoinNetworkGame(JList<GameHosterData> gameHoster) {
		hosterList = gameHoster;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new ChooseGamePropertyDialog(null);
	}

	public GameHosterData getSelectedServer() {
		return hosterList.getSelectedValue();
	}

}
