package com.viergewinnt.gui;

import java.awt.Toolkit;
import javax.swing.JFrame;

import com.viergewinnt.gui.menubar.GameMenuBar;
import com.viergewinnt.gui.panel.CreateGamePanel;

public class GameFrame extends JFrame{

	public GameFrame(){
			super();
			this.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/4 ,Toolkit.getDefaultToolkit().getScreenSize().height/4, Toolkit.getDefaultToolkit().getScreenSize().width/2 ,Toolkit.getDefaultToolkit().getScreenSize().height/2);
			this.setTitle("4-Gewinnt");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setJMenuBar(new GameMenuBar(this));
			CreateGamePanel panel = new CreateGamePanel();
			this.setContentPane(panel);
			this.setVisible(true);
			panel.initialize();
			
	}
}
