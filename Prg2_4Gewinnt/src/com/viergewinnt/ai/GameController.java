package com.viergewinnt.ai;

import java.util.ArrayList;

import com.viergewinnt.gameobjects.GameProperties;
import com.viergewinnt.gameobjects.Player;
import com.viergewinnt.gameobjects.Stone;

public class GameController implements Runnable{
	private Player player1;
	private Player player2;
	private GameProperties game;
	private Stone winner;
	
	public GameController(GameProperties properties, Player player, Player oponent) {
		player1 = player;
		player2 = oponent;
		game = properties;
		setWinner(null);
	}
	
	@Override
	public void run() {
		game.setActivePlayer(player1);
		while(!isGameFinished()) {
			try {
				int column = game.getActivePlayer().makeTurn();
				game.addStone(column);
				switchPlayer();
				if(game.getActivePlayer() instanceof NetworkPlayer)
				{
					((NetworkPlayer)game.getActivePlayer()).notifyTurn(column);
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}	
		}
		
	}
	
	
	private void switchPlayer() {
		if(game.getActivePlayer() == player1)
			game.setActivePlayer(player2);
		else
			game.setActivePlayer(player1);
	}
	
	public boolean isGameFinished() {
		for(Stone s : game.getStoneList()) {
			if(GridCalculator.verticalWin(game, s).size() + GridCalculator.horizontalWin(game, s).size() 
					+ GridCalculator.diagonalLeftWin(game, s).size() + GridCalculator.diagonalRightWin(game, s).size() > 0) {
				setWinner(s);
				return true;
			}
		}
		return false;
	}	
	
	public void play(){
		
	}

	public Stone getWinner() {
		return winner;
	}

	public void setWinner(Stone winner) {
		this.winner = winner;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}
	
	
}
