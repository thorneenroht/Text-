package text.editor.menu.actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class ExitFileActionListener implements ActionListener {
	private JFrame frame;

	public ExitFileActionListener(JFrame frame){
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Called close from menu.");
		frame.dispose();
		
	}
}
