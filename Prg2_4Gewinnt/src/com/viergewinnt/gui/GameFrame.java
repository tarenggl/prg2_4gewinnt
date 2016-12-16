package com.viergewinnt.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.viergewinnt.gameobjects.SaveGame;
import com.viergewinnt.gui.base.Sizeable;

public class GameFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SaveGame currentGame;
	
	public GameFrame(){
			super();
			this.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2 - (Toolkit.getDefaultToolkit().getScreenSize().height - 300)/2 , 100, Toolkit.getDefaultToolkit().getScreenSize().height - 300 ,Toolkit.getDefaultToolkit().getScreenSize().height - 200);
			this.setTitle("4-Gewinnt");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
	}
	
	public void SetNewContentPanel(Sizeable container, SaveGame currentGame){
		Dimension d = getContentPane().getSize();
		setContentPane(container);
		getContentPane().setPreferredSize(d);
		pack();
		container.orderComponents();
		this.currentGame = currentGame;
	}
	
	public void SetNewContentPanel(Sizeable container){
		SetNewContentPanel(container, null);
	}
	
	public SaveGame getCurrentGame() {
		return currentGame;
	}
}
