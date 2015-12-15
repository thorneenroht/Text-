package text.editor.runner;

import javax.swing.SwingUtilities;

import text.editor.TextEditor;

public class TextEditorRunner {

	public static void main(String[] args){
		SwingUtilities.invokeLater(new TextEditor());
	}
}
