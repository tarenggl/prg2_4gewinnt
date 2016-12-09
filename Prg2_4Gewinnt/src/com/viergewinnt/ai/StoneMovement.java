package com.viergewinnt.ai;

import com.viergewinnt.gameobjects.GameProperties;
import com.viergewinnt.gameobjects.Stone;

public class StoneMovement implements Runnable{

	private GameProperties game;
	private Stone stone;
	
	public StoneMovement(Stone s, GameProperties game) {
		this.game = game;
		this.stone = s;
		stone.setRelativeX((int) GridCalculator.getStoneXPositionAt(game, stone.getColumn()));
		stone.setRelativeY((int) GridCalculator.getStoneYPositionAt(game, game.getRows() + 1));
		
	}
	
	public void start() {
		Thread thrd = new Thread(this);
		thrd.start();
	}

	@Override
	public void run() {
		
		while(stone.isActive()) {
			stone.setRelativeY(stone.getRelativeY() + 1);
			stone.setActive((int) GridCalculator.getStoneYPositionAt(game, stone.getRow()) > stone.getRelativeY());
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
