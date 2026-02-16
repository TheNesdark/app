package Utilidades;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/EnDesCrip.class */
public class EnDesCrip {
    static byte[] secret = {1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8};
    static Key key = null;

    public String encrypt(String clearText, Key key2) {
        String cipherTextB64 = "";
        try {
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(1, key2);
            byte[] cipherText = cipher.doFinal(clearText.getBytes());
            cipherTextB64 = Base64.getEncoder().encodeToString(cipherText);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
        }
        return cipherTextB64;
    }

    public String decrypt(String cipherTextB64, Key key2) {
        String clearText = "";
        try {
            Cipher cipher = Cipher.getInstance("DESede");
            byte[] cipherText = Base64.getDecoder().decode(cipherTextB64);
            cipher.init(2, key2);
            byte[] bclearText = cipher.doFinal(cipherText);
            clearText = new String(bclearText);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
        }
        return clearText;
    }

    public String encripta(String textoPuro) {
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("DESede");
            key = skf.generateSecret(new DESedeKeySpec(secret));
        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException e) {
        }
        EnDesCrip tripledesencryption = new EnDesCrip();
        String textoImpuro = tripledesencryption.encrypt(textoPuro, key);
        return textoImpuro;
    }

    public String desencripta(String textoImpuro) {
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("DESede");
            key = skf.generateSecret(new DESedeKeySpec(secret));
        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException e) {
        }
        EnDesCrip tripledesencryption = new EnDesCrip();
        String textoPuro = tripledesencryption.decrypt(textoImpuro, key);
        return textoPuro;
    }

    public static void main(String[] a) {
        EnDesCrip e = new EnDesCrip();
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("DESede");
            key = skf.generateSecret(new DESedeKeySpec(secret));
        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException e2) {
        }
        System.out.println(e.encrypt("d", key));
    }
}
