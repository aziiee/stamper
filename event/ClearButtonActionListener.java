package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import view.MainFrame;

/**
 * Used to reset all values in the application such as file path and field values
 *
 * @author AK
 *
 */
public class ClearButtonActionListener implements ActionListener {
	private MainFrame mainFrame;

	/**
	 *
	 * @param mainFrame
	 */
	public ClearButtonActionListener(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	/**
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		if ((e.getSource() instanceof JButton)) {
			for (JTextField field : mainFrame.getAllFields()) {
				field.setText("");
				field.setBorder(mainFrame.getDefaultFieldBorder());
			}

			mainFrame.setFilePath(null);
			mainFrame.getFieldDate().setValue(null);
			mainFrame.getFieldTime().setValue(null);
		}
	}
}
