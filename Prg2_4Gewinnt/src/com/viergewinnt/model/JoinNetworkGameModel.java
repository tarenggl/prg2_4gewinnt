package com.viergewinnt.model;

import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;

import com.viergewinnt.controller.creategame.network.JoinNetworkGame;
import com.viergewinnt.network.data.GameHosterData;

public class JoinNetworkGameModel {

	private ActionListener searchGameHoster;
	private JoinNetworkGame joinNetworkGame;
	private DefaultListModel<GameHosterData> hoster;
	private JList<GameHosterData> hosterList;
	
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

	public JList<GameHosterData> getHosterList() {
		return hosterList;
	}

	public void setHosterList(JList<GameHosterData> hosterList) {
		this.hosterList = hosterList;
	}	
}
