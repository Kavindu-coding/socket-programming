package crypto;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class AES {
    public static void main(String[] args) throws InvalidKeyException, InvalidKeySpecException,
            NoSuchAlgorithmException, NoSuchPaddingException,
            IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, InvalidAlgorithmParameterException {

        byte[] key_array = new byte[] {'T','h','e','B','e','s','t','s','e','c','r','e','t','k','e','y'};
        SecretKeySpec key = new SecretKeySpec(key_array, "AES");



        System.out.println("AES Key Phrase : " + new String(key.getEncoded()));
//        System.out.println("DES Key size : " + key_str.length());

        Cipher aes;
        aes = Cipher.getInstance("AES/CBC/NoPadding");

        String iv_str = "AAAAAAAAAAAAAAAA";
        IvParameterSpec iv = new IvParameterSpec(iv_str.getBytes());

        aes.init(Cipher.ENCRYPT_MODE, key, iv);

        String msg = "xxxxxxxxxxxxxxxx";
        byte[] text = msg.getBytes("UTF-8");

        System.out.println("Plain Text : " + msg);

        byte[] encrypted_text = aes.doFinal(text);

        System.out.println("Cipher text : " + new String(encrypted_text));

        String encoded_enc_text = Base64.getEncoder().encodeToString(encrypted_text);
        System.out.println("Cipher text (encoded) :" + encoded_enc_text);

        // Transmit encoded_enc_text

        //decrypt

        byte[] decoded_enc_text = Base64.getDecoder().decode(encoded_enc_text);
        aes.init(Cipher.DECRYPT_MODE,key, iv);
        byte[] decrypted_text = aes.doFinal(decoded_enc_text);

        System.out.println("Plain text :" + new String(decrypted_text));
    }
}
