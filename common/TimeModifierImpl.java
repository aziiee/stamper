package common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 *
 * @author AK
 *
 */
public class TimeModifierImpl implements TimeModifier {
	private Path path;
	private FileTime timeChanged;
	private SuccessValidator successValidator;

	/**
	 *
	 * @param filePath
	 * @param newDate
	 * @param newTime
	 */
	public TimeModifierImpl(String filePath, String newDate, String newTime) {
		path = Paths.get(filePath, new String[0]);

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.GERMANY);
		try {
			Date tempDate = dateFormat.parse(newDate + " " + newTime);
			timeChanged = FileTime.fromMillis(tempDate.getTime());

			successValidator = new SuccessValidator(path, timeChanged);
		} catch (ParseException e) {
			showErrorMessage("Date Conversion error", e.getMessage());
		}
	}

	/**
	 *
	 */
	public void changeModifiedTime() {
		try {
			Files.setAttribute(path, "lastModifiedTime", timeChanged, new LinkOption[0]);
			boolean success = successValidator.validateModification("lastModifiedTime");

			if (success) {
				JOptionPane.showMessageDialog(null, "Success", "Success", 1);
			}
		} catch (IOException e) {
			showErrorMessage("Modified time error", e.getMessage());
		}
	}

	/**
	 *
	 */
	public void changeAccessTime() {
		try {
			Files.setAttribute(path, "lastAccessTime", timeChanged, new LinkOption[0]);
			boolean success = successValidator.validateModification("lastAccessTime");

			if (success) {
				JOptionPane.showMessageDialog(null, "Success", "Success", 1);
			}
		} catch (IOException e) {
			showErrorMessage("Access time error", e.getMessage());
		}
	}

	/**
	 *
	 */
	public void changeCreationTime() {
		try {
			Files.setAttribute(path, "creationTime", timeChanged, new LinkOption[0]);
			boolean success = successValidator.validateModification("creationTime");

			if (success) {
				JOptionPane.showMessageDialog(null, "Success", "Success", 1);
			}
		} catch (IOException e) {
			showErrorMessage("Creation time error", e.getMessage());
		}
	}

	/**
	 *
	 * @param title
	 * @param message
	 */
	private void showErrorMessage(String title, String message) {
		JOptionPane.showMessageDialog(null, message, title, 0);
	}
}
