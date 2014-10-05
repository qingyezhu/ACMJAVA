package com.wangzhu.demo;

import java.util.Scanner;

public class Triangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = -1;
		while (cin.hasNext()) {
			n = cin.nextInt();
			getTriangle(n);
		}
	}

	// �������
	public static void getTriangle(int n) {
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			arr[i][0] = 1;
			arr[i][i] = 1;

		}
		// ��һ�е�������һ�е����������ĺ�
		for (int i = 1; i < n - 1; i++) {
			for (int j = 0; j < i; j++) {
				arr[i + 1][j + 1] = arr[i][j] + arr[i][j + 1];
			}
		}
		// ��һ�е��������ڵ�����Ϊ��һ�е���
		for (int i = 2; i < n; i++) {
			for (int j = 1; j < i; j++) {
				arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int k = n - i; k > 0; k--) {
				System.out.printf(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.printf("%4d", arr[i][j]);
			}
			System.out.println();
		}
	}
}
