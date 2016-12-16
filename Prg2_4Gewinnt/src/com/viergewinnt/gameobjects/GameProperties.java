package com.viergewinnt.gameobjects;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

import com.viergewinnt.ai.ComputerPlayer;
import com.viergewinnt.ai.GridCalculator;
import com.viergewinnt.ai.StoneMovement;

public class GameProperties implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int columns;
	private int rows;
	private ArrayList<Stone> stoneList;
	private int gridwidth;
	private int gridheight;
	private Player activePlayer;
	private Stone lastSetStone = null;
	
	
	public GameProperties(int columns, int rows) {
		this.setColumns(columns < 5 ? 5 : columns);
		this.setRows(rows < 5 ? 5 : rows);
		stoneList = new ArrayList<>(this.getColumns()*this.getRows());
		activePlayer = new ComputerPlayer(null);
	}
	
	public ArrayList<Stone> getStoneList(){
		return this.stoneList;
	}
	
	public Stone getStoneAt(int column, int row) {
		for(Stone s : stoneList) {
			if (s.getRow() == row) {
				if (s.getColumn() == column) {
					return s;
				}
			}
		}
		
		return null;
	}
	
	public void addStone(int column) throws ArrayIndexOutOfBoundsException {
		if(columnIsFull(column) || !columnIsValid(column)) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Stone s = new Stone(activePlayer, activePlayer.getColor(), column, getFreeRow(column));
		StoneMovement move = new StoneMovement(s, this);
		move.start();
		stoneList.add(s);
		setLastSetStone(s);
	}
	
	private boolean columnIsValid(int column) {
		return !(column < 1 || column > columns);
	}

	private boolean columnIsFull(int col) {
		return (getFreeRow(col) > rows);
	}
	
	private int getFreeRow(int col) {
		int currentRow = 1;
		for(Stone s : stoneList) {
			currentRow = s.getColumn() == col ? ++currentRow : currentRow;
		}
		return currentRow;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getGridwidth() {
		return gridwidth;
	}

	public void setGridwidth(int gridwidth) {
		this.gridwidth = gridwidth;
	}

	public int getGridheight() {
		return gridheight;
	}

	public void setGridheight(int gridheight) {
		this.gridheight = gridheight;
	}

	public Player getActivePlayer() {
		return activePlayer;
	}
	
	public void setActivePlayer(Player player) {
		activePlayer = player;
	}
	
	public void InitializeEmptyField() {
		stoneList.clear();
	}

	public Stone getLastSetStone() {
		return lastSetStone;
	}

	public void setLastSetStone(Stone lastSetStone) {
		this.lastSetStone = lastSetStone;
	}
	
	public void initWinningMove() {
		Thread td = new Thread(new WinningStoneMove(GridCalculator.getWinningStones(this)));
		td.start();
	}
	
	public boolean isAnyStoneMoving() {
		for(Stone s: stoneList) {
			if(s.isActive())
				return true;
		}
		return false;
	}
	
	private class WinningStoneMove implements Runnable {
		ArrayList<Stone> winningStones;
		
		public WinningStoneMove(ArrayList<Stone> winningStones) {
			this.winningStones = winningStones;
		}
		
		@Override
		public void run() {
			Color initialColor = winningStones.get(0).getColor();
			Color winningColor = Color.BLACK;
			for(int i = 0; i < 18; i++)
			{
				for (Stone stone : winningStones) {
					stone.setColor(i % 2 == 0 ? winningColor: initialColor);
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
