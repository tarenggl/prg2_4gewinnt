package com.viergewinnt.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import com.viergewinnt.model.PlayGameModel;


public class GameContainer extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GameHeader header;	
	GameGrid grid;
	
	public GameContainer(PlayGameModel model){
		super();
		this.setLayout(new BorderLayout());
		header = new GameHeader();
		grid = new GameGrid(model.getGameProperties());
		this.setBackground(Color.WHITE.brighter());
		this.initialize();
		repaint();
	}
	
	public void initialize() {
		add(header, BorderLayout.NORTH);
		add(grid, BorderLayout.CENTER);
	}
}
