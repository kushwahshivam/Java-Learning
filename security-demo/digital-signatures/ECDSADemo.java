import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

public class ECDSADemo {
    public static void main(String[] args) {
        try {
            // Generate ECC key pair
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
            keyPairGenerator.initialize(256); // ECC with 256-bit key
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            PublicKey publicKey = keyPair.getPublic();
            
            // Sign
            Signature signature = Signature.getInstance("SHA256withECDSA");
            signature.initSign(privateKey);
            String originalString = "Hello, World!";
            signature.update(originalString.getBytes());
            byte[] signedBytes = signature.sign();
            String signedString = Base64.getEncoder().encodeToString(signedBytes);
            System.out.println("Signed: " + signedString);
            
            // Verify
            signature.initVerify(publicKey);
            signature.update(originalString.getBytes());
            boolean isVerified = signature.verify(Base64.getDecoder().decode(signedString));
            System.out.println("Verified: " + isVerified);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
