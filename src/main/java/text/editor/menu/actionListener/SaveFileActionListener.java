package text.editor.menu.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class SaveFileActionListener implements ActionListener{

	private JFrame frame;
	
	private File file;
	
	public SaveFileActionListener(JFrame frame, File file) {
		this.frame = frame;
		this.file = file;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("Save menu item called.");
		final JFileChooser fc = new JFileChooser("/");
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				
		int returnVal = fc.showSaveDialog(new JDialog());
		
		if(returnVal == JFileChooser.APPROVE_OPTION){
			
		}
		
		
		
		
	}

}
