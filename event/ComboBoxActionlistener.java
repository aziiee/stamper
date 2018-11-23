package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import view.MainFrame;

/**
 *
 * @author AK
 *
 */
public class ComboBoxActionlistener implements ActionListener {
	private MainFrame mainFrame;

	/**
	 *
	 * @param mainFrame
	 */
	public ComboBoxActionlistener(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	/**
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		if ((e.getSource() instanceof JComboBox)) {
			System.out.println(mainFrame.getComboBoxAction().getSelectedItem());
		}
	}
}
