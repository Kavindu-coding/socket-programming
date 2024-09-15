package crypto;

import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class Triple_DES {
    public static void main(String[] args) throws InvalidKeyException, InvalidKeySpecException,
            NoSuchAlgorithmException, NoSuchPaddingException,
            IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {

        String custom_key = "123456781234567812345678";
        DESedeKeySpec key_spec = new DESedeKeySpec(custom_key.getBytes());
        SecretKey des_key = SecretKeyFactory.getInstance("DESede").generateSecret(key_spec);

        byte[] key_byte =des_key.getEncoded();
        String key_str = new String(key_byte);

        System.out.println("Triple DES KEy : " + key_str);
        System.out.println("Triple DES Key size : " + key_str.length());

        Cipher des;
        des = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        des.init(Cipher.ENCRYPT_MODE, des_key);

        String msg = "xxxxxxxxxxxxxxxxx";
        byte[] text = msg.getBytes("UTF-8");

        System.out.println("Plain Text : " + msg);

        byte[] encrypted_text = des.doFinal(text);

        System.out.println("Cipher text : " + new String(encrypted_text));

        String encoded_enc_text = Base64.getEncoder().encodeToString(encrypted_text);
        System.out.println("Cipher text (encoded) :" + encoded_enc_text);

        // Transmit encoded_enc_text

        //decrypt

        byte[] decoded_enc_text = Base64.getDecoder().decode(encoded_enc_text);
        des.init(Cipher.DECRYPT_MODE,des_key);
        byte[] decrypted_text = des.doFinal(decoded_enc_text);

        System.out.println("Plain text :" + new String(decrypted_text));
    }
}

