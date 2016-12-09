package com.viergewinnt.gui.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.viergewinnt.gameobjects.GameProperties;

public class ChooseGamePropertyDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GameProperties properties;
	private JTextField playerName;
	private JPanel centerPanel;
	private JPanel southPanel;
	private JComboBox<Integer> cRows;
	private JComboBox<Integer> cCols;
	private JButton bOk;
	private final int maxRows = 12;
	private final int minRows = 5;
	private final int maxCols = 12;
	private final int minCols = 5;

	public ChooseGamePropertyDialog(GameProperties properties, JFrame owner) {
		super(owner, ModalityType.APPLICATION_MODAL);
		this.properties = properties;
		setTitle("Spieler Einstellungen");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(owner.getX() + owner.getWidth() / 4, owner.getY() + owner.getHeight() / 4);
		setSize(owner.getWidth() / 2, owner.getHeight() / 2);
		setLayout(new BorderLayout(0,10));
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3, 2, 10, 10));
		add(centerPanel, BorderLayout.CENTER);
		southPanel = new JPanel();
		southPanel.setLayout(new BorderLayout());
		add(southPanel, BorderLayout.SOUTH);
		initializeOptions();
		initializeButtons();
	}

	public void initializeOptions() {
		centerPanel.add(new JLabel("Spielername"));
		playerName = new JTextField();
		centerPanel.add(playerName);
		centerPanel.add(new JLabel("rows"));
		cRows = new JComboBox<>();
		fillComboBox(cRows, minRows, maxRows);
		centerPanel.add(cRows);
		centerPanel.add(new JLabel("cols"));
		cCols = new JComboBox<>();
		fillComboBox(cCols, minCols, maxCols);
		centerPanel.add(cCols);
	}

	public void fillComboBox(JComboBox<Integer> box, int min, int max) {
		for (; min <= max; min++) {
			box.addItem(min);
		}
	}

	public void initializeButtons(){
		bOk = new JButton("OK");
		southPanel.add(bOk, BorderLayout.EAST);
		bOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				properties.setColumns(cCols.getItemAt(cCols.getSelectedIndex()));
				properties.setRows(cRows.getItemAt(cRows.getSelectedIndex()));
				closeDialog();
			}
		});
		
	}
	private void closeDialog(){
		dispose();
	}
}
