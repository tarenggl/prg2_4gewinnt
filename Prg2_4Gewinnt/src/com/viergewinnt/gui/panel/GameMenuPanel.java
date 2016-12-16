package com.viergewinnt.gui.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.viergewinnt.gui.base.Sizeable;
import com.viergewinnt.model.GameMenuModel;

public class GameMenuPanel extends Sizeable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int amountOfComponents;
	private GameMenuModel model;
	
	public GameMenuPanel(GameMenuModel model){
		amountOfComponents = 0;
		//setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.GRAY.brighter());
		setLayout(null);
		this.model = model;
	}
	
	private void initializeButton(String buttonDescription, ActionListener action){
		JButton button = new JButton(buttonDescription);
		button.setBounds(getWidth()/4, getHeight()/3 + getHeight()/15 * amountOfComponents + getHeight()/15*amountOfComponents, getWidth()/2, getHeight()/15);
		button.setFont(new Font("Arial", Font.PLAIN, 30));
		button.addActionListener(action);
		add(button);
		amountOfComponents++;
	}

	@Override
	public void orderComponents() {
		for(String key : model.getMenuActions().keySet()) {
			initializeButton(key, model.getMenuActions().get(key));
		}
	}
}
