package com.viergewinnt.controller.creategame.save;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.viergewinnt.gui.GameFrame;

public class SaveGameAction implements ActionListener{

	private JFileChooser fileChooser;
	private GameFrame gameFrame;
	
	public SaveGameAction (GameFrame gameFrame) {
		this.fileChooser = new JFileChooser();
		this.gameFrame = gameFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (fileChooser.showSaveDialog(gameFrame))
        {
           case JFileChooser.APPROVE_OPTION:
              save(fileChooser.getSelectedFile().getAbsolutePath());
              break;
           case JFileChooser.ERROR_OPTION:
              JOptionPane.showMessageDialog(fileChooser, "Error", "ChooseFileDialog", JOptionPane.OK_OPTION);
        }
	}
	
	private void save(String fileName) {
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
			objectOutputStream.writeObject(gameFrame.getCurrentGame());
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

}
