package text.editor.menu;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import text.editor.menu.actionListener.ExitFileActionListener;
import text.editor.menu.actionListener.OpenFileActionListener;
import text.editor.menu.actionListener.SaveFileActionListener;

public class EditorMenu {
	private JFrame frame;
	private File file = new File("");;
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
		file.add(createSaveMenuItem());
		file.add(createExitMenuItem());
		
		
		file.setMnemonic(KeyEvent.VK_F);
		file.getAccessibleContext().setAccessibleDescription(
		        "Contains 'Magic Editor' file options");		
		return file;
	}

	private JMenuItem createExitMenuItem() {
		JMenuItem exit = new JMenuItem("Exit");
		exit.getAccessibleContext().setAccessibleDescription(
		        "This exits the editor.");
		ExitFileActionListener actionListener = new ExitFileActionListener(frame);
		exit.addActionListener(actionListener);
		return exit;
	}

	private JMenuItem createSaveMenuItem() {
		JMenuItem save = new JMenuItem("Save File");
		save.setMnemonic(KeyEvent.VK_S);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
		save.getAccessibleContext().setAccessibleDescription(
		        "This saves a file.");
		SaveFileActionListener actionListener = new SaveFileActionListener(frame, file);
		save.addActionListener(actionListener);
		return save;
	
	}

	private JMenuItem createOpenMenuItem() {
		JMenuItem open = new JMenuItem("Open File");
		open.setMnemonic(KeyEvent.VK_O);
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.ALT_MASK));
		open.getAccessibleContext().setAccessibleDescription(
		        "This opens a file.");
		OpenFileActionListener actionListener = new OpenFileActionListener(frame, file);
		open.addActionListener(actionListener);
		return open;
	}

	
}
