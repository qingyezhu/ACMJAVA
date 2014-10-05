package com.wangzhu.njupt;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main1075 {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data.in"));
		Scanner cin = new Scanner(new BufferedInputStream(System.in));
		while (cin.hasNext()) {
			int n = cin.nextInt();
			work(n);
		}
	}

	private static void work(int n) {
		if (n <= 0) {
			return;
		}
		if (n == 1) {
			System.out.println("0");
			return;
		}
		int len = (n << 1) - 1;
		int[] arr = new int[len];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i < len; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		for (int i = 1; i <= n; i++) {
			int k = (i << 1) - 1;
			for (int j = 0; j < k; j++) {
				if (j > 0) {
					System.out.print(" ");
				}
				System.out.print(arr[j]);
			}
			System.out.println();
		}

	}
}
