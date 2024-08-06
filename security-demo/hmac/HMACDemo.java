package hmac;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class HMACDemo {
    public static void main(String[] args) {
        String originalString = "Hello, World!";
        String secretKey = "supersecretkey";

        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
            mac.init(keySpec);

            byte[] hmac = mac.doFinal(originalString.getBytes());
            String encodedHmac = Base64.getEncoder().encodeToString(hmac);

            System.out.println("HMAC: " + encodedHmac);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
