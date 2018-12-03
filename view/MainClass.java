package view;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * This is the Main class of the application which creates and the {@link MainFrame} and sets
 * the look and feel
 *
 * @author AK
 *
 */
public class MainClass {

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		MainFrame frame = new MainFrame();

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(frame, "Couldn't set look and feel");
		}
		// Frame options
		frame.setDefaultCloseOperation(3);
		frame.setBounds(400, 400, 500, 200);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
