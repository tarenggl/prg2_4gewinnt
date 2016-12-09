package com.viergewinnt.controller.playgame;

import com.viergewinnt.controller.base.DrawableController;
import com.viergewinnt.controller.base.PlayGameController;
import com.viergewinnt.gameobjects.GameProperties;
import com.viergewinnt.gui.GameFrame;
import com.viergewinnt.gui.panel.GameContainer;
import com.viergewinnt.model.PlayGameModel;

public class PlayComputerGameController extends PlayGameController {


	public PlayComputerGameController(GameFrame gameFrame) {
		frame = gameFrame;
		model = new PlayGameModel();
		model.setGameProperties(new GameProperties(7, 6));
		view = new GameContainer(model);
	}
}
