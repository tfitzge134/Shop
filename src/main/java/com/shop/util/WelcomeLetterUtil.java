package com.shop.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WelcomeLetterUtil {

	private static final String WELCOME_LETTER_FILE_PATH = "customer-welcome.txt";
	
	public static String getWelcomeMessage() {
		try {
			StringBuffer sb = new StringBuffer();
			BufferedReader br = new BufferedReader(new FileReader(WELCOME_LETTER_FILE_PATH));
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			return sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Welcome, Customer!";
		}
	}
}
