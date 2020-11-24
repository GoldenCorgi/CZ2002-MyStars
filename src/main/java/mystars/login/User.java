package mystars.login;


/**
 * User class.
 */
public class User {
    private String username;
    private String password;
    // TODO update role /student/admin
    private String role;
    private String salt;

    /**
     * Initializes user using username, password and role
     *
     * @param username of user
     * @param password of user
     * @param role of user
     */
    public User(String username, String password, String role) {
        setName(username);
        setNewPassword(password);
        setRole(role);
    }

    /**
     * Initializes user using username, password and role
     *
     * @param username of user
     * @param password of user
     * @param role of user
     * @param salt of user
     */
    public User(String username, String password, String role, String salt) {
        setName(username);
        this.password = (password);
        setRole(role);
        this.salt = salt;
    }

    /**
     *
     * @return username of user
     */
    public String getName() {
        return this.username;
    }

    /**
     * Set username of user using input
     *
     * @param name Name input by user
     */
    public void setName(String name) {
        this.username = name;
    }

    /**
     *
     * @return Role of user
     */
    public String getRole() {
        return this.role;
    }

    /**
     * Set role of user using input
     *
     * @param role Role input by user
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Set new password for user using input
     *
     * @param password New password input by user
     */
    public void setNewPassword(String password) {
        this.salt = PasswordHandler.generateSalt();
        this.password = PasswordHandler.hashPassword(password, this.salt);
    }

    /**
     * Validate password input by user
     *
     * @param input_password Password input by user
     * @return <code>true</code> if password input is correct, <code>false</code> otherwise
     */
    public boolean validatePassword(String input_password) {
        return PasswordHandler.verifyPassword(input_password, this.password, this.salt);
    }

    /**
     * Returns the <code>User</code> object as a String for printing or writing to a file.
     *
     * @return User's details as a String in a particular format.
     */
    @Override
    public String toString() {
        return (username + "||" + role + "||" + salt + "||" + password);
    }

    /**
     * PasswordHandler to encrypt password and verify password
     */


}
