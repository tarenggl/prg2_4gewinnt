package com.viergewinnt.controller.base;

import com.viergewinnt.ai.ComputerPlayer;
import com.viergewinnt.ai.GameController;
import com.viergewinnt.ai.LocalPlayer;
import com.viergewinnt.controller.playgame.action.AddStoneAction;
import com.viergewinnt.gameobjects.Player;
import com.viergewinnt.gui.GameFrame;
import com.viergewinnt.gui.dialog.ChooseGamePropertyDialog;
import com.viergewinnt.gui.panel.GameContainer;
import com.viergewinnt.model.PlayGameModel;

public abstract class PlayGameController implements DrawableController{

	protected GameContainer view;
	protected GameFrame frame;
	protected PlayGameModel model;
	
	public void show() {
		ChooseGamePropertyDialog dialog = new ChooseGamePropertyDialog(model.getGameProperties(), frame);
		dialog.setVisible(true);
		Player localPlayer = new LocalPlayer("franz");
		model.setStonepressed(new AddStoneAction(model.getGameProperties(), localPlayer));
		view= new GameContainer(model);
		frame.SetNewContentPanel(view);
		GameController game = new GameController(model.getGameProperties(), localPlayer, new ComputerPlayer(model.getGameProperties()));
		model.setGameController(game);
		view.start();
		Thread td = new Thread(game);
		td.start();
	}
}
