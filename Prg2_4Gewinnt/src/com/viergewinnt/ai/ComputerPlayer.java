package com.viergewinnt.ai;

import java.awt.Color;
import java.util.Random;

import com.viergewinnt.gameobjects.GameProperties;
import com.viergewinnt.gameobjects.Player;
import com.viergewinnt.gameobjects.Stone;

public class ComputerPlayer extends Player {

	private GameProperties gameProperties;
	private int depth = 4;

	private static final long serialVersionUID = 1L;

	public ComputerPlayer(GameProperties gameProperties) {
		super(Color.RED, "Computer");
		this.gameProperties = gameProperties;
	}

	@Override
	public int makeTurn() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int denycol = getColumnToDenyWin(gameProperties.getLastSetStone());
		if(denycol == 0)
			denycol = getColumnToDenyWin(new Stone(gameProperties.getLastSetStone().getPlayer(), gameProperties.getLastSetStone().getColor()
					, gameProperties.getLastSetStone().getColumn(), gameProperties.getLastSetStone().getRow() + 1));
		if(denycol == 0)
			return generateMove();
		else 
			return denycol;
		
		
//		if (opponentWinCol() > gameProperties.getColumns() || opponentWinCol() < 1) {
//			System.out.println("RANDOM MOVE!!!");
//			return generateMove();
//		} else {
//			return opponentWinCol();
//		}
	}

	public int opponentWinCol() {

		for (Stone s : gameProperties.getStoneList()) {
			if (s.getColor() == Color.YELLOW) {
				if (horizontalRightWin(s)) {
					if (gameProperties.getStoneAt(s.getColumn() + 3, s.getRow()) != null) {
						return 0;
					} else {
						return s.getColumn() + 3;
					}
				} else if (verticalWin(s)) {
					if (gameProperties.getStoneAt(s.getColumn(), s.getRow() + 3) != null) {
						return 0;
					} else {
						return s.getColumn();
					}
				} else if (diagonalLeftWin(s)) {
					if (gameProperties.getStoneAt(s.getColumn() - 3, s.getRow() + 2) == null) {
						return 0;
					} else if (gameProperties.getStoneAt(s.getColumn() - 3, s.getRow() + 3) != null) {
						return 0;
					} else {
						return (s.getColumn() - 3);
					}
				} else if (diagonalRightWin(s)) {
					if (gameProperties.getStoneAt(s.getColumn() + 3, s.getRow() + 2) == null) {
						return 0;
					} else if (gameProperties.getStoneAt(s.getColumn() + 3, s.getRow() + 3) != null) {
						return 0;
					} else {
						return (s.getColumn() + 3);
					}
				}
				return 0;
			}
		}
		return 0;
	}

	public int generateMove() {

		return new Random().nextInt(gameProperties.getColumns()) + 1;
	}

	public boolean horizontalRightWin(Stone stone) {
		int row = stone.getRow();
		int column = stone.getColumn();
		Stone currentStone;
		for (int i = column + 1; i <= column + 2; i++) {
			currentStone = gameProperties.getStoneAt(i, row);
			if (currentStone == null || currentStone.getColor() != stone.getColor()) {
				return false;
			}
		}
		return true;
	}

	public boolean horizontalLeftWin(Stone stone) {
		int row = stone.getRow();
		int column = stone.getColumn();
		Stone currentStone;
		for (int i = column - 1; i <= column - 2; i--) {
			currentStone = gameProperties.getStoneAt(i, row);
			if (currentStone == null || currentStone.getColor() != stone.getColor()) {
				return false;
			}
		}
		return true;
	}

	public boolean verticalWin(Stone stone) {
		int row = stone.getRow();
		int column = stone.getColumn();
		Stone currentStone;

		for (int i = row + 1; i <= row + 2; i++) {
			currentStone = gameProperties.getStoneAt(column, i);
			if (currentStone == null || currentStone.getColor() != stone.getColor()) {
				return false;
			}
		}
		return true;
	}

	public boolean diagonalLeftWin(Stone stone) {
		int row = stone.getRow();
		int column = stone.getColumn();
		Stone currentStone;
		for (int i = 1; i <= 2; i++) {
			currentStone = gameProperties.getStoneAt(column - i, row + i);
			if (currentStone == null || currentStone.getColor() != stone.getColor()) {
				return false;
			}
		}
		return true;
	}

	public boolean diagonalRightWin(Stone stone) {
		int row = stone.getRow();
		int column = stone.getColumn();
		Stone currentStone;
		for (int i = 1; i <= 2; i++) {
			currentStone = gameProperties.getStoneAt(column + i, row + i);
			if (currentStone == null || currentStone.getColor() != stone.getColor()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void notifyTurn(int column) {
//		Stone s = gameProperties.getLastSetStone();
//		int columnToDenyWin = getColumnToDenyWin(s);
	}

	private int getColumnToDenyWin(Stone s) {
		int col = getHorizontalWin(s);
		if(col == 0)
			col = getVerticalWin(s);
		if(col == 0)
			col = getLeftDiagonalDeny(s);
		if(col == 0)
			col = getRightDiagonalDeny(s);
		return col;
	}

	private int getHorizontalWin(Stone s) {
		int holeColumn = 0;
		int winningStoneCount = 0;
		for (int i = -3; i < 4; i++) {
			if (i + s.getColumn() < 1 || i + s.getColumn() > gameProperties.getColumns())
				continue;
			Stone currentStone = gameProperties.getStoneAt(s.getColumn() + i, s.getRow());
			if (currentStone == null) {
				if(isAbleToSetStone(s.getColumn() + i, s.getRow()))
				if(holeColumn != 0) {
					winningStoneCount = 0;
				}
				holeColumn = i + s.getColumn();
			} else if (!currentStone.getColor().equals(s.getColor())) {
				winningStoneCount = 0;
				holeColumn = 0;
			} else {
				winningStoneCount++;
			}
			if (winningStoneCount == 3) {
				if (holeColumn == 0) {
					if (isAbleToSetStone(i + s.getColumn() - 3, s.getRow())) {
						return i + s.getColumn() - 3;
					} else if (isAbleToSetStone(i + s.getColumn() + 1, s.getRow())) {
						return i + s.getColumn() + 1;
					}
				} else if(isAbleToSetStone(holeColumn, s.getRow())) {
					return holeColumn;
				}				
			}
		}
		return 0;
	}
	
	private int getVerticalWin(Stone s) {
		for (int i = -2; i < 0; i++) {
			if (isOutOfRowRange(i+s.getRow()))
				return 0;
			Stone currentStone = gameProperties.getStoneAt(s.getColumn(), s.getRow()+i);
			if (currentStone == null || !currentStone.getColor().equals(s.getColor())) {
				return 0;
			}
		}
		return s.getColumn();
	}

	private boolean isOutOfRange(int column) {
		return (column < 1 || column > gameProperties.getColumns());
	}
	
	private boolean isOutOfRowRange(int row) {
		return (row < 1 || row > gameProperties.getRows());
	}

	private boolean isAbleToSetStone(int column, int row) {
		if (isOutOfRange(column))
			return false;
		if ((row == 1 || gameProperties.getStoneAt(column, row - 1) != null)
				&& gameProperties.getStoneAt(column, row) == null)
			return true;
		return false;
	}

	private int getLeftDiagonalDeny(Stone s) {
		int holeColumn = -100;
		int winningCount = 0;
		for(int i = -3; i < 4; i++) {
			if(isOutOfRange(s.getColumn() + i) || isOutOfRowRange(s.getRow() - i))
				continue;
			Stone currentStone = gameProperties.getStoneAt(s.getColumn() + i, s.getRow() - i);
			if(currentStone == null) {
				if(isAbleToSetStone(s.getColumn() + i, s.getRow() - i))
					continue;
				if(holeColumn != -100)
					winningCount = 0;
				holeColumn = i;
			} else if (currentStone.getColor().equals(s.getColor())) {
				winningCount++;
			} else {
				winningCount = 0;
				holeColumn = -100;
			}
			if(winningCount == 3){
				if(holeColumn == -100) {
					if(isAbleToSetStone(s.getColumn() + i - 3, s.getRow() - i + 3))
						return s.getColumn() + i -3;
					if(isAbleToSetStone(s.getColumn() + i + 1, s.getRow() - i - 1)){
						return s.getColumn() + i + 1;
					}
				} else {
					if(isAbleToSetStone(s.getColumn() + i + holeColumn, s.getColumn() - i - holeColumn))
						return s.getColumn() + i + holeColumn;								
				}
			} 
		}
		return 0;
	}
	
	private int getRightDiagonalDeny(Stone s) {
		int holeColumn = -100;
		int winningCount = 0;
		for(int i = -3; i < 4; i++) {
			if(isOutOfRange(s.getColumn() - i) || isOutOfRowRange(s.getRow() + i))
				continue;
			Stone currentStone = gameProperties.getStoneAt(s.getColumn() - i, s.getRow() + i);
			if(currentStone == null) {
				if(isAbleToSetStone(s.getColumn() - i, s.getRow() + i))
					continue;
				if(holeColumn != -100)
					winningCount = 0;
				holeColumn = i;
			} else if (currentStone.getColor().equals(s.getColor())) {
				winningCount++;
			} else {
				winningCount = 0;
				holeColumn = -100;
			}
			if(winningCount == 3){
				if(holeColumn == -100) {
					if(isAbleToSetStone(s.getColumn() - i + 3, s.getRow() + i - 3))
						return s.getColumn() - i + 3;
					if(isAbleToSetStone(s.getColumn() - i - 1, s.getRow() + i + 1)){
						return s.getColumn() - i - 1;
					}
				} else {
					if(isAbleToSetStone(s.getColumn() - i - holeColumn, s.getColumn() + i + holeColumn))
						return s.getColumn() - i - holeColumn;								
				}
			} 
		}
		return 0;
	}
}
