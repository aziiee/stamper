package common;

/**
 * This interface all methods which are used for the individual actions
 * @author AK
 *
 */
public abstract interface TimeModifier {

	/**
	 * Used to change the modification time stamp of a file
	 */
	public abstract void changeModifiedTime();

	/**
	 * Used to change the access time stamp of a file
	 */
	public abstract void changeAccessTime();

	/**
	 * Used to change the creation time stamp of a file
	 */
	public abstract void changeCreationTime();
}
