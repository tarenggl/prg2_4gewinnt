package com.viergewinnt.gui.panel;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JLabel;

public class GameHeaderLabel extends JLabel {

	public GameHeaderLabel() {
		super();
		initializeLabel();
	}

	public GameHeaderLabel(String arg0) {
		super(arg0);
		initializeLabel();
	}

	public GameHeaderLabel(Icon image) {
		super(image);
		initializeLabel();
	}

	public GameHeaderLabel(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
		initializeLabel();
	}

	public GameHeaderLabel(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
		initializeLabel();
	}

	public GameHeaderLabel(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
		initializeLabel();
	}
	
	public void initializeLabel(){
		this.setPreferredSize(new Dimension(100, 50));
		this.setFont(new Font("Arial", Font.PLAIN, 20));
	}

}
