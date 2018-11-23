package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import common.Actions;
import common.TimeModifier;
import common.TimeModifierImpl;
import view.MainFrame;

/**
 *
 * @author AK
 *
 */
public class ApplyButtonActionListener implements ActionListener {
	private MainFrame mainFrame;
	private TimeModifier timeModifier;

	/**
	 *
	 * @param mainFrame
	 */
	public ApplyButtonActionListener(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	/**
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		if ((e.getSource() instanceof JButton)) {

			String error = validateFields();
			if (!error.equals("No error")) {
				JOptionPane.showMessageDialog(mainFrame, error, "An error occured", JOptionPane.ERROR_MESSAGE);
				return;
			}

			String path = mainFrame.getFilePath();

			timeModifier = new TimeModifierImpl(path, mainFrame.getFieldDate().getText(),
					mainFrame.getFieldTime().getText());

			switch (mainFrame.getComboBoxAction().getSelectedItem().toString()) {
			case Actions.CREATION_TIME:
				timeModifier.changeCreationTime();
				break;
			case Actions.ACCESS_TIME:
				timeModifier.changeAccessTime();
				break;
			case Actions.MODIFIED_TIME:
				timeModifier.changeModifiedTime();
				break;
			case Actions.PLEASE_SELECT:
				JOptionPane.showMessageDialog(mainFrame, "Please select an action to be executed", "An error occured",
						JOptionPane.WARNING_MESSAGE);
				break;
			}
		}
	}

	/**
	 *
	 * @return
	 */
	private String validateFields() {
		String error = null;
		for (JTextField field : mainFrame.getAllFields()) {
			if (field.getText().equals("")) {
				return "All fields must be filled out";
			}
		}

		if (!Files.exists(Paths.get(mainFrame.getFilePath()))) {
			error = "File doesn't exist";
		} else if (!mainFrame.getFieldDate().getText().matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
			error = "Date is invalid";
		} else if (!mainFrame.getFieldTime().getText().matches("([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]")) {
			error = "Time is invalid";
		} else {
			error = "No error";
		}
		return error;
	}
}
