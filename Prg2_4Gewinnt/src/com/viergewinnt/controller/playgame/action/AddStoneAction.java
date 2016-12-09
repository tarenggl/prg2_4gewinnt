package com.viergewinnt.controller.playgame.action;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.viergewinnt.ai.GridCalculator;
import com.viergewinnt.gameobjects.GameProperties;
import com.viergewinnt.gameobjects.Player;

public class AddStoneAction implements MouseListener{

	private GameProperties game;
	private Player localPlayer;
	
	public AddStoneAction(GameProperties game, Player localPlayer) {
		this.game = game;
		this.localPlayer = localPlayer;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		localPlayer.makeColSelection(GridCalculator.getActiveColumn(game, e.getX()));
	}
}
