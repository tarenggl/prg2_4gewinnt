package com.viergewinnt.ai;

import java.awt.Color;

import com.viergewinnt.gameobjects.GameProperties;
import com.viergewinnt.gameobjects.Player;

public class LocalPlayer extends Player implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GameProperties gameProperties;

	public LocalPlayer(String name) {
		super(Color.YELLOW, name);
	}

	@Override
	public int makeTurn() {
		try {
			Thread td = new Thread(this);
			td.start();
			td.join();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		int column = columnSelection;
		columnSelection = 0;
		return column;
	}

	@Override
	public void run() {
		while (columnSelection == 0) {
			try {
				Thread.sleep(10);
			} catch (Exception ex) {
			}
		}
	}

}
