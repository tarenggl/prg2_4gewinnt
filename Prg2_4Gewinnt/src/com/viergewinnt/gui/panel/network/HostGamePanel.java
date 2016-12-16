package com.viergewinnt.gui.panel.network;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.viergewinnt.gui.base.Sizeable;
import com.viergewinnt.model.HostGameModel;

public class HostGamePanel extends Sizeable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton hostGame;
	
	public HostGamePanel(HostGameModel model) {
		setLayout(null);
		model.getGameName().setBounds(30, 50, 250, 40);
		model.getGameName().setFont(new Font("Arial", Font.PLAIN, 30));
		hostGame = new JButton("Spiel erstellen");
		hostGame.setBounds(30, 160, 250, 40);
		hostGame.setFont(new Font("Arial", Font.PLAIN, 30));
		hostGame.addActionListener(model.getStartServer());
		add(model.getGameName());
		add(hostGame);
		setBackground(Color.GRAY.brighter());
	}

	@Override
	public void orderComponents() {
		// TODO Auto-generated method stub
		
	}
}
