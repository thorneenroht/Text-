package text.editor;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import text.editor.menu.EditorMenu;

public class TextEditor extends JFrame implements Runnable{

	private JFrame frame;
	private JTabbedPane tab;
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
		setContentPane();
		setMenuBar();
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setTitle(TITLE);
		frame.setVisible(VISIBLE);
		
	}
		
	private void setContentPane() {
		tab = new JTabbedPane();
		
		tab.addTab("New Tab",new JScrollPane(new JEditorPane()));
		frame.setContentPane(tab);
		
	}

	private void setMenuBar() {
		EditorMenu em = new EditorMenu(frame, tab);
		frame.setJMenuBar(em.createMenuBar());
	}

	public JFrame getFrame(){
		return frame;
	}

	

	
}
