package text.editor.menu;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class EditorMenu {
	
	public EditorMenu() {}

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
		return open;
	}

	
}
