package text.editor.menu;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

import text.editor.menu.actionListener.ExitFileActionListener;

public class EditorMenu {
	private JFrame frame;
	private File file;

	public EditorMenu() {
	}

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
		file.getAccessibleContext().setAccessibleDescription("Contains 'Magic Editor' file options");
		return file;
	}

	private JMenuItem createExitMenuItem() {
		JMenuItem exit = new JMenuItem("Exit");
		exit.getAccessibleContext().setAccessibleDescription("This exits the editor.");
		ExitFileActionListener actionListener = new ExitFileActionListener(frame);
		exit.addActionListener(actionListener);
		return exit;
	}

	private JMenuItem createSaveMenuItem() {
		JMenuItem save = new JMenuItem("Save File");
		save.setMnemonic(KeyEvent.VK_S);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
		save.getAccessibleContext().setAccessibleDescription("This saves a file.");

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					saveFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		return save;

	}

	private void saveFile() throws IOException {
		final JFileChooser fc = new JFileChooser("/");
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		if (file != null) {
			fc.setSelectedFile(file);
			int returnVal = fc.showSaveDialog(new JDialog());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				BufferedWriter out = null;
				try {
					out = new BufferedWriter(new FileWriter(fc.getSelectedFile().getPath()));
					Component[] comp = frame.getContentPane().getComponents();
					for (int i = 0; i < comp.length; i++) {
						System.out.println(comp[i].getClass().toString());
						if (comp[i] instanceof JScrollPane) {
							JScrollPane jScroll = (JScrollPane) comp[i];
							JEditorPane nestedComponents = (JEditorPane) jScroll.getViewport().getView();
							out.write(nestedComponents.getText());
							break;

						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				out.close(); // close the file stream
			}
		}
	}

	private JMenuItem createOpenMenuItem() {
		JMenuItem open = new JMenuItem("Open File");
		open.setMnemonic(KeyEvent.VK_O);
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.ALT_MASK));
		open.getAccessibleContext().setAccessibleDescription("This opens a file.");

		open.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});
		return open;
	}

	private void openFile() {
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
			editorScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			editorScrollPane.setPreferredSize(new Dimension(250, 145));
			editorScrollPane.setMinimumSize(new Dimension(10, 10));
			frame.getContentPane().add(editorScrollPane);
			frame.revalidate();
		} else if (returnVal == JFileChooser.CANCEL_OPTION) {
			System.out.println("User cancelled open file.");
		}

	}

}
