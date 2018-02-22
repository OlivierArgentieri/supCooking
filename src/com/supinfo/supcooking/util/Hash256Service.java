package com.supinfo.supcooking.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash256Service {
	public static String hash256(String s){
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(s.getBytes());
			return bytesToHex(md.digest());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	private static String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte byt : bytes) result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    }
}
