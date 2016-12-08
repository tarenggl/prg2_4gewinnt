package com.viergewinnt.gui.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.viergewinnt.gui.GameFrame;
import com.viergewinnt.gui.panel.GameMenuPanel;
import com.viergewinnt.model.GameMenuModel;

public class GameMenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameMenuBar(GameMenuModel model, String menuName) {
		JMenu menu = new JMenu(menuName);
		
		for(String key: model.getMenuActions().keySet()) {
			menu.add(getMenuPoint(key, model.getMenuActions().get(key)));
		}
		add(menu);
	}

	private JMenuItem getMenuPoint(String description, ActionListener actionListener) {
		JMenuItem menuItem = new JMenuItem(description);
		menuItem.addActionListener(actionListener);
		return menuItem;
	}
}
