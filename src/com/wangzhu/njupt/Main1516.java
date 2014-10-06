package com.wangzhu.njupt;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * ������������ż˳�򣬲�ʹ֮ԭ����˳�򲻱�<br/>
 * �����������һ�������У���ż���������һ������֮�У�֮��������������飬�������ż�����飬���ɡ�
 * 
 * @ClassName: Main1516
 * @Description: TODO
 * @author ����
 * @date 2014-10-5 ����6:30:26
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
		 * ��̬��Ա�ĵ��ò�������ĳ������ֱ��ʹ����������
		 */
		Main1516 aa = null;
		// ((Main1516) null).print();
		aa.print();
	}

	static void print() {
		System.out.println("hello");
	}
}
