package mystars.login;

import java.util.ArrayList;


/**
 * Contains ArrayList of users.
 */
public class UserList {

    private final ArrayList<User> users;

    /**
     * Initializes users ArrayList.
     */
    public UserList() {
        users = new ArrayList<>();
    }

    /**
     * Initializes users ArrayList using parameter.
     *
     * @param users users list to use.
     */
    public UserList(ArrayList<User> users) {
        this.users = users;
    }

    /**
     * Returns size of users.
     *
     * @return Length of users.
     */
    public int getSize() {
        return users.size();
    }

    /**
     * Returns user using index.
     *
     * @param index Index of user.
     * @return user at that index.
     */
    public User getUserUsingIndex(int index) {
        return users.get(index);
    }

    /**
     * Adds user to users ArrayList.
     *
     * @param user user to add.
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Adds a new user with given details to <code>users</code> ArrayList.
     *
     * @param username Name of the user.
     * @param password Password of the user.
     */
    public void addNewUser(String username, String password, String role) {
        addUser(new User(username, password, role));
    }


    /**
     * Checks if the Password entered by the user already exists in the user list.
     *
     * @param username The username entered by the user.
     * @return <code>true</code> if username already exists; <code>false</code> otherwise.
     */
    public boolean isExistingUser(String username) {
        return getExistingUser(username) != null;
    }

    /**
     * Finds username entered by the user from the user list.
     * Returns -1 if not found.
     *
     * @param username The username entered by the user.
     * @return index of the user with the Password; -1 otherwise.
     */
    public User getExistingUser(String username) {
        assert username != null && !username.equals("") : "Cannot get user of null username";

        for (int i = 0; i < getSize(); i++) {
            if (getUserUsingIndex(i).getName().equals(username)) {
                return getUserUsingIndex(i);
            }
        }

        return null;
    }

    /**
     * Finds username entered by the user from the user list.
     * Returns 2 if accurate.
     * Returns 1 if user found but role mismatch
     * Return 0 if user not found
     *
     * @param username The username entered by the user.
     * @param role     The role entered by the user.
     * @return index of the user with the Password; -1 otherwise.
     */
    public int ValidateUser(String username, String role) {
        assert username != null && !username.equals("") : "Cannot get user of null username";
        assert role != null && !role.equals("") : "Cannot get role of null role";

        for (int i = 0; i < getSize(); i++) {
            if (getUserUsingIndex(i).getName().equals(username)) {
                if (users.get(i).getRole().equals(role)) {
                    return 2;
                } else {
                    return 1;
                }
            }
        }

        return 0;
    }

    /**
     * Validate the username and the password given for existing users.
     *
     * @param username The username entered by the user.
     * @param password Password of user.
     * @return True if password matches, False otherwise.
     */
    public Boolean validatePassword(String username, String password) {
        return getExistingUser(username).validatePassword(password);
    }

}
