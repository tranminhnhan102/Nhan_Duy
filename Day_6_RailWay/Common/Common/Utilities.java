package Common;

import java.security.SecureRandom;
import java.util.Random;

public class Utilities {
	
	static final String sSampleText = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static final String sPID = "0123456789";
	static SecureRandom rRandom = new SecureRandom();
	
	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}
	
	protected String getSaltString() {
		String sChars = "abcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder sBuil = new StringBuilder();
		Random rString = new Random();
		while (sBuil.length() < 3) { // length of the random string.
			int index = (int) (rString.nextFloat() * sChars.length());
			sBuil.append(sChars.charAt(index));
		}
		String saltStr = "Ngan"+ sBuil.toString();
		return saltStr;
	}

	public String randomEmail() {
		return getSaltString() + "@gmail.com";
	}

	public int randomNumber() {
		Random rNum = new Random();
		return rNum.nextInt(10) + 1;
		
	}
	public String randomPassword(int sLength) {
		StringBuilder sBuil = new StringBuilder(sLength);
		for (int i = 0; i < sLength; i++)
			sBuil.append(sSampleText.charAt(rRandom.nextInt(sSampleText.length())));
		return sBuil.toString();
	}

	public String randomPID(int sLength) {
		StringBuilder sBuil = new StringBuilder(sLength);
		for (int i = 0; i < sLength; i++)
			sBuil.append(sPID.charAt(rRandom.nextInt(sPID.length())));
		return sBuil.toString();
	}

}
