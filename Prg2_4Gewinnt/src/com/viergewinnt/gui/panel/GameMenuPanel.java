package com.viergewinnt.gui.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameMenuPanel extends JPanel {
	
	JButton hostGame;
	JButton enterGame;
	private int amountOfComponents;
	
	public GameMenuPanel(){
		super();
		amountOfComponents = 0;
		hostGame = new JButton("Neues Spiel erstellen");
		enterGame = new JButton("Spiel finden");
		this.setBackground(Color.BLUE.brighter());
		setLayout(null);
	}
	
	public void initialize() {
		amountOfComponents=0;
		removeAll();
		initializeButton(hostGame);
		initializeButton(enterGame);
		repaint();
	}
	
	private void initializeButton(JButton button){
		button.setBounds(getWidth() / 2 - 250, 30 + 70 * amountOfComponents + 7 * amountOfComponents, 500, 70);
		button.setFont(new Font("Arial", Font.PLAIN, 40));
		add(button);
		amountOfComponents++;
	}
}
