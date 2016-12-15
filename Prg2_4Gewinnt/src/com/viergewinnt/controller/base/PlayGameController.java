package com.viergewinnt.controller.base;

import javax.print.attribute.standard.Finishings;

import com.viergewinnt.ai.ComputerPlayer;
import com.viergewinnt.ai.GameController;
import com.viergewinnt.ai.LocalPlayer;
import com.viergewinnt.controller.playgame.action.AddStoneAction;
import com.viergewinnt.gameobjects.Player;
import com.viergewinnt.gui.GameFrame;
import com.viergewinnt.gui.dialog.ChooseGamePropertyDialog;
import com.viergewinnt.gui.dialog.GameFinishedDialog;
import com.viergewinnt.gui.panel.GameContainer;
import com.viergewinnt.model.PlayGameModel;

public abstract class PlayGameController implements DrawableController {

	protected GameContainer view;
	protected GameFrame frame;
	protected PlayGameModel model;
	private GameFinishedDialog finished;
	
	public void show() {
		ChooseGamePropertyDialog dialog = new ChooseGamePropertyDialog(model.getGameProperties(), frame);
		dialog.setVisible(true);
		Player localPlayer = new LocalPlayer(dialog.getName());
		model.setStonepressed(new AddStoneAction(model.getGameProperties(), localPlayer));
		view= new GameContainer(model);
		frame.SetNewContentPanel(view);
		GameController game = new GameController(model.getGameProperties(), localPlayer, new ComputerPlayer(model.getGameProperties()));
		model.setGameController(game);
		view.start();
		startGame(game);
	}
	
	public void startGame(GameController game){
		Thread td = new Thread(game);
		td.start();
		try {
			td.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finishGame();
	}
	
	public void finishGame(){
		
		finished = new GameFinishedDialog(model.getGameController().getWinner().getPlayer().getName(), frame);
	}
}
