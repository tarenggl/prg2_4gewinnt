package com.viergewinnt.gui.dialog;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChooseFileDialog extends JFrame
{
	private static final long serialVersionUID = 1L;
	static JFileChooser fileChooser = new JFileChooser();
	private static String timestamp  = null;

   public ChooseFileDialog(String title)
   {
      super(title);
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      JPanel pnl = new JPanel();
      pnl.setLayout(new GridLayout(2, 1));

      JButton btnOpen= new JButton("Öffnen");
      ActionListener al;
      al = new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent ae)
              {
                 switch (fileChooser.showOpenDialog(ChooseFileDialog.this))
                 {
                    case JFileChooser.APPROVE_OPTION:
                       //JOptionPane.showMessageDialog(ChooseFileDialog.this, "Selected: " + fileChooser.getSelectedFile(), "ChooseFileDialog", JOptionPane.OK_OPTION);
                       importGameFromFile();
                       break;

                    case JFileChooser.CANCEL_OPTION:
                       JOptionPane.showMessageDialog(ChooseFileDialog.this, "Cancelled", "ChooseFileDialog", JOptionPane.OK_OPTION);
                       break;
                 
                    case JFileChooser.ERROR_OPTION:
                       JOptionPane.showMessageDialog(ChooseFileDialog.this, "Error", "ChooseFileDialog", JOptionPane.OK_OPTION);
                 }
              }
           };
           
      btnOpen.addActionListener(al);
      pnl.add(btnOpen);

      JButton btnSave = new JButton("Speichern");
      al = new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent ae)
              {
                 switch (fileChooser.showSaveDialog(ChooseFileDialog.this))
                 {
                    case JFileChooser.APPROVE_OPTION:
                       //JOptionPane.showMessageDialog(ChooseFileDialog.this, "Selected: " + fileChooser.getSelectedFile(), "ChooseFileDialog", JOptionPane.OK_OPTION);
                       exportGameToFile(fileChooser.getSelectedFile());
                       break;

                    case JFileChooser.CANCEL_OPTION:
                       JOptionPane.showMessageDialog(ChooseFileDialog.this, "Cancelled", "ChooseFileDialog", JOptionPane.OK_OPTION);
                       break;
                 
                    case JFileChooser.ERROR_OPTION:
                       JOptionPane.showMessageDialog(ChooseFileDialog.this, "Error", "ChooseFileDialog", JOptionPane.OK_OPTION);
                 }
              }
           };
           btnSave.addActionListener(al);
      pnl.add(btnSave);

      setContentPane(pnl);

      pack();
      setVisible(true);
   }

   
 //Lesen
 	public static Object importGameFromFile() {
 	Object TEMP = null;
 	try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileChooser.getSelectedFile()))) {
 		final Object object = objectInputStream.readObject();
 		if (object instanceof Object) {
 			TEMP = (Object) object;
 		}
 	} catch (IOException | ClassNotFoundException exception) {
 		exception.printStackTrace();
 	}
 	return TEMP;
 	}
 	
 	
 	public static void exportGameToFile(final Object TEMP) {
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(timestamp+".txt"))) {
			objectOutputStream.writeObject(TEMP);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
 	
 	
 	/*Temporäre Main-Methode für Tests*/
 	public static void main(String[] args)
    {
       Runnable r = new Runnable()
                    {
                       @Override
                       public void run()
                       {
                          new ChooseFileDialog("Spielstand speichern/laden");
                       }
                    };
       EventQueue.invokeLater(r);
    }
 
}