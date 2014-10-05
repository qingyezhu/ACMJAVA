package com.wangzhu.njupt;

import java.util.Scanner;

public class Main1094 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = -1;
		while (cin.hasNext()) {
			n = cin.nextInt();
			makeMatrix(n);
		}
	}

	public static void makeMatrix(int n) {
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = 0;
			}
		}
		int x = 0;
		int y = n - 1;
		int val = 1;
		arr[x][y] = val;
		while (val < n * n) {
			while ((x < n - 1) && (0 == arr[x + 1][y])) {
				arr[++x][y] = ++val;
			}
			while ((y > 0) && (0 == arr[x][y - 1])) {
				arr[x][--y] = ++val;
			}
			while ((x > 0) && (0 == arr[x - 1][y])) {
				arr[--x][y] = ++val;
			}
			while ((y < n - 2) && (0 == arr[x][y + 1])) {
				arr[x][++y] = ++val;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%5d", arr[i][j]);
			}
			System.out.println();
		}
	}
}
