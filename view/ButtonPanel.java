package view;

import event.ApplyButtonActionListener;
import event.ClearButtonActionListener;
import event.CloseButtonActionListener;
import info.clearthought.layout.TableLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author AK
 *
 */
public class ButtonPanel extends JPanel {
	private JButton buttonClose;
	private JButton buttonApply;
	private JButton buttonClear;
	private TableLayout layout;

	/**
	 *
	 * @param mainFrame
	 */
	public ButtonPanel(MainFrame mainFrame) {
		double[][] sizes = { { 80.0D, 6.0D, 80.0D, 6.0D, 80.0D, -1.0D, 80.0D }, { 22.0D } };
		layout = new TableLayout(sizes);
		setLayout(layout);

		buttonClose = new JButton("Close");
		buttonClose.addActionListener(new CloseButtonActionListener(mainFrame));
		buttonApply = new JButton("Apply");
		buttonApply.addActionListener(new ApplyButtonActionListener(mainFrame));
		buttonClear = new JButton("Clear");
		buttonClear.addActionListener(new ClearButtonActionListener(mainFrame));

		add(buttonApply, "0, 0");
		add(buttonClear, "2, 0");
		add(buttonClose, "6, 0");
	}

	/**
	 *
	 * @return
	 */
	public JButton getButtonClose() {
		return buttonClose;
	}

	/**
	 *
	 * @param buttonClose
	 */
	public void setButtonClose(JButton buttonClose) {
		this.buttonClose = buttonClose;
	}

	/**
	 *
	 * @return
	 */
	public JButton getButtonApply() {
		return buttonApply;
	}

	/**
	 *
	 * @param buttonApply
	 */
	public void setButtonApply(JButton buttonApply) {
		this.buttonApply = buttonApply;
	}

	/**
	 *
	 * @return
	 */
	public JButton getButtonClear() {
		return buttonClear;
	}

	/**
	 *
	 * @param buttonClear
	 */
	public void setButtonClear(JButton buttonClear) {
		this.buttonClear = buttonClear;
	}
}
