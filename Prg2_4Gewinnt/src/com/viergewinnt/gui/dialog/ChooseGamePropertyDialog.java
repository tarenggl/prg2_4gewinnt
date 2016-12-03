package com.viergewinnt.gui.dialog;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ChooseGamePropertyDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField playerName;
	
	public ChooseGamePropertyDialog(JFrame parentFrame) {
		super(parentFrame);
		setTitle("Spieler Einstellungen");
		setBounds(parentFrame.getX() + parentFrame.getWidth() / 2 - 150, parentFrame.getY() + parentFrame.getHeight() / 2 - 90, 300, 180);
		add(new JLabel("Spielername"));
		playerName = new JTextField();
		add(playerName);
	}
}
