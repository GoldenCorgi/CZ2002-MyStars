package mystars.login;

/**
 * User class.
 */
public class User {

    private String username;
    private String password;
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


}
