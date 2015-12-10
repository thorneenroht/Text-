package text.editor;

import java.awt.Component;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import text.editor.menu.EditorMenu;

public class TextEditor extends JFrame{

	private JFrame frame;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String TITLE = "Magic Editor";
	
	private static final boolean VISIBLE = true;
	
	private static final int WIDTH = 500;
	
	private static final int HEIGHT = 500;
	
	public TextEditor(){
		initGui();
	}

	private void initGui() {
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane();
		setMenuBar();
		
		
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setTitle(TITLE);
		//frame.pack();
		frame.setVisible(VISIBLE);
		
	}
	
	public void setContentPane(){
		frame.setContentPane(createContentPane());
		
	}
	
	private Container createContentPane() {
		JPanel contentPane = new JPanel();
		contentPane.setName("Content");
		contentPane.setBorder(BorderFactory.createEmptyBorder());
		contentPane.add(createTextArea());
		
	
		return contentPane;
	}

	private Component createTextArea() {
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(true);
		textArea.setText("Edit this");
		textArea.setBounds(50,50,150,150);
		textArea.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		return textArea;
	}

	private void setMenuBar() {
		EditorMenu em = new EditorMenu();
		frame.setJMenuBar(em.createMenuBar());
	}

	

	public JFrame getFrame(){
		return frame;
	}

	
}
