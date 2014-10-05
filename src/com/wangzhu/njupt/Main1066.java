package com.wangzhu.njupt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main1066 {
	public static void main(String[] args) throws IOException {

		Scanner cin = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		while (cin.hasNext()) {
			String str = cin.nextLine();
			char[] buf = str.toCharArray();
			sort(buf);
			System.out.println(new String(buf));
		}
	}

	public static void sort(char[] buf) {
		if (null != buf && buf.length > 0) {
			sort(buf, 0, buf.length - 1);
		}
	}

	private static void sort(char[] buf, int left, int right) {
		if (left < right) {
			int mid = getMiddle(buf, left, right);
			sort(buf, left, mid - 1);
			sort(buf, mid + 1, right);
		}
	}

	private static int getMiddle(char[] buf, int left, int right) {
		char tmp = buf[left];
		while (left < right) {
			while ((left < right) && (tmp <= buf[right])) {
				right--;
			}
			buf[left] = buf[right];
			while ((left < right) && (tmp >= buf[left])) {
				left++;
			}
			buf[right] = buf[left];
		}
		buf[left] = tmp;
		return left;
	}
}
