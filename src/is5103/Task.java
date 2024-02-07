package is5103;

import java.util.Scanner;

/*
Package: is5103
ClassName: Task
Description:
Author: Jesse Yang
Date: 2023-09-30 星期六 9:17
*/
public class Task {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter ‘E’ to encrypt a message or ‘D’ to decrypt a message:");
		String choice = scanner.nextLine();
		
		System.out.println("Please enter your message:");
		String message = scanner.nextLine();
		
		System.out.println("Please enter your key:");
		String key = scanner.nextLine();
		
		EncryptAndDecrypt encryptAndDecrypt = new EncryptAndDecrypt(key);
		
		if (choice.equals("E")) {
			String result = encryptAndDecrypt.encrypt(message);
			System.out.println("Your encrypted message is: \n" + result);
		} else if (choice.equals("D")) {
			String result = encryptAndDecrypt.decrypt(message);
			System.out.println("Your decrypted message is: \n" + result);
		}
	}
	
	

}

class EncryptAndDecrypt {
	final String key;
	final static char lowerA = 'a';
	final static char upperA = 'A';
	static final int countOfChars = 26;
	
	public EncryptAndDecrypt(String key) {
		this.key = key;
	}
	
	public String encrypt(String str) {
		int lenStr = str.length();
		int lenKey = key.length();
		int j = 0; // index of key
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < lenStr; i++) {
			char strChar = str.charAt(i);
			char keyChar = key.charAt(j);
			j++;
			if (j >= lenKey) {
				j -= lenKey;
			}
			char res = operate(strChar, keyChar);
			sb.append(res);
		}
		return sb.toString();
	}
	
	public  String decrypt(String str) {
		int lenStr = str.length();
		int lenKey = key.length();
		int j = 0; // index of key
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < lenStr; i++) {
			char strChar = str.charAt(i);
			char keyChar = key.charAt(j);
			j++;
			if (j >= lenKey) {
				j -= lenKey;
			}
			char keyCharTransferred = (char) (countOfChars - (keyChar - lowerA) + lowerA);
			char res = operate(strChar, keyCharTransferred);
			sb.append(res);
		}
		return sb.toString();
	}
	
	private static char operate (char strChar, char keyChar) {
		if (Character.isLetter(strChar)) {
			if (Character.isUpperCase(strChar)) {
				int sum = Math.floorMod(strChar - upperA + keyChar - lowerA, countOfChars);
				return (char) (sum + upperA);
			} else {
				int sum = Math.floorMod(strChar - lowerA + keyChar - lowerA, countOfChars);
				return (char) (sum + lowerA);
			}
		} else {
			return strChar;
		}
		
	}
}
