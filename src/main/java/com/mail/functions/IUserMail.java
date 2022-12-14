package com.mail.functions;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.mail.module.UserMail;

public interface IUserMail {
	public boolean login(String mail, String password);
	public boolean isexiste(String mail);
	public void register(UserMail user);
	public static String getsh(String password) {
		try {
            // getInstance() method is called with algorithm SHA-512
            MessageDigest md = MessageDigest.getInstance("MD5");
  
            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(password.getBytes(StandardCharsets.UTF_8));
  
            // Convert byte array into signum representation
            BigInteger number = new BigInteger(1, messageDigest);
  
            // Convert message digest into hex value
            StringBuilder hexString = new StringBuilder(number.toString(16)); 
  
            // Add preceding 0s to make it 32 bit
            while (hexString.length() < 32) {
            	hexString.insert(0, '0');
            }
  
            // return the HashText
            return hexString.toString();
        }
  
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
	}
}
