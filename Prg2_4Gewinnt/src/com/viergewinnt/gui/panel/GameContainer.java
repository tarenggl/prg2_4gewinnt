package com.viergewinnt.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import com.viergewinnt.model.PlayGameModel;


public class GameContainer extends JPanel implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GameHeader header;	
	GameGrid grid;
	
	public GameContainer(PlayGameModel model){
		super();
		this.setLayout(new BorderLayout());
		header = new GameHeader(model.getGameProperties());
		grid = new GameGrid(model.getGameProperties());
		grid.addMouseListener(model.getStonepressed());
		this.setBackground(Color.WHITE.brighter());
		this.initialize();		
	}
	
	public void start() {
		Thread thrd = new Thread(this);
		thrd.start();
	}
	
	public void initialize() {
		add(header, BorderLayout.NORTH);
		add(grid, BorderLayout.CENTER);
	}

	@Override
	public void run() {
		while(true) {
			grid.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
