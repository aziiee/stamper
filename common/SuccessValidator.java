package common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;

import javax.swing.JOptionPane;

/**
 * This class validates the executed action by the user
 *
 * @author AK
 *
 */
public class SuccessValidator {
	private Path path;
	private FileTime newTimeStamp;

	/**
	 * Constructor
	 *
	 * @param path path of the file to be manipulated
	 * @param fileTime the new time stamp
	 */
	public SuccessValidator(Path path, FileTime fileTime) {
		this.path = path;
		newTimeStamp = fileTime;
	}

	/**
	 * This method takes the responsibility of the validation of the executed action
	 *
	 * @param action Action to be executed from {@link Actions}
	 * @return True if validated successfully, false if not
	 */
	public boolean validateModification(String action) {
		boolean result = false;
		try {
			if (Files.getAttribute(path, action, new LinkOption[0]).toString().equals(newTimeStamp.toString())) {
				result = true;
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, NotificationMessages.VALIDATION_ERROR, "An error occured", JOptionPane.ERROR_MESSAGE);
		}
		return result;
	}
}
