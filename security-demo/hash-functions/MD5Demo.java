import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Demo {
    public static void main(String[] args) {
        String originalString = "Hello, World!";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(originalString.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            System.out.println("MD5 Hash: " + sb.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
