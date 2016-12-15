package com.viergewinnt.model;

import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListModel;

import com.viergewinnt.controller.creategame.network.JoinNetworkGameAction;
import com.viergewinnt.gui.GameFrame;
import com.viergewinnt.network.data.GameHosterData;

public class JoinNetworkGameModel {

	private ActionListener searchGameHoster;
	private JoinNetworkGameAction joinNetworkGame;
	private DefaultListModel<GameHosterData> hosterData;
	private JList<GameHosterData> hosterList;
	private GameFrame frame;
	
	public JoinNetworkGameModel(GameFrame owner) {
		hosterData = new DefaultListModel<>();
		frame = owner;
	}
	
	public ActionListener getSearchGameHoster() {
		return searchGameHoster;
	}

	public void setSearchGameHoster(ActionListener searchGameHoster) {
		this.searchGameHoster = searchGameHoster;
	}

	public JoinNetworkGameAction getJoinNetworkGame() {
		return joinNetworkGame;
	}

	public void setJoinNetworkGame(JoinNetworkGameAction joinNetworkGame) {
		this.joinNetworkGame = joinNetworkGame;
	}

	public DefaultListModel<GameHosterData> getHoster() {
		return hosterData;
	}

	public JList<GameHosterData> getHosterList() {
		return hosterList;
	}

	public void setHosterList(JList<GameHosterData> hosterList) {
		this.hosterList = hosterList;
	}	
	
	public JFrame getMainFrame(){
		return frame;
	}
}
