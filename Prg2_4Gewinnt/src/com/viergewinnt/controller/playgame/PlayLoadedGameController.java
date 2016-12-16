package com.viergewinnt.controller.playgame;

import com.viergewinnt.controller.base.PlayGameController;
import com.viergewinnt.gameobjects.SaveGame;
import com.viergewinnt.gui.GameFrame;

public class PlayLoadedGameController extends PlayGameController {

	private SaveGame saveGame;
	
	public PlayLoadedGameController(GameFrame frame, SaveGame savedGame) {
		super(frame);
		this.saveGame = savedGame;
	}

	@Override
	public void show() {
		model.setGameProperties(saveGame.getGameProperties());
		initializeModel(saveGame.getPlayer1(), saveGame.getPlayer2());
		startGame();
	}
}
