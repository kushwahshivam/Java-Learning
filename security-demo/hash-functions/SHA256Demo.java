import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Demo {
    public static void main(String[] args) {
        String originalString = "Hello, World!";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(originalString.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            System.out.println("SHA-256 Hash: " + sb.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
