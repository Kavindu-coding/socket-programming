package crypto;

import javax.crypto.*;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class RSA {
    public static void main(String[] args) throws InvalidKeyException, InvalidKeySpecException,
            NoSuchAlgorithmException, NoSuchPaddingException,
            IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, InvalidAlgorithmParameterException {

        KeyPairGenerator key_gen = KeyPairGenerator.getInstance("RSA");
        key_gen.initialize(2048);

        KeyPair key_pair_alice = key_gen.generateKeyPair();
        KeyPair key_pair_bob = key_gen.generateKeyPair();


        PrivateKey pvt_key_alice = key_pair_alice.getPrivate();
        PublicKey pub_key_alice = key_pair_alice.getPublic();

        PrivateKey pvt_key_bob = key_pair_bob.getPrivate();
        PublicKey pub_key_bob = key_pair_bob.getPublic();

//        System.out.println("Private Key : ");
//        System.out.println(new String(pvt_key.getEncoded()));
//        System.out.println("Public Key : ");
//        System.out.println(new String(pub_key.getEncoded()));

        Cipher rsa = Cipher.getInstance("RSA");
        rsa.init(Cipher.ENCRYPT_MODE, pub_key_bob);

        Signature rsaSign;
        rsaSign = Signature.getInstance("SHA256withRSA");
        rsaSign.initSign(pvt_key_alice);


        String msg = "Kavindu";
        byte[] text = msg.getBytes("UTF-8");

        System.out.println("Plain Text : " + msg);

        byte[] encrypted_text = rsa.doFinal(text);

        System.out.println("Cipher text : " + new String(encrypted_text));

        String encoded_enc_text = Base64.getEncoder().encodeToString(encrypted_text);
        System.out.println("Cipher text (encoded) :" + encoded_enc_text);

        // Transmit encoded_enc_text

        //decrypt

        byte[] decoded_enc_text = Base64.getDecoder().decode(encoded_enc_text);
        rsa.init(Cipher.DECRYPT_MODE,pvt_key_bob);
        byte[] decrypted_text = rsa.doFinal(decoded_enc_text);

        System.out.println("Plain text :" + new String(decrypted_text));
    }
}
