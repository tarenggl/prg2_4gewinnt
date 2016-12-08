package com.viergewinnt.controller.creategame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import com.viergewinnt.controller.base.DrawableController;
import com.viergewinnt.gui.GameFrame;
import com.viergewinnt.gui.menubar.GameMenuBar;
import com.viergewinnt.gui.panel.GameContainer;
import com.viergewinnt.gui.panel.GameMenuPanel;
import com.viergewinnt.gui.panel.network.HostGamePanel;
import com.viergewinnt.model.GameMenuModel;

public class GameMenuController implements DrawableController {
	
	private GameFrame gameFrame;
	private GameMenuModel model;
	private GameMenuPanel view;
	
	public GameMenuController(GameFrame gameFrame) {
		model =  new GameMenuModel();
		Hashtable<String, ActionListener> actions = new Hashtable<>();
		actions.put("Neues Netzwerkspiel erstellen", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new HostNetworkGameController(gameFrame).show();
			}
		});
		actions.put("Spiel finden", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new JoinNetworkGameController(gameFrame).show();
			}
		});
		actions.put("Neues Spiel gegen Computer", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new PlayComputerGameController(gameFrame).show();
			}
		});
		model.setMenuActions(actions);	
		view = new GameMenuPanel(model);
		this.gameFrame = gameFrame;
	}
	
	public void show() {
		gameFrame.SetNewContentPanel(view);
		gameFrame.setJMenuBar(new GameMenuBar(model, "Spiel"));
	}
}