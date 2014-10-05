package com.wangzhu.njupt;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Stack;

/**
 * 模拟栈的压入与压出
 * 
 * @ClassName: Main1366
 * @Description: TODO
 * @author 王竹
 * @date 2014-10-5 下午2:01:11
 * 
 */
public class Main1366 {

	private static final int LEN = 100010;
	private static int[] arrA = new int[LEN];
	private static int[] arrB = new int[LEN];

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data.in"));
		StreamTokenizer in = new StreamTokenizer(new BufferedInputStream(
				System.in));
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			int n = (int) in.nval;
			for (int i = 0; i < n; i++) {
				in.nextToken();
				arrA[i] = (int) in.nval;
			}
			for (int i = 0; i < n; i++) {
				in.nextToken();
				arrB[i] = (int) in.nval;
			}
			work(n);
		}
	}

	private static void work(int n) {
		// 将arrA当成是压入，将arrB当成是压出，则
		Stack<Integer> stack = new Stack<Integer>();
		int index = 0;
		for (int i = 0; i < n; i++) {
			if (!stack.isEmpty() && stack.peek().equals(arrB[i])) {
				stack.pop();
			} else {
				boolean flag = false;
				while (index < n) {
					stack.push(arrA[index]);
					if (arrA[index] == arrB[i]) {
						index++;
						flag = true;
						break;
					}
					index++;
				}
				if (!flag) {
					System.out.println("No");
					return;
				} else {
					stack.pop();
				}
			}
		}
		System.out.println("Yes");
		return;
	}
}
