package com.viergewinnt.controller.playgame;

import com.viergewinnt.ai.ComputerPlayer;
import com.viergewinnt.ai.LocalPlayer;
import com.viergewinnt.controller.base.PlayGameController;
import com.viergewinnt.gameobjects.GameProperties;
import com.viergewinnt.gameobjects.Player;
import com.viergewinnt.gui.GameFrame;
import com.viergewinnt.gui.dialog.ChooseGamePropertyDialog;
import com.viergewinnt.gui.panel.GameContainer;
import com.viergewinnt.model.PlayGameModel;

public class PlayComputerGameController extends PlayGameController {

	public PlayComputerGameController(GameFrame gameFrame) {
		frame = gameFrame;
		model = new PlayGameModel();
		model.setGameProperties(new GameProperties(7, 6));
		view = new GameContainer(model);
	}
	
	public void gameFinished(String winner){
		
	}

	@Override
	public void show() {
		ChooseGamePropertyDialog dialog = new ChooseGamePropertyDialog(model.getGameProperties(), frame);
		dialog.setVisible(true);
		Player localPlayer = new LocalPlayer(dialog.getPlayerName());
		startGame(localPlayer, new ComputerPlayer(model.getGameProperties()));
	}
}
