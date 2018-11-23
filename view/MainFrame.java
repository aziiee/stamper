package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import org.jdesktop.xswingx.PromptSupport;

import common.Actions;
import event.BrowseButtonListener;
import event.ComboBoxActionlistener;
import event.FieldSelectedFileFocusListener;
import event.FieldSelectedFileMouseListener;
import info.clearthought.layout.TableLayout;

/**
 *
 * @author AK
 *
 */
public class MainFrame extends JFrame {
	private TableLayout layout;
	private JLabel labelAction;
	private JLabel labelChooseFile;
	private JLabel labelNewDate;
	private JLabel labelNewTime;
	private JTextField fieldSelectedFile;
	private JFormattedTextField fieldDate;
	private JFormattedTextField fieldTime;
	private String filePath;
	private List<JTextField> allFields;
	private JButton buttonBrowse;
	private ButtonPanel buttonPanel;
	private JPanel mainPanel;
	private JComboBox<String> comboBoxAction;

	/**
	 *
	 */
	public MainFrame() {
		super("File Manipulator");

		// Grid for the TableLayout
		double[][] sizes = { { 10.0D, 100.0D, -1.0D, 150.0D, 6.0D, 100.0D, 6.0D, 80.0D, 10.0D },
				{ 10.0D, 22.0D, 10.0D, 22.0D, 10.0D, 22.0D, 10.0D, 22.0D, -1.0D, 10.0D, 22.0D, 10.0D } };
		layout = new TableLayout(sizes);

		mainPanel = new JPanel();

		labelAction = new JLabel("Action");
		labelChooseFile = new JLabel("File");
		labelNewDate = new JLabel("New date");
		labelNewTime = new JLabel("New time");

		comboBoxAction = new JComboBox<String>(Actions.getAllActions());
		comboBoxAction.addActionListener(new ComboBoxActionlistener(this));

		fieldSelectedFile = new JTextField();
		PromptSupport.setPrompt("File path", fieldSelectedFile);
		fieldSelectedFile.setDragEnabled(true);
		fieldSelectedFile.addFocusListener(new FieldSelectedFileFocusListener(this));
		fieldSelectedFile.addMouseListener(new FieldSelectedFileMouseListener());

		fieldDate = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
		PromptSupport.setPrompt("dd/mm/yyyy", fieldDate);

		fieldTime = new JFormattedTextField(new SimpleDateFormat("HH:mm:ss"));
		PromptSupport.setPrompt("HH:mm:ss", fieldTime);

		allFields = new ArrayList<JTextField>();
		allFields.add(fieldSelectedFile);
		allFields.add(fieldDate);
		allFields.add(fieldTime);

		buttonBrowse = new JButton("Browse");
		buttonBrowse.addActionListener(new BrowseButtonListener(this));

		buttonPanel = new ButtonPanel(this);

		mainPanel.setLayout(layout);

		mainPanel.add(labelAction, "1, 1");
		mainPanel.add(comboBoxAction, "3, 1");
		mainPanel.add(labelChooseFile, "1, 3");
		mainPanel.add(fieldSelectedFile, "3, 3, 5, 3");
		mainPanel.add(buttonBrowse, "7, 3");
		mainPanel.add(labelNewDate, "1, 5");
		mainPanel.add(fieldDate, "3, 5");
		mainPanel.add(labelNewTime, "1, 7");
		mainPanel.add(fieldTime, "3, 7");
		mainPanel.add(buttonPanel, "1, 10, 7, 10");

		getContentPane().add(mainPanel);
	}

	/**
	 *
	 * @return
	 */
	public Border getDefaultFieldBorder() {
		return new JTextField().getBorder();
	}

	/**
	 *
	 * @return
	 */
	public JTextField getFieldSelectedFile() {
		return fieldSelectedFile;
	}

	/**
	 *
	 * @param fieldSelectedFile
	 */
	public void setFieldSelectedFile(JTextField fieldSelectedFile) {
		this.fieldSelectedFile = fieldSelectedFile;
	}

	/**
	 *
	 * @return
	 */
	public JFormattedTextField getFieldDate() {
		return fieldDate;
	}

	/**
	 *
	 * @param fieldDate
	 */
	public void setFieldDate(JFormattedTextField fieldDate) {
		this.fieldDate = fieldDate;
	}

	/**
	 *
	 * @return
	 */
	public JFormattedTextField getFieldTime() {
		return fieldTime;
	}

	/**
	 *
	 * @param fieldTime
	 */
	public void setFieldTime(JFormattedTextField fieldTime) {
		this.fieldTime = fieldTime;
	}

	/**
	 *
	 * @return
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 *
	 * @param filePath
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 *
	 * @return
	 */
	public List<JTextField> getAllFields() {
		return allFields;
	}

	/**
	 *
	 * @return
	 */
	public JComboBox<String> getComboBoxAction() {
		return comboBoxAction;
	}

	/**
	 *
	 * @param comboBoxAction
	 */
	public void setComboBoxAction(JComboBox<String> comboBoxAction) {
		this.comboBoxAction = comboBoxAction;
	}

	/**
	 *
	 * @return
	 */
	public ButtonPanel getButtonPanel() {
		return buttonPanel;
	}

	/**
	 *
	 * @param buttonPanel
	 */
	public void setButtonPanel(ButtonPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}
}
