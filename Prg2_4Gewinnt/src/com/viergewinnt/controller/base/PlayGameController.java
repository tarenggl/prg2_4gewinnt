package com.viergewinnt.controller.base;

import javax.print.attribute.standard.Finishings;

import com.viergewinnt.ai.ComputerPlayer;
import com.viergewinnt.ai.GameController;
import com.viergewinnt.ai.LocalPlayer;
import com.viergewinnt.controller.playgame.action.AddStoneAction;
import com.viergewinnt.gameobjects.GameProperties;
import com.viergewinnt.gameobjects.Player;
import com.viergewinnt.gui.GameFrame;
import com.viergewinnt.gui.dialog.ChooseGamePropertyDialog;
import com.viergewinnt.gui.dialog.GameFinishedDialog;
import com.viergewinnt.gui.panel.GameContainer;
import com.viergewinnt.model.PlayGameModel;

public abstract class PlayGameController implements DrawableController, Runnable {

	protected GameContainer view;
	protected GameFrame frame;
	protected PlayGameModel model;
	private GameFinishedDialog finished;
	private GameController game;
	
	public PlayGameController(GameFrame frame) {
		this.frame = frame;
		model = new PlayGameModel();
		model.setGameProperties(new GameProperties(7, 6));
		view = new GameContainer(model);
	}
	
	protected void startGame(Player player1, Player player2) {		
		model.setStonepressed(new AddStoneAction(model.getGameProperties()));
		view= new GameContainer(model);
		frame.SetNewContentPanel(view);
		game = new GameController(model.getGameProperties(), player1, player2);
		model.setGameController(game);
		view.start();
		startGame();
	}
	
	public void startGame(){
		Thread td = new Thread(this);
		td.start();
	}
	
	@Override
	public void run() {
		Thread td = new Thread(game);
		td.start();
		while(td.isAlive()){
			try {
				td.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		finishGame();
		
	}
	
	
	public void  finishGame(){
		
		finished = new GameFinishedDialog(model.getGameController().getWinner().getPlayer().getName(), frame);
	}
}
