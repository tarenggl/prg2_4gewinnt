package com.viergewinnt.gui.panel;

import javax.swing.JPanel;

public class JoinGamePanel extends JPanel{

	
	
	
	private void gt() {
		MulticastSocket socket = new MulticastSocket(4446);
		InetAddress group = InetAddress.getByName("203.0.113.0");
		socket.joinGroup(group);
	
		DatagramPacket packet;
		for (int i = 0; i < 5; i++) {
		    byte[] buf = new byte[256];
		    packet = new DatagramPacket(buf, buf.length);
		    socket.receive(packet);
	
		    String received = new String(packet.getData());
		    System.out.println("Quote of the Moment: " + received);
		}
	
		socket.leaveGroup(group);
		socket.close();
	}
}
