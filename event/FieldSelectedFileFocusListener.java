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
 *
 * @author AK
 *
 */
public class FieldSelectedFileFocusListener implements FocusListener {
	private MainFrame mainFrame;

	/**
	 *
	 * @param mainFrame
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
	 *
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
