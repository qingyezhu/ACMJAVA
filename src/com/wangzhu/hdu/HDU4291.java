/**   
 * @Title: HDU4291.java 
 * @Package com.wangzhu.hdu 
 * @Description: 快速矩阵求类似斐波那契数列
 * @author 王竹
 * @date 2012-9-20 下午10:45:58 
 * @version V1.0   
 *
 */
package com.wangzhu.hdu;

/** 
 * @ClassName: HDU4291 
 * @Description: 快速矩阵求类似斐波那契数列
 * @author 王竹 
 * @date 2012-9-20 下午10:45:58 
 *  
 */
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HDU4291 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data.in"));
		Scanner cin = new Scanner(new BufferedInputStream(System.in));
		long n = -1;
		while (cin.hasNext()) {
			n = cin.nextLong();
			System.out.println(cal(cal(cal(n, 183120), 222222224), 1000000007));
		}
		cin.close();
	}

	static long numa[][] = new long[2][2];
	static long numb[][] = new long[2][2];

	public static void matrix(long[][] a, long[][] b, int mark, long MOD) {
		long[][] temp = new long[2][2];
		temp[0][0] = (a[0][0] * b[0][0] % MOD + a[0][1] * b[1][0] % MOD) % MOD;
		temp[0][1] = (a[0][0] * b[0][1] % MOD + a[0][1] * b[1][1] % MOD) % MOD;
		temp[1][0] = (a[1][0] * b[0][0] % MOD + a[1][1] * b[1][0] % MOD) % MOD;
		temp[1][1] = (a[1][0] * b[0][1] % MOD + a[1][1] * b[1][1] % MOD) % MOD;
		if (mark == 1) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					numa[i][j] = temp[i][j];
				}
			}
		} else {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					numb[i][j] = temp[i][j];
				}
			}
		}
	}

	public static long cal(long n, long MOD) {
		numa[0][0] = 1;
		numa[0][1] = 0;
		numa[1][0] = 0;
		numa[1][1] = 1;
		numb[0][0] = 3;
		numb[0][1] = 1;
		numb[1][0] = 1;
		numb[1][1] = 0;

		while (n != 0) {
			if (n % 2 == 1) {
				matrix(numa, numb, 1, MOD);
			}
			matrix(numb, numb, 0, MOD);
			n >>= 1;
		}
		return numa[0][1];
	}
}
