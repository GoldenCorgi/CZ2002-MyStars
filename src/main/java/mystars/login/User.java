package mystars.login;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;


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
    private static class PasswordHandler {
        private static final SecureRandom RAND = new SecureRandom();
        private static final int ITERATIONS = 65536;
        // Apple reportedly used 2000 for iOS 3, and 10000 for iOS 4 while
        // LastPass in 2011 used 5000 iterations for JavaScript clients and 100000 iterations for server-side hashing.
        // https://en.wikipedia.org/wiki/PBKDF2
        private static final int KEY_LENGTH = 512;
        private static final String ALGORITHM = "PBKDF2WithHmacSHA512";

        public static String generateSalt() {
            // Generate a random salt of length 16 - best practices to salt before hashing for password crypt
            // The Java language assumes that every character in a string occupies 16 bits
            // 16 * 16 = 256 bits of salt

            // According to the PBKDF2 standard, the minimum recommended size for the salt is 64 bits
            // The US National Institute of Standards and Technology recommends a salt length of 128 bits.
            // https://en.wikipedia.org/wiki/PBKDF2
            final int length = 16;
            byte[] salt = new byte[length];
            RAND.nextBytes(salt);
            return (Base64.getEncoder().encodeToString(salt));
        }

        public static String hashPassword(String password, String salt) {

            char[] chars = password.toCharArray();
            byte[] bytes = salt.getBytes();

            PBEKeySpec spec = new PBEKeySpec(chars, bytes, ITERATIONS, KEY_LENGTH);

            Arrays.fill(chars, Character.MIN_VALUE);

            try {
                SecretKeyFactory fac = SecretKeyFactory.getInstance(ALGORITHM);
                byte[] securePassword = fac.generateSecret(spec).getEncoded();
                return Base64.getEncoder().encodeToString(securePassword);

            } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
                System.err.println("Exception encountered in hashPassword()");
                return "";
            } finally {
                spec.clearPassword();
            }
        }

        public static boolean verifyPassword(String password, String hash, String salt) {
            String optEncrypted = hashPassword(password, salt);
            if (optEncrypted.equals("")) return false;
            return optEncrypted.equals(hash);
        }


    }


}
