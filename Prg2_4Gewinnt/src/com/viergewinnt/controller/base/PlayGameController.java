package com.viergewinnt.controller.base;

import javax.swing.JPanel;

import com.viergewinnt.controller.playgame.action.AddStoneAction;
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
		model.setStonepressed(new AddStoneAction(model.getGameProperties()));
		view= new GameContainer(model);
		frame.SetNewContentPanel(view);
		view.start();
	}
}
