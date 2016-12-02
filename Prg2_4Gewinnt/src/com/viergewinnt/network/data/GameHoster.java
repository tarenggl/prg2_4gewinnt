package com.viergewinnt.network.data;

import java.io.Serializable;

public class GameHoster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String gameName;
	private String hostAddress;
	private int gamePort;
	
	public GameHoster(String gameName, String hostAddress, int gamePort) {
		setGameName(gameName);
		setHostAddress(hostAddress);
		setGamePort(gamePort);
	}
	
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getHostAddress() {
		return hostAddress;
	}

	public void setHostAddress(String hostAddress) {
		this.hostAddress = hostAddress;
	}
	
	@Override
	public String toString() {
		return getGameName() + " - " + getHostAddress();
	}

	public int getGamePort() {
		return gamePort;
	}

	public void setGamePort(int gamePort) {
		this.gamePort = gamePort;
	}

}
