package com.wangzhu.njupt;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.StreamTokenizer;

/**
 * �������������1~100000֮�䣬��ֻ��Ҫ����100000��С�����飬�ж����Ƿ���ڼ���
 * 
 * @ClassName: Main1402
 * @Description: TODO
 * @author ����
 * @date 2014-10-3 ����5:21:31
 * 
 */
public class Main1402 {

	private static final int LEN = 1000001;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("data.in"));
		// �����Ż�
		StreamTokenizer in = new StreamTokenizer(new BufferedInputStream(
				System.in));
		// Scanner cin = new Scanner(new BufferedInputStream(System.in));
		// while (cin.hasNext()) {
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			int[] arr = new int[LEN];
			// int n = cin.nextInt();
			int n = (int) in.nval;
			int m = -1;
			for (int i = 0; i < n; i++) {
				// m = cin.nextInt();
				in.nextToken();
				m = (int) in.nval;
				arr[m]++;
			}
			StringBuilder sb = new StringBuilder();
			int c = 0, index = 0;
			for (int i = 1; i < LEN; i++) {
				if (arr[i] == 1) {
					if (index == 0) {
						sb.append(i);
						index = 1;
					} else {
						sb.append(" ").append(i);
					}
					c++;
				}
			}
			System.out.println(c);
			if (c > 0) {
				System.out.println(sb);
			}

		}
	}
}
