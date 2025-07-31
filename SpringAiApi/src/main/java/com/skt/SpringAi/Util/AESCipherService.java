package com.skt.SpringAi.Util;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

@Component
public class AESCipherService {

	 private static final String ALGORITHM = "AES";
	    private static final String AES_CIPHER = "AES/CBC/PKCS5Padding";

	    // 16-byte key (128-bit AES)
	    private final String secretKey = "1234567890abcdef"; // Must be 16/24/32 chars for 128/192/256-bit
	    private final SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), ALGORITHM);

	    // Generate random 16-byte IV
	    private IvParameterSpec generateIV() {
	        byte[] iv = new byte[16];
	        new SecureRandom().nextBytes(iv);
	        return new IvParameterSpec(iv);
	    }

	    public String decryptFromJs(String base64CipherText, String base64IV) throws Exception {
	        byte[] cipherBytes = Base64.getDecoder().decode(base64CipherText);
	        byte[] ivBytes = Base64.getDecoder().decode(base64IV);

	        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);

	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        SecretKeySpec keySpec = new SecretKeySpec("1234567890abcdef".getBytes(StandardCharsets.UTF_8), "AES");
	        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

	        byte[] decrypted = cipher.doFinal(cipherBytes);
	        return new String(decrypted, StandardCharsets.UTF_8);
	    }

	    
	    public String encrypt(String plainText) throws Exception {
	        Cipher cipher = Cipher.getInstance(AES_CIPHER);
	        IvParameterSpec ivSpec = generateIV();
	        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

	        byte[] encrypted = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
	        byte[] iv = ivSpec.getIV();

	        // Prepend IV to encrypted data for later decryption
	        byte[] ivAndEncrypted = new byte[iv.length + encrypted.length];
	        System.arraycopy(iv, 0, ivAndEncrypted, 0, iv.length);
	        System.arraycopy(encrypted, 0, ivAndEncrypted, iv.length, encrypted.length);

	        return Base64.getEncoder().encodeToString(ivAndEncrypted);
	    }

	    public String decrypt(String base64CipherText) throws Exception {
	        byte[] ivAndEncrypted = Base64.getDecoder().decode(base64CipherText);

	        // Extract IV
	        byte[] iv = new byte[16];
	        System.arraycopy(ivAndEncrypted, 0, iv, 0, 16);
	        IvParameterSpec ivSpec = new IvParameterSpec(iv);

	        // Extract actual cipher text
	        int cipherTextLength = ivAndEncrypted.length - 16;
	        byte[] cipherBytes = new byte[cipherTextLength];
	        System.arraycopy(ivAndEncrypted, 16, cipherBytes, 0, cipherTextLength);

	        Cipher cipher = Cipher.getInstance(AES_CIPHER);
	        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

	        byte[] decrypted = cipher.doFinal(cipherBytes);
	        return new String(decrypted, StandardCharsets.UTF_8);
	    }
}
