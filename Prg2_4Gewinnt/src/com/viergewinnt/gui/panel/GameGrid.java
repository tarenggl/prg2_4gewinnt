package com.viergewinnt.gui.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class GameGrid extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameGrid() {
		super();
		this.setBackground(Color.GRAY.brighter());
		
	}
	
	@Override
	public void paint(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			Area a = new Area(new Rectangle(0, 0, getWidth(), getHeight()));
			for(int r = 1 ; r <= 5 ; r++) {
				for ( int c = 1 ; c <= 5 ; c++) {
					a.subtract(new Area(new Ellipse2D.Double(((getWidth()/5)*r - (getWidth()/5)*3/4), ((getHeight()/5)*c - (getHeight()/5)*3/4), (getWidth()/5)/1.5, (getHeight()/5)/1.5)));
				}
			}
			g2d.setColor(Color.BLUE.brighter());
			g2d.fill(a);
		}
	}