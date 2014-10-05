package com.wangzhu.hdu;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main2716 {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data.in"));
		Scanner cin = new Scanner(new BufferedInputStream(System.in));
		while (cin.hasNext()) {
			String key = cin.nextLine();
			String ciphertext = cin.nextLine();
			StringBuffer plaintextSb = new StringBuffer();
			for (int i = 0, len = ciphertext.length(); i < len; i++) {
				char c = ciphertext.charAt(i);
				// System.out.println(c + "===" + (c == ' '));
				if (Character.isLetter(c)) {
					if (Character.isUpperCase(c)) {
						c = Character.toUpperCase(key.charAt(c - 'A'));
					} else {
						c = key.charAt(c - 'a');
					}
				}
				plaintextSb.append(c);
			}
			System.out.println(plaintextSb);
		}
	}
}
