package com.viergewinnt.start;

import com.viergewinnt.controller.creategame.GameMenuController;
import com.viergewinnt.gui.GameFrame;

public class StartUp {
	public static void main(String[] args) {
		GameFrame gameFrame = new GameFrame();
		GameMenuController menuController = new GameMenuController(gameFrame);
		menuController.show();
	}
}
