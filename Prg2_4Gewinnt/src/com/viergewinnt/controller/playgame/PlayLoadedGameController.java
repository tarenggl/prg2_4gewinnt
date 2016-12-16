package com.viergewinnt.controller.playgame;

import com.viergewinnt.ai.ComputerPlayer;
import com.viergewinnt.ai.LocalPlayer;
import com.viergewinnt.controller.base.PlayGameController;
import com.viergewinnt.gameobjects.Player;
import com.viergewinnt.gameobjects.SaveGame;
import com.viergewinnt.gui.GameFrame;
import com.viergewinnt.gui.dialog.ChooseGamePropertyDialog;

public class PlayLoadedGameController extends PlayGameController {

	private SaveGame saveGame;
	
	public PlayLoadedGameController(GameFrame frame, SaveGame savedGame) {
		super(frame);
		this.saveGame = savedGame;
	}

	@Override
	public void show() {
		model.setGameProperties(saveGame.getGameProperties());
		initializeModel(model.getPlayer1(), model.getPlayer2());
		startGame();
	}
}
