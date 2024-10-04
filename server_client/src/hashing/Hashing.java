package hashing;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        System.out.println("Password : " + password);
        System.out.println("Password Length : " + password.length());

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes(StandardCharsets.UTF_8));

        byte[] hashed_pwd = md.digest();
        System.out.println(new String(hashed_pwd));

        StringBuilder hexString = new StringBuilder();
        for (byte b : hashed_pwd) {
            hexString.append(String.format("%02x", b)); //Convert to Hexadecimal format
        }

        System.out.println("Hashed password (hex): " + hexString);
        System.out.println("Hash Length : " + hashed_pwd.length + " bytes");

    }
}
