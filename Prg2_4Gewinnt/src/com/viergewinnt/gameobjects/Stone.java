package com.viergewinnt.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.geom.Ellipse2D;

import com.viergewinnt.ai.GridCalculator;

public class Stone{

	private Player player;
	private Color color;
	private int column;
	private int row;
	private boolean active;
	private int relativeX;
	private int relativeY;
	
	public Stone(Player player, Color color, int column, int row) {
		this.setPlayer(player);
		this.setColor(color);
		this.setColumn(column);
		this.setRow(row);
		this.setActive(true);
	}
	
	public void paint(Graphics g, int x, int y, double width, double height) {
		Graphics2D g2d = (Graphics2D) g;
		Ellipse2D stone = new Ellipse2D.Double(x, y, width, height);
		g2d.setColor(color);
		g2d.fill(stone);
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getRelativeX() {
		return relativeX;
	}

	public void setRelativeX(int relativeX) {
		this.relativeX = relativeX;
	}

	public int getRelativeY() {
		return relativeY;
	}

	public void setRelativeY(int relativeY) {
		this.relativeY = relativeY;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}


	

	
}
