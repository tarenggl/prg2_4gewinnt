package com.viergewinnt.gui.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.viergewinnt.model.GameMenuModel;

public class GameMenuPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int amountOfComponents;
	
	public GameMenuPanel(GameMenuModel model){
		amountOfComponents = 0;
		for(String key : model.getMenuActions().keySet()) {
			initializeButton(key, model.getMenuActions().get(key));
		}
		this.setBackground(Color.GRAY.brighter());
		setLayout(null);
	}
	
	private void initializeButton(String buttonDescription, ActionListener action){
		JButton button = new JButton(buttonDescription);
		button.setBounds(300 - 250, 30 + 70 * amountOfComponents + 7 * amountOfComponents, 500, 70);
		button.setFont(new Font("Arial", Font.PLAIN, 30));
		button.addActionListener(action);
		add(button);
		amountOfComponents++;
	}
	
}
