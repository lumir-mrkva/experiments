package cz.mrq.experiments;

import org.apache.commons.codec.binary.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.UUID;

/**
 * Signature
 *
 * @author Lumir Mrkva (lumir.mrkva@topmonks.com)
 */
public class Signature {

    public static String hmacSha1(String value, String base64Key) {
        return hmacSha1(value, Base64.decodeBase64(base64Key));
    }

    public static String hmacSha1(String value, byte[] key) {
        try {
            SecretKeySpec signingKey = new SecretKeySpec(key, "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            byte[] hmac = mac.doFinal(value.getBytes());
            byte[] encodedBytes = Base64.encodeBase64(hmac);
            return new String(encodedBytes, "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] getRandomBytes() {
        return UUID.randomUUID().toString().getBytes();
    }

    public static byte[] generateSecretKey() {
        return new SecretKeySpec(getRandomBytes(), "HmacSHA1").getEncoded();
    }
}
