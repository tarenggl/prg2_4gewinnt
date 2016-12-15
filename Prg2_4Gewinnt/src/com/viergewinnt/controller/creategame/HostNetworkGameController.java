package com.viergewinnt.controller.creategame;

import javax.swing.JTextField;

import com.viergewinnt.controller.base.DrawableController;
import com.viergewinnt.controller.creategame.network.HostNetworkGameAction;
import com.viergewinnt.controller.playgame.PlayNetworkGameController;
import com.viergewinnt.gui.GameFrame;
import com.viergewinnt.gui.panel.network.HostGamePanel;
import com.viergewinnt.model.HostGameModel;

public class HostNetworkGameController implements DrawableController{

	private GameFrame gameFrame;
	private HostGamePanel view;
	private HostGameModel model;
	
	public HostNetworkGameController(GameFrame frame) {
		gameFrame = frame;
		model = new HostGameModel();
		model.setGameName(new JTextField());
		model.setStartServer(new HostNetworkGameAction(model.getGameName(), new PlayNetworkGameController(frame, null)));
		view = new HostGamePanel(model);
	}
	
	public void show() {
		gameFrame.SetNewContentPanel(view);
	}
}
