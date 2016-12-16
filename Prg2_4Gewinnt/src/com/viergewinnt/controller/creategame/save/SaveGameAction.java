package com.viergewinnt.controller.creategame.save;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.viergewinnt.gameobjects.SaveGame;

public class SaveGameAction implements ActionListener{

	private SaveGame saveGame;
	private JFileChooser fileChooser;
	private JFrame parent;
	
	public SaveGameAction (SaveGame saveGame, JFrame parent) {
		this.saveGame = saveGame;
		this.fileChooser = new JFileChooser();
		this.parent = parent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (fileChooser.showSaveDialog(parent))
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
			objectOutputStream.writeObject(saveGame);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

}
