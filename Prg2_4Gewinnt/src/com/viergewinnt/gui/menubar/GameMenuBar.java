package com.viergewinnt.gui.menubar;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.viergewinnt.gui.panel.CreateGamePanel;

public class GameMenuBar extends JMenuBar{

	JMenu gameMenu;
	JMenuItem newGameMenu;
	JMenuItem cancelGameMenu;
	
	JFrame mainFrameContainer;
	
	public GameMenuBar(JFrame mainFrame) {
		gameMenu = new JMenu("Spiel");
		newGameMenu = new JMenuItem("Neues Spiel..");
		cancelGameMenu = new JMenuItem("Siel abbrechen");
		gameMenu.add(newGameMenu);
		gameMenu.add(cancelGameMenu);
		add(gameMenu);
		mainFrameContainer = mainFrame;
	}
	
	private void initializeNewGameMenu() {
		newGameMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CreateGamePanel panel = new CreateGamePanel();
				mainFrameContainer.setContentPane(panel);
				panel.initialize();
			}
		});
	}
}
