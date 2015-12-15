package text.editor.menu.actionListener;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class OpenFileActionListener implements ActionListener {

	private JFrame frame;
	
	private File file;

	public OpenFileActionListener() {
	}

	public OpenFileActionListener(JFrame frame, File file) {
		this.frame = frame;
		this.file = file;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("Open actionPerformed");
		final JFileChooser fc = new JFileChooser("/");
		JEditorPane editorpane = new JEditorPane();
		int returnVal = fc.showOpenDialog(new JDialog());

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			 file = fc.getSelectedFile();
			if (file != null) {
				try {
					editorpane.setPage(file.toURL());
					editorpane.setVisible(true);

				}

				catch (IOException ex) {
					System.err.println("Attempted to read a bad file " + file);
					ex.printStackTrace();
				}
			}

			else {
				System.err.println("Couldn't find file");
			}
			JScrollPane editorScrollPane = new JScrollPane(editorpane);
			editorScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			editorScrollPane.setPreferredSize(new Dimension(250, 145));
			editorScrollPane.setMinimumSize(new Dimension(10, 10));
			frame.getContentPane().add(editorScrollPane);
			frame.revalidate();
		}else if (returnVal == JFileChooser.CANCEL_OPTION){
			System.out.println("User cancelled open file.");
		}

	}

}
