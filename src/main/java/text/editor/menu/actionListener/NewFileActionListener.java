package text.editor.menu.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JDialog;
import javax.swing.JFileChooser;

public class NewFileActionListener implements ActionListener {

	public NewFileActionListener(){}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("actionPerformed");
		final JFileChooser fc = new JFileChooser("/");
		
	        int returnVal = fc.showOpenDialog(new JDialog());

	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	            File file = fc.getSelectedFile();
	          
	          
	        } 
	}

}
