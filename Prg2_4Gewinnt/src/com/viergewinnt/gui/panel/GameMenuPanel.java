package com.viergewinnt.gui.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.viergewinnt.gui.GameFrame;
import com.viergewinnt.gui.panel.network.HostGamePanel;
import com.viergewinnt.gui.panel.network.JoinGamePanel;

public class GameMenuPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton hostGame;
	JButton enterGame;
	JButton computerGame;
	GameFrame mainFrameContainer;
	private int amountOfComponents;
	
	public GameMenuPanel(GameFrame frame){
		super();
		this.mainFrameContainer = frame;
		amountOfComponents = 0;
		hostGame = new JButton("Neues Netzwerkspiel erstellen");
		hostGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainFrameContainer.SetNewContentPanel(new HostGamePanel());
			}
		});
		enterGame = new JButton("Spiel finden");
		enterGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainFrameContainer.SetNewContentPanel(new JoinGamePanel());
			}
		});
		computerGame = new JButton("Neues Spiel gegen Computer");
		computerGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainFrameContainer.SetNewContentPanel(new GameContainer());
			}
		});
		this.setBackground(Color.GRAY.brighter());
		setLayout(null);
	}
	
	private void initialize() {
		amountOfComponents=0;
		removeAll();
		initializeButton(hostGame);
		initializeButton(enterGame);
		initializeButton(computerGame);
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		initialize();
		super.paint(g);
	}
	
	
	private void initializeButton(JButton button){
		button.setBounds(getWidth() / 2 - 250, 30 + 70 * amountOfComponents + 7 * amountOfComponents, 500, 70);
		button.setFont(new Font("Arial", Font.PLAIN, 30));
		add(button);
		amountOfComponents++;
	}
	
}
