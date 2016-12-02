package com.viergewinnt.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;


public class GameContainer extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BorderLayout border;
	GameHeader header;	
	GameGrid grid;
	
	public GameContainer(){
		super();
		border = new BorderLayout();
		this.setLayout(border);
		header = new GameHeader();
		grid = new GameGrid();
		this.setBackground(Color.GRAY.brighter());
		this.initialize();
		repaint();
	}
	
	public void initialize() {
		border.addLayoutComponent(header, BorderLayout.NORTH);
		border.addLayoutComponent(grid, BorderLayout.CENTER);
	}
}
