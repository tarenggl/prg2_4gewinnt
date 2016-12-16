package com.viergewinnt.controller.base;

import com.viergewinnt.ai.GameController;
import com.viergewinnt.controller.playgame.action.AddStoneAction;
import com.viergewinnt.gameobjects.GameProperties;
import com.viergewinnt.gameobjects.Player;
import com.viergewinnt.gameobjects.SaveGame;
import com.viergewinnt.gui.GameFrame;
import com.viergewinnt.gui.dialog.GameFinishedDialog;
import com.viergewinnt.gui.panel.GameContainer;
import com.viergewinnt.model.PlayGameModel;

public abstract class PlayGameController implements DrawableController, Runnable {

	protected GameContainer view;
	protected GameFrame frame;
	protected PlayGameModel model;
	
	public PlayGameController(GameFrame frame) {
		this.frame = frame;
		model = new PlayGameModel();
		model.setGameProperties(new GameProperties(7, 6));
	}
	
	protected void initializeModel(Player player1, Player player2) {		
		model.setStonepressed(new AddStoneAction(model.getGameProperties()));
		model.setPlayer1(player1);
		model.setPlayer2(player2);
		model.setGameController(new GameController(model.getGameProperties(), player1, player2));
	}
	
	protected void startGame() {
		Thread td = new Thread(this);
		td.start();
	}
	
	@Override
	public void run() {
		view = new GameContainer(model);
		view.start();
		frame.SetNewContentPanel(view, new SaveGame(model.getGameProperties(), model.getPlayer1(), model.getPlayer2()));
		Thread td = new Thread(model.getGameController());
		td.start();
		while(td.isAlive()){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		while(model.getGameProperties().isAnyStoneMoving()) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		model.getGameProperties().initWinningMove();
		new GameFinishedDialog(model.getGameController().getWinner().getPlayer().getName(), frame);
		model.getGameProperties().InitializeEmptyField();
	}	
}
