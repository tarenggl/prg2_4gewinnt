package com.viergewinnt.controller.creategame.network;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

import com.viergewinnt.controller.playgame.PlayNetworkGameController;
import com.viergewinnt.gui.dialog.ChooseGamePropertyDialog;
import com.viergewinnt.network.data.GameHosterData;

public class JoinNetworkGameAction implements ActionListener {
	
	private JList<GameHosterData> hosterList;
	private PlayNetworkGameController playNetworkGame;
	
	public JoinNetworkGameAction(JList<GameHosterData> gameHoster, PlayNetworkGameController playNetworkGame) {
		hosterList = gameHoster;
		this.playNetworkGame = playNetworkGame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		playNetworkGame.setGameHoster(hosterList.getSelectedValue());
		playNetworkGame.show();
	}

	public GameHosterData getSelectedServer() {
		return hosterList.getSelectedValue();
	}

}
