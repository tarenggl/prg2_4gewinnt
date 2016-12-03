package com.viergewinnt.gui.panel.network;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.viergewinnt.controller.creategame.network.JoinNetworkGame;
import com.viergewinnt.gui.dialog.ChooseGamePropertyDialog;
import com.viergewinnt.model.JoinNetworkGameModel;
import com.viergewinnt.network.FindHoster;
import com.viergewinnt.network.data.GameHosterData;

public class JoinGamePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton searchHoster;
	JList<GameHosterData> serverList;
	JButton selectHoster;
	JoinNetworkGame networkGame;
	
	public JoinGamePanel(JoinNetworkGameModel model) {
		initPanelSettings();
		initSearchHoster(model.getSearchGameHoster());
		initServerList(model.getHoster());
		initSelectHoster(model.getSearchGameHoster());
		networkGame = model.getJoinNetworkGame();
	}
	
	private void initServerList(DefaultListModel<GameHosterData> hoster) {
		serverList = new JList<>(hoster);
		serverList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		serverList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				networkGame.setSelectedServer(serverList.getSelectedValue());
				System.out.println(serverList.getSelectedValue());
			}
		});
		JScrollPane listScroller = new JScrollPane(serverList);
		listScroller.setPreferredSize(new Dimension(300, 180));
		add(listScroller);
	}
	
	private void initSearchHoster(ActionListener searchGameHoster) {
		searchHoster = new JButton("Server suchen");
		searchHoster.addActionListener(searchGameHoster);
		add(searchHoster);
	}

	private void initSelectHoster(ActionListener selectGameHoster) {
		selectHoster = new JButton("Select");
		selectHoster.addActionListener(selectGameHoster);
		add(selectHoster);
	}
	
	private void initPanelSettings() {
		this.setLayout(new GridLayout(1, 3));
		this.setBackground(Color.GRAY.brighter());
	}
}
