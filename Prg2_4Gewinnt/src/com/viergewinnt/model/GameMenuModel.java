package com.viergewinnt.model;

import java.awt.event.ActionListener;
import java.util.Hashtable;

public class GameMenuModel {

	private Hashtable<String, ActionListener> menuActions;

	public Hashtable<String, ActionListener> getMenuActions() {
		return menuActions;
	}

	public void setMenuActions(Hashtable<String, ActionListener> menuActions) {
		this.menuActions = menuActions;
	}
}
