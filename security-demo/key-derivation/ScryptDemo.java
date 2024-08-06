import org.bouncycastle.crypto.generators.SCrypt;
import java.util.Base64;

public class ScryptDemo {
    public static void main(String[] args) {
        try {
            String password = "password123";
            String salt = "salt123";
            int N = 16384; // CPU/memory cost factor
            int r = 8; // Block size
            int p = 1; // Parallelization factor
            int dkLen = 32; // Derived key length
            
            byte[] derivedKey = SCrypt.generate(password.getBytes(), salt.getBytes(), N, r, p, dkLen);
            String encodedKey = Base64.getEncoder().encodeToString(derivedKey);
            System.out.println("Scrypt Key: " + encodedKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
