package event;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import view.MainFrame;

/**
 *
 * @author AK
 *
 */
public class BrowseButtonListener implements ActionListener {
	private MainFrame mainFrame;

	/**
	 *
	 * @param mainFrame
	 */
	public BrowseButtonListener(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	/**
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		if ((e.getSource() instanceof JButton)) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			fileChooser.setMultiSelectionEnabled(false);
			int retVal = fileChooser.showOpenDialog((Component) e.getSource());

			if (retVal == 0) {
				try {
					mainFrame.setFilePath(fileChooser.getSelectedFile().getAbsolutePath());
					mainFrame.getFieldSelectedFile().setText(fileChooser.getSelectedFile().getName());
					mainFrame.getFieldSelectedFile().setBorder(mainFrame.getDefaultFieldBorder());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(mainFrame, "Could not access file", "An Error occured",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}
