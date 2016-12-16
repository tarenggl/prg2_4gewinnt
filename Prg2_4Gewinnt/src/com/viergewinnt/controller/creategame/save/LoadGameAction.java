package com.viergewinnt.controller.creategame.save;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.viergewinnt.controller.playgame.PlayComputerGameController;
import com.viergewinnt.controller.playgame.PlayLoadedGameController;
import com.viergewinnt.gameobjects.SaveGame;
import com.viergewinnt.gui.GameFrame;

public class LoadGameAction implements ActionListener{

	private JFileChooser fileChooser;
	private GameFrame parent;
	
	public LoadGameAction (GameFrame parent) {
		this.fileChooser = new JFileChooser();
		this.parent = parent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (fileChooser.showOpenDialog(parent))
        {
           case JFileChooser.APPROVE_OPTION:
              load(fileChooser.getSelectedFile().getAbsolutePath());
              break;
           case JFileChooser.ERROR_OPTION:
              JOptionPane.showMessageDialog(fileChooser, "Error", "ChooseFileDialog", JOptionPane.OK_OPTION);
        }
	}
	
	private void load(String file) {
	 	try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
	 		SaveGame loadedGame = (SaveGame)objectInputStream.readObject();
	 		new PlayLoadedGameController(parent, loadedGame).show();
	 	} catch (IOException | ClassNotFoundException exception) {
	 		exception.printStackTrace();
	 	}
 	}

}
