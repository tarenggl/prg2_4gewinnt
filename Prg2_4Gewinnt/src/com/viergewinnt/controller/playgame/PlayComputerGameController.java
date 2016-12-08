package com.viergewinnt.controller.playgame;

import com.viergewinnt.controller.base.DrawableController;
import com.viergewinnt.controller.base.PlayGameController;
import com.viergewinnt.gameobjects.GameProperties;
import com.viergewinnt.gui.GameFrame;
import com.viergewinnt.gui.panel.GameContainer;
import com.viergewinnt.model.PlayGameModel;

public class PlayComputerGameController extends PlayGameController implements DrawableController{

	private GameFrame frame;
	private GameContainer view;
	private PlayGameModel model;

	public PlayComputerGameController(GameFrame gameFrame) {
		frame = gameFrame;
		model = new PlayGameModel();
		model.setGameProperties(new GameProperties(5, 5));
		view = new GameContainer(model);
	}
	
	public void show() {
		frame.SetNewContentPanel(view);
	}
	
}
