package com.viergewinnt.controller.playgame.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.viergewinnt.ai.GridCalculator;
import com.viergewinnt.gameobjects.GameProperties;

public class AddStoneAction implements MouseListener{

	private GameProperties game;
	
	public AddStoneAction(GameProperties game) {
		this.game = game;
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
		game.addStone(GridCalculator.getActiveColumn(game, e.getX()));
	}

	
}
