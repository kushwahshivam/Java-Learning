import org.mindrot.jbcrypt.BCrypt;

public class BcryptDemo {
    public static void main(String[] args) {
        String password = "password123";

        // Hash the password
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println("Hashed Password: " + hashed);

        // Check the password
        boolean isMatch = BCrypt.checkpw(password, hashed);
        System.out.println("Password Matches: " + isMatch);
    }
}
