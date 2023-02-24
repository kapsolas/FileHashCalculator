package com.kapsalis.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils 
{
	public static String calculateSHA256( String path ) throws NoSuchAlgorithmException, IOException
	{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		
		FileInputStream fis = new FileInputStream( path );
		
		byte[] bytes = new byte[1024];
		
		int nread = 0;
		 while ((nread = fis.read(bytes)) != -1) 
		 {
	          md.update(bytes, 0, nread);
	        };
	        byte[] mdbytes = md.digest();
	 
	        StringBuffer hexString = new StringBuffer();
	    	for (int i=0;i<mdbytes.length;i++) {
	    	  hexString.append(Integer.toHexString(0xFF & mdbytes[i]));
	    	}
	 
	    	return hexString.toString();
	}
}
