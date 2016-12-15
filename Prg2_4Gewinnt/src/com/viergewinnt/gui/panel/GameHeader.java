package com.viergewinnt.gui.panel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.viergewinnt.gameobjects.Player;

public class GameHeader extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameHeaderLabel timeDesc, timeCount, turn, lPlayer1, lPlayer2;
	private StonePanel pTurn, pPlayer1, pPlayer2;
	private Date gameTime;
	private DateFormat formatter;
	private long counter;
	
	public GameHeader(Player player1, Player player2) {
		super();
		this.setBackground(Color.WHITE.brighter());
		this.setLayout(new GridLayout(2, 4));
		timeDesc = new GameHeaderLabel("Time:");
		turn = new GameHeaderLabel("Turn:");
		pTurn = new StonePanel(getBackground());
		timeCount = new GameHeaderLabel("0");
		lPlayer1 = new GameHeaderLabel(player1.getName());
		lPlayer2 = new GameHeaderLabel(player2.getName());
		pPlayer1 = new StonePanel(player1.getColor());
		pPlayer2 = new StonePanel(player2.getColor());
		gameTime = new Date();
		formatter = new SimpleDateFormat("mm:ss");
		addComponents();
		startTimer();		
	}
	
	private void addComponents(){
		add(timeDesc);
		add(timeCount);
		add(lPlayer1);
		add(pPlayer1);
		add(turn);
		add(pTurn);
		add(lPlayer2);
		add(pPlayer2);
		repaint();
	}
	
	private void startTimer(){
		Timer timer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timeCount.setText(((Long)((new Date().getTime() - gameTime.getTime())/1000)).toString());
				counter = ((new Date().getTime() - gameTime.getTime()));
				timeCount.setText(formatter.format(new Date(counter)));
			}
		});
		timer.start();
	}
}
