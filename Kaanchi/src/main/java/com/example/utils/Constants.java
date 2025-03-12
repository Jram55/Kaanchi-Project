package com.example.utils;

import io.jsonwebtoken.SignatureAlgorithm;

public class Constants {
	
	public class Token {
		public static String SIGNING_KEY = "Kaanchi05";
		public static SignatureAlgorithm ALGORITHM = SignatureAlgorithm.HS256;
		public static long VALIDITY = 5 * 60 * 60 * 1000;
		public static String HEADER_KEY = "Authorization";
		public static String TOKEN_PREFIX = "Kaanchi ";
	}

	public static String ENCRYPTION_ALGORITHM = "SHA-1";
	public static String UPLOAD_PATH = "D:/kaanchi/upload/";
	public static String UPLOAD = "File is uploaded successfully !";
	public static String FAILURE_STATUS = "FAIL";
}
