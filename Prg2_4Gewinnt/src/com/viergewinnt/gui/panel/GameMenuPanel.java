package com.viergewinnt.gui.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
	private ArrayList<JButton> buttons = new ArrayList<>();
	
	public GameMenuPanel(GameMenuModel model){
		amountOfComponents = 0;
		this.setBackground(Color.GRAY.brighter());
		setLayout(null);
		this.model = model;
		for(String key : model.getMenuActions().keySet()) {
			initializeButton(key, model.getMenuActions().get(key));
		}
	}
	
	private void initializeButton(String buttonDescription, ActionListener action){
		JButton button = new JButton(buttonDescription);
		button.setBounds(getWidth()/5, getHeight()/5 + (getHeight()/20) * amountOfComponents + (getHeight()/20)*amountOfComponents, (getWidth()/5)*3, getHeight()/20);
		button.setFont(new Font("Arial", Font.PLAIN, 30));
		button.addActionListener(action);
		add(button);
		buttons.add(button);
		amountOfComponents++;
	}

	@Override
	public void orderComponents() {
		int amountofButtons=0;
		for( JButton b : buttons) {
			b.setBounds(getWidth()/5, getHeight()/5 + (getHeight()/20) * amountofButtons + (getHeight()/20)*amountofButtons, (getWidth()/5)*3, getHeight()/20);
			amountofButtons++;
		}
	}
}
