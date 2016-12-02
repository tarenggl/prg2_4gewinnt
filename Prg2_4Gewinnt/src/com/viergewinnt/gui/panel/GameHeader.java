package com.viergewinnt.gui.panel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameHeader extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameHeader() {
		super();
		this.setBackground(Color.BLACK.brighter());
		JButton button  = new JButton ("Test");

		button.setPreferredSize(new Dimension(180, 300));
		add(button);

	}

	

}
