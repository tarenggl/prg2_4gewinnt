package com.viergewinnt.gui.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.viergewinnt.gui.GameFrame;
import com.viergewinnt.gui.panel.GameMenuPanel;

public class GameMenuBar extends JMenuBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JMenu gameMenu;
	JMenuItem newGameMenu;
	JMenuItem cancelGameMenu;
	
	GameFrame mainFrameContainer;
	
	public GameMenuBar(GameFrame mainFrame) {
		gameMenu = new JMenu("Spiel");
		newGameMenu = new JMenuItem("Neues Spiel..");
		cancelGameMenu = new JMenuItem("Spiel abbrechen");
		gameMenu.add(newGameMenu);
		gameMenu.add(cancelGameMenu);
		add(gameMenu);
		mainFrameContainer = mainFrame;
		initializeNewGameMenu();
	}
	
	private void initializeNewGameMenu() {
		newGameMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrameContainer.SetNewContentPanel(new GameMenuPanel(mainFrameContainer));				
			}
		});
	}
}
