package com.wangzhu.njupt;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Main1120 {

	static PrintWriter OUT = new PrintWriter(new BufferedOutputStream(
			System.out));

	static char[] buf = new char[10];
	static char[] out = new char[10];
	static boolean[] used = new boolean[10];

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data.in"));
		StreamTokenizer in = new StreamTokenizer(new BufferedInputStream(
				System.in));
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			String str = in.sval;
			int len = str.length();
			buf = str.toCharArray();
			dfs(0, len);
		}
	}

	/**
	 * 
	 * @param dep
	 *            遍历深度
	 * @param maxDep
	 *            数组长度
	 * @param buf
	 *            存储数组
	 * @param out
	 *            输出数组
	 * @param used
	 *            标记是否使用过
	 */
	private static void dfs(int dep, int maxDep) {
		if (dep == maxDep) {
			// System.out.printf("%s\n", String.valueOf(out, 0, maxDep));
			OUT.printf("%s\n", String.valueOf(out, 0, maxDep));
			OUT.flush();
			return;
		}
		for (int i = 0; i < maxDep; i++) {
			if (!used[i]) {
				used[i] = true;
				out[dep] = buf[i];
				dfs(dep + 1, maxDep);
				used[i] = false;
			}
		}
	}
}
