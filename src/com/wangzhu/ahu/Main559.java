package com.wangzhu.ahu;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main559 {

	private static final int LEN = 10001;
	private static int[] arr = new int[LEN];

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// System.setIn(new FileInputStream("data.in"));
		Scanner cin = new Scanner(new BufferedInputStream(System.in));
		int index = 0;
		while (cin.hasNext()) {
			int n = cin.nextInt();
			if (n < 1) {
				return;
			}
			for (int i = 0; i < n; i++) {
				arr[i] = cin.nextInt();
			}
			sort(arr, n);
			boolean flag = true;
			for (int i = 1; (i < n) && flag; i++) {
				if (arr[i] - arr[i - 1] != 1) {
					flag = false;
				}
			}
			System.out.printf("Case %d:\n%s\n", ++index, flag ? "S" : "M");
		}
	}

	private static void sort(int[] arr, int len) {
		sort(arr, 0, len - 1);
	}

	private static void sort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = getMiddle(arr, left, right);
			sort(arr, left, mid - 1);
			sort(arr, mid + 1, right);
		}
	}

	private static int getMiddle(int[] arr, int left, int right) {
		int tmp = arr[left];
		while (left < right) {
			while (left < right && arr[right] >= tmp) {
				right--;
			}
			arr[left] = arr[right];

			while (left < right && arr[left] <= tmp) {
				left++;
			}
			arr[right] = arr[left];
		}
		arr[left] = tmp;
		return left;
	}
}
