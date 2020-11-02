package mystars.login;

import java.time.format.DateTimeFormatter;

/**
 * User class.
 */
public class User {

    private String username;
    private String password;
    // TODO update role /student/admin
    private String role;

    public User(String username, String password) {
        setName(username);
        setPassword(password);
    }

    public String getName() {
        return this.username;
    }

    public void setName(String name) {
        this.username = name;
    }

    /** TODO HASHING **/
    public String getPasswordHash() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Returns the <code>User</code> object as a String for printing or writing to a file.
     *
     * @return User's details as a String in a particular format.
     */
    @Override
    public String toString() {
        return (username + ", " + password);
    }


}
