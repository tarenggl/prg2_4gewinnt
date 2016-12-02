package com.viergewinnt.gui.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameHeader extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer timer;
	private JLabel timeDesc, timeCount, turn, lPlayer1, lPlayer2;
	private JPanel pTurn, pPlayer1, pPlayer2;

	public GameHeader() {
		super();
		this.setBackground(Color.BLACK.brighter());
		this.setLayout(new GridLayout(2, 4));
		timeDesc = new JLabel("Time:");
		turn = new JLabel("Turn:");
		timeCount = new JLabel("0");
		lPlayer1 = new JLabel("");
		lPlayer2 = new JLabel("");
		
	}
	
	public void setPlayer(String player1, String player2){
		lPlayer1.setText(player1);
		lPlayer2.setText(player2);
	}
		
		
		
		
		
		//timer = new Timer(1000, listener)
		
				

	
	private void addComponents(){
		
		
	}
	
	

	
	

}
