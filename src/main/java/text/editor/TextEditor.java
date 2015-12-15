package text.editor;

import java.awt.Component;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import text.editor.menu.EditorMenu;

public class TextEditor extends JFrame implements Runnable{

	private JFrame frame;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String TITLE = "Magic Editor";
	
	private static final boolean VISIBLE = true;
	
	private static final int WIDTH = 800;
	
	private static final int HEIGHT = 800;
	
	public TextEditor(){}
	
	public void run() {
		initGui();
		
	}

	private void initGui() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMenuBar();
		frame.setSize(WIDTH, HEIGHT);
		frame.setTitle(TITLE);
		frame.setVisible(VISIBLE);
		
	}
		
	private void setMenuBar() {
		EditorMenu em = new EditorMenu(frame);
		frame.setJMenuBar(em.createMenuBar());
	}

	public JFrame getFrame(){
		return frame;
	}

	

	
}
