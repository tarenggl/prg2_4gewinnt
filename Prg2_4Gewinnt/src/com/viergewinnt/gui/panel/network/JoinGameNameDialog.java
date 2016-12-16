package com.viergewinnt.gui.panel.network;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JoinGameNameDialog extends JDialog implements ActionListener {

	public ActionListener al;
	public KeyListener kl;
	public JTextField playerName;
	
	public JoinGameNameDialog(JFrame owner){
		super(owner, ModalityType.APPLICATION_MODAL);
		Font f = new Font("Arial", Font.PLAIN, 20);
		setTitle("Namen eingeben");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initKeyListener();
		setLocation(owner.getX() + owner.getWidth() / 4, owner.getY() + owner.getHeight() / 4);
		setSize(owner.getWidth() / 2, owner.getHeight() / 2);
		setLayout(new GridLayout(2,2));
		JLabel lName = new JLabel("Name:");
		lName.setFont(f);
		add(lName);
		playerName = new JTextField();
		playerName.setFont(f);
		playerName.addKeyListener(kl);
		add(playerName);
		add(new JPanel());
		JButton bOk = new JButton("OK");
		bOk.setFont(f);
		add(bOk);
		bOk.addActionListener(this);
		addKeyListener(kl);	
	}

	private void initKeyListener(){
		kl = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					actionPerformed(null);
				}
			}
		};
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}
	
	public String getPlayerName(){
		return playerName.getText();
	}
}
