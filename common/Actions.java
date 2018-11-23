package common;

/**
 * This class defines all actions which can be executed on a selected file
 *
 * @author AK
 *
 */
public class Actions {
	public static final String PLEASE_SELECT = "-- Please select --";
	public static final String CREATION_TIME = "Creation time";
	public static final String ACCESS_TIME = "Last access time";
	public static final String MODIFIED_TIME = "Last modification time";

	public static String[] getAllActions() {
		String[] actions = { "-- Please select --", "Creation time", "Last access time", "Last modification time" };

		return actions;
	}
}
