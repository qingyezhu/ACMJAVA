package com.wangzhu.njupt;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 调整数组中奇偶顺序，并使之原来的顺序不变<br/>
 * 将奇数存放在一个数组中，将偶数存放在另一个数组之中，之后现输出奇数数组，接着输出偶数数组，即可。
 * 
 * @ClassName: Main1516
 * @Description: TODO
 * @author 王竹
 * @date 2014-10-5 下午6:30:26
 * 
 */
public class Main1516 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data.in"));
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			int n = (int) in.nval;
			int evenIndex = 0, oddIndex = 0;
			int[] evenArr = new int[n];
			int[] oddArr = new int[n];
			for (int i = 0; i < n; i++) {
				in.nextToken();
				int m = (int) in.nval;
				if ((m & 1) == 0) {
					evenArr[evenIndex++] = m;
				} else {
					oddArr[oddIndex++] = m;
				}
			}
			for (int i = 0; i < oddIndex; i++) {
				if (i > 0) {
					System.out.print(" ");
				}
				System.out.print(oddArr[i]);
			}
			if (oddIndex > 0) {
				System.out.print(" ");
			}
			for (int i = 0; i < evenIndex; i++) {
				if (i > 0) {
					System.out.print(" ");
				}
				System.out.print(evenArr[i]);
			}
			System.out.println();
		}

		/**
		 * 静态成员的调用不依赖于某个对象，直接使用类名调用
		 */
		Main1516 aa = null;
		// ((Main1516) null).print();
		aa.print();
	}

	static void print() {
		System.out.println("hello");
	}
}
