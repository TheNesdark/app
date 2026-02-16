package com.genoma.plus.utils;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/utils/DecrypterLicensed.class */
public class DecrypterLicensed {
    private static DecrypterLicensed decrypter;
    private PrivateKey privateKey;

    private DecrypterLicensed() {
    }

    private DecrypterLicensed(String privateKey) throws InvalidKeySpecException, NoSuchAlgorithmException {
        this.privateKey = getPrivateKeyFromString(privateKey);
    }

    public static DecrypterLicensed getInstances(String privateKey) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (null == decrypter) {
            decrypter = new DecrypterLicensed(privateKey);
        }
        return decrypter;
    }

    private PrivateKey getPrivateKeyFromString(String key) throws InvalidKeySpecException, NoSuchAlgorithmException {
        byte[] encodedPrivateKey = stringToBytes(key);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(encodedPrivateKey);
        return keyFactory.generatePrivate(privateKeySpec);
    }

    public String Decrypt(String result) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(2, this.privateKey);
        byte[] decryptedBytes = cipher.doFinal(stringToBytes(result));
        return new String(decryptedBytes);
    }

    public byte[] stringToBytes(String s) {
        byte[] b2 = new BigInteger(s, 36).toByteArray();
        return Arrays.copyOfRange(b2, 1, b2.length);
    }
}
