package com.viergewinnt.controller.creategame;

import com.viergewinnt.controller.base.DrawableController;
import com.viergewinnt.gui.GameFrame;
import com.viergewinnt.network.data.GameHosterData;

public class PlayNetworkGameController implements DrawableController{

	private GameFrame frame;
	private GameHosterData gameHoster;

	public PlayNetworkGameController(GameFrame gameFrame, GameHosterData gameHoster) {
		frame = gameFrame;
		this.gameHoster = gameHoster;
	}
	
	public void show() {
		
	}
	
}
