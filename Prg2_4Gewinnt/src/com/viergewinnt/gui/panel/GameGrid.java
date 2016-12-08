package com.viergewinnt.gui.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import com.viergewinnt.gameobjects.GameProperties;

public class GameGrid extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int activeStoneCol;
	private GameProperties game;
	private int rows;
	private int cols;

	public GameGrid(GameProperties game) {
		super();
		this.setBackground(Color.GRAY.brighter());
		this.game = game;
		rows = game.getRows();
		cols = game.getColumns();
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				for(int i = 1 ;  i <= cols; i++) {
					if(e.getX() <= (getWidth()/cols)*i) {
						activeStoneCol = i;
						break;
					}
				}
				repaint();
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		Area a = new Area(new Rectangle(0, getHeight()/(rows+1), getWidth(), (getHeight()/(rows+1))*rows));
		for(int r = 1 ; r <= rows ; r++) {
			for ( int c = 1 ; c <= cols ; c++) {
				a.subtract(new Area(new Ellipse2D.Double(((getWidth()/cols)*c - (getWidth()/cols)*3/4), ((getHeight()/(rows+1))*r - (getHeight()/(rows+1))*3/4) + getHeight()/(rows+1), (getWidth()/cols)/1.5, (getHeight()/(rows+1))/1.5)));
			}
		}
		Ellipse2D activeStone = new Ellipse2D.Double(((getWidth()/cols)*activeStoneCol - (getWidth()/cols)*3/4), ((getHeight()/(rows+1)) - (getHeight()/(rows+1))*3/4), (getWidth()/cols)/1.5, (getHeight()/(rows+1))/1.5);
		
		g2d.setColor(Color.BLUE.brighter());
		g2d.fill(a);
		//change color to player color
		g2d.setColor(Color.YELLOW.brighter());
		g2d.fill(activeStone);
		
	}
}