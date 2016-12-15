package com.viergewinnt.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.viergewinnt.gui.menubar.GameMenuBar;
import com.viergewinnt.gui.panel.GameMenuPanel;
import com.viergewinnt.model.GameMenuModel;

public class GameFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameFrame(){
			super();
			this.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2 - (Toolkit.getDefaultToolkit().getScreenSize().height - 100)/2 , 0, Toolkit.getDefaultToolkit().getScreenSize().height - 100 ,Toolkit.getDefaultToolkit().getScreenSize().height);
			this.setTitle("4-Gewinnt");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
	}
	
	public void SetNewContentPanel(JPanel container){
		Dimension d = getContentPane().getSize();
		setContentPane(container);
		getContentPane().setPreferredSize(d);
		pack();
	}
}
