package movieConnect;

/**
 * Represents a user in the Movie Connect application.
 * Each user has a username and password for authentication.
 * 
 * @author Kamdon Bird, Haiyang Liu
 * @version 1.0
 */
public class User {
	private String username;
	private String password;

	/**
     * Constructs a User object with the specified username and password.
     *
     * @param username The username of the user.
     * @param password The password associated with the username.
     */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
     * Gets the username of the user.
     *
     * @return The username.
     */
	public String getUsername() {
		return username;
	}

	/**
     * Sets the username for the user.
     *
     * @param username The new username to be set.
     */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
     * Gets the password associated with the user.
     *
     * @return The user's password.
     */
	public String getPassword() {
		return password;
	}

	/**
     * Sets the password for the user.
     *
     * @param password The new password to be set.
     */
	public void setPassword(String password) {
		this.password = password;
	}
}
