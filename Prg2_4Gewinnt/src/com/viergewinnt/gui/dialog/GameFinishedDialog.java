package com.viergewinnt.gui.dialog;

import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameFinishedDialog extends JDialog {

	public GameFinishedDialog(String winner,JFrame owner) {
		super();
		Font f = new Font("Arial", Font.PLAIN, 20);
		setTitle("Spiel beendet");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(owner.getX() + owner.getWidth() / 4, owner.getY() + owner.getHeight() / 4);
		setSize(owner.getWidth() / 2, owner.getHeight() / 2);
		JLabel label = new JLabel(winner + " hat gewonnen.");
		add(label);
		
	}

}
