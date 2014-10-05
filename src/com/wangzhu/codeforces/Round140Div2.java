package com.wangzhu.codeforces;

//What do I turn?
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Round140Div2 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data.in"));
		Scanner cin = new Scanner(new BufferedInputStream(System.in));
		int Len = 3;
		Point[] points = new Point[Len];
		long temp = -1;
		while (cin.hasNext()) {
			for (int i = 0; i < Len; i++) {
				points[i] = new Point(cin.nextLong(), cin.nextLong());
			}
			temp = xmult(points[0], points[1], points[2]);
			if (temp < 0) {
				System.out.println("RIGHT");
			} else if (temp > 0) {
				System.out.println("LEFT");
			} else {
				System.out.println("TOWARDS");
			}
		}
		cin.close();
	}

	public static long xmult(Point p1, Point p2, Point p3) {
		return (p1.x - p2.x) * (p2.y - p3.y) - (p1.y - p2.y) * (p2.x - p3.x);
	}
}

class Point {
	long x, y;

	public Point(long x, long y) {
		this.x = x;
		this.y = y;
	}
}
//
// package com.wangzhu.codeforces;
//
// //Anniversary
// import java.io.BufferedInputStream;
// import java.io.FileInputStream;
// import java.io.FileNotFoundException;
// import java.util.Arrays;
// import java.util.Scanner;
//
// public class Round140Div2 {
//
// public static void main(String[] args) throws FileNotFoundException {
// System.setIn(new FileInputStream("data.in"));
// Scanner cin = new Scanner(new BufferedInputStream(System.in));
// long m = -1, L = -1, R = -1, k = -1, n = -1;
// int len = -1, temp = -1;
// long[] arr = null;
// while (cin.hasNext()) {
// m = cin.nextLong();
// L = cin.nextLong();
// R = cin.nextLong();
// k = cin.nextLong();
// temp = (int) Math.sqrt(1.0 * R);
// len = temp * 2;
// arr = new long[len];
// for (int i = 1; i <= temp; i++) {
// arr[i - 1] = i;
// }
// for (int i = 0, j = temp; i < temp; i++) {
// arr[j++] = R / arr[i];
// }
// Arrays.sort(arr);
// for (int i = len - 1; i >= 0; i--) {
// if ((R / arr[i] - (L - 1) / arr[i] >= k)) {
// n = arr[i];
// break;
// }
// }
// cal(n, m);
// }
// cin.close();
// }
//
// private static void cal(long k, long MOD) {
// long[][] numa = new long[2][2];
// long[][] numb = new long[2][2];
// numa[0][0] = 1;
// numa[0][1] = 0;
// numa[1][0] = 0;
// numa[1][1] = 1;
// numb[0][0] = 0;
// numb[0][1] = 1;
// numb[1][0] = 1;
// numb[1][1] = 1;
// while (k != 0) {
// if (k % 2 == 1) {
// numa = matrix(numa, numb, MOD);
// }
// numb = matrix(numb, numb, MOD);
// k >>= 1;
// }
// System.out.println(numa[0][1]);
// }
//
// private static long[][] matrix(long[][] a, long[][] b, long MOD) {
// long[][] temp = new long[2][2];
// temp[0][0] = (a[0][0] * b[0][0] % MOD + a[0][1] * b[1][0] % MOD) % MOD;
// temp[0][1] = (a[0][0] * b[0][1] % MOD + a[0][1] * b[1][1] % MOD) % MOD;
// temp[1][0] = (a[1][0] * b[0][0] % MOD + a[1][1] * b[1][0] % MOD) % MOD;
// temp[1][1] = (a[1][0] * b[0][1] % MOD + a[1][1] * b[1][1] % MOD) % MOD;
// return temp;
// }
//
// }
