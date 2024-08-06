import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;
import java.util.Base64;

public class PBKDF2Demo {
    public static void main(String[] args) {
        try {
            String password = "password123";
            String salt = "salt123";
            int iterations = 10000;
            int keyLength = 256;

            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), iterations, keyLength);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] hash = skf.generateSecret(spec).getEncoded();
            String encodedHash = Base64.getEncoder().encodeToString(hash);
            System.out.println("PBKDF2 Hash: " + encodedHash);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
