package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import view.MainFrame;

/**
 *
 * @author AK
 *
 */
public class CloseButtonActionListener implements ActionListener {
	private MainFrame mainFrame;

	/**
	 *
	 * @param mainFrame
	 */
	public CloseButtonActionListener(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	/**
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		if ((e.getSource() instanceof JButton)) {
			mainFrame.dispose();
		}
	}
}
