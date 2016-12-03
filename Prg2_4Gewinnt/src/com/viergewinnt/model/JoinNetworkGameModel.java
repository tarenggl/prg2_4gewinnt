package com.viergewinnt.model;

import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;

import com.viergewinnt.controller.creategame.network.JoinNetworkGame;
import com.viergewinnt.network.data.GameHosterData;

public class JoinNetworkGameModel {

	private ActionListener searchGameHoster;
	private JoinNetworkGame joinNetworkGame;
	private DefaultListModel<GameHosterData> hoster;
	
	public JoinNetworkGameModel() {
		setHoster(new DefaultListModel<GameHosterData>());
	}
	
	public ActionListener getSearchGameHoster() {
		return searchGameHoster;
	}

	public void setSearchGameHoster(ActionListener searchGameHoster) {
		this.searchGameHoster = searchGameHoster;
	}

	public JoinNetworkGame getJoinNetworkGame() {
		return joinNetworkGame;
	}

	public void setJoinNetworkGame(JoinNetworkGame joinNetworkGame) {
		this.joinNetworkGame = joinNetworkGame;
	}

	public DefaultListModel<GameHosterData> getHoster() {
		return hoster;
	}

	public void setHoster(DefaultListModel<GameHosterData> hoster) {
		this.hoster = hoster;
	}	
}
