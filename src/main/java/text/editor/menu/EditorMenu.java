package text.editor.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import text.editor.menu.actionListener.OpenFileActionListener;

public class EditorMenu {
	private JFrame frame;
	
	public EditorMenu() {}

	public EditorMenu(JFrame frame) {
		this.frame = frame;
	}

	public JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(createFileMenuItem());
		menuBar.add(createEditMenuItem());
		return menuBar;
	}
	
	private JMenu createEditMenuItem() {
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		return edit;
	}

	private JMenu createFileMenuItem() {
		JMenu file = new JMenu("File");
		file.add(createOpenMenuItem());
		
		
		
		
		file.setMnemonic(KeyEvent.VK_F);
		file.getAccessibleContext().setAccessibleDescription(
		        "Contains 'Magic Editor' file options");		
		return file;
	}

	private JMenuItem createOpenMenuItem() {
		JMenuItem open = new JMenuItem("Open File");
		open.setMnemonic(KeyEvent.VK_O);
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.ALT_MASK));
		open.getAccessibleContext().setAccessibleDescription(
		        "This opens a file.");
		OpenFileActionListener actionListener = new OpenFileActionListener(frame);
		open.addActionListener(actionListener);
		return open;
	}

	
}
