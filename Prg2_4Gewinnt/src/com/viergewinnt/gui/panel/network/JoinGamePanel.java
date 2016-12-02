package com.viergewinnt.gui.panel.network;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.viergewinnt.network.FindHoster;
import com.viergewinnt.network.data.GameHoster;

public class JoinGamePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton searchHoster;
	DefaultListModel<GameHoster> hoster;
	JList<GameHoster> serverList;
	JButton selectHoster;
	
	public JoinGamePanel() {
		this.setLayout(new GridLayout(1, 3));
		this.setBackground(Color.GRAY.brighter());
		searchHoster = new JButton("Server suchen");
		hoster = new DefaultListModel<GameHoster>();
		serverList = new JList<>(hoster);
		serverList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		JScrollPane listScroller = new JScrollPane(serverList);
		listScroller.setPreferredSize(new Dimension(300, 180));
		selectHoster = new JButton("Select");
		add(searchHoster);
		add(listScroller);
		add(selectHoster);
		initializeSearchButton();
	}
	
	private void initializeSearchButton() {
		searchHoster.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				hoster.clear();
				hoster.addElement(new GameHoster("...", "", 0));
				FindHoster findHoster = new FindHoster();
				Thread td = new Thread(new Runnable() {
					@Override
					public void run() {
						List<GameHoster> foundHosts = findHoster.searchForHostedGames();
						hoster.clear();
						if(foundHosts.size() == 0) {
							hoster.addElement(new GameHoster("Nothing found", "", 0));
						}
						for (GameHoster gameHoster : foundHosts) {
							hoster.addElement(gameHoster);
						}
					}
				});
				td.start();
			}
		});
	}
}
