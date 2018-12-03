package event;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import view.MainFrame;

/**
 * This class is used to create a red border around the File path TextFie if the given file path doesn't
 * exist
 *
 * @author AK
 *
 */
public class FieldSelectedFileFocusListener implements FocusListener {
	private MainFrame mainFrame;

	/**
	 * Constructor
	 *
	 * @param mainFrame Is needed to access the TextField
	 */
	public FieldSelectedFileFocusListener(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	/**
	 *
	 */
	public void focusGained(FocusEvent arg0) {
	}

	/**
	 * Whenever the focus is lost on the File path TextField, the given path is checked and an appropriate
	 * border is set on the TextField
	 */
	public void focusLost(FocusEvent fe) {
		if ((fe.getSource() instanceof JTextField)) {
			JTextField field = (JTextField) fe.getSource();
			Path path = Paths.get(field.getText(), new String[0]);
			mainFrame.setFilePath(field.getText());
			if (Files.exists(path, new LinkOption[0])) {
				mainFrame.getFieldSelectedFile().setBorder(mainFrame.getDefaultFieldBorder());
			} else {
				mainFrame.getFieldSelectedFile().setBorder(BorderFactory.createLineBorder(Color.RED, 1));
			}
		}
	}
}
