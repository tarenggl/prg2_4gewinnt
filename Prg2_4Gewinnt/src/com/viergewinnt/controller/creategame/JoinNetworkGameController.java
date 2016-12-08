package com.viergewinnt.controller.creategame;

import javax.swing.JList;

import com.viergewinnt.controller.base.DrawableController;
import com.viergewinnt.controller.creategame.network.JoinNetworkGame;
import com.viergewinnt.controller.creategame.network.SearchNetworkHoster;
import com.viergewinnt.gui.GameFrame;
import com.viergewinnt.gui.panel.network.JoinGamePanel;
import com.viergewinnt.model.JoinNetworkGameModel;

public class JoinNetworkGameController implements DrawableController {
	
	GameFrame mainGameFrame;
	JoinGamePanel panel;
	JoinNetworkGameModel model;
	
	public JoinNetworkGameController(GameFrame mainGameFrame) {
		this.mainGameFrame = mainGameFrame;	
		model = new JoinNetworkGameModel();
		model.setSearchGameHoster(new SearchNetworkHoster(model.getHoster()));
		model.setHosterList(new JList<>());
		model.setJoinNetworkGame(new JoinNetworkGame(model.getHosterList()));
		panel = new JoinGamePanel(model);
	}

	public void show() {
		mainGameFrame.SetNewContentPanel(panel);
	}
}
