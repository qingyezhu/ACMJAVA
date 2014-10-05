package com.wangzhu.njupt;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class Main14022 {

	/**
	 * 用位来存储数
	 */
	private static final int LEN = (1000000 >> 3) + 10;
	/**
	 * 用于模8，即与7
	 */
	private static final int MASK = (1 << 3) - 1;
	/**
	 * 要查的数的范围为1~1000000
	 */
	private static final int SIZE = 1000001;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("data.in"));
		// Scanner cin = new Scanner(new BufferedInputStream(System.in));
		// 输入优化
		StreamTokenizer in = new StreamTokenizer(new BufferedInputStream(
				System.in));
		// 输出优化
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		// while (cin.hasNext()) {
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			int[] arr = new int[LEN];
			int[] flag = new int[LEN];
			// int n = cin.nextInt();
			int n = (int) in.nval;
			for (int i = 0; i < n; i++) {
				// int m = cin.nextInt();
				in.nextToken();
				int m = (int) in.nval;
				// 其实是除以8
				int index = m >> 3;
				// 其实是模8
				int bit = m & MASK;
				if ((arr[index] & (1 << bit)) == 0) {
					// 记录输入中的数
					arr[index] |= (1 << bit);
				} else if ((flag[index] & (1 << bit)) == 0) {
					// 记录输入多个同样的数
					flag[index] |= (1 << bit);
				}
			}
			int cnt = 0;
			for (int i = 1; i < SIZE; i++) {
				int index = i >> 3;
				int bit = i & MASK;
				if ((arr[index] & (1 << bit)) != 0
						&& (flag[index] & (1 << bit)) == 0) {
					// 判断是输入的数并且只输入了一次
					// 记录这种数的个数
					cnt++;
				}
			}
			StringBuilder sb = new StringBuilder();
			int j = 0;
			for (int i = 1; (i < SIZE) && (j < cnt); i++) {
				int index = i >> 3;
				int bit = i & MASK;
				if ((arr[index] & (1 << bit)) != 0
						&& (flag[index] & (1 << bit)) == 0) {
					sb.append(i).append(" ");
					j++;
				}
			}
			String ret = null;
			out.println(cnt);
			if (cnt > 0) {
				ret = sb.substring(0, sb.length() - 1);
				out.println(ret);
			}
			out.flush();
		}
	}
}
