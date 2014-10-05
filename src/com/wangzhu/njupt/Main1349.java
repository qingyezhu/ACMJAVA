package com.wangzhu.njupt;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StreamTokenizer;

/**
 * 在已排序的数组中查找数出现的次数
 * 
 * @ClassName: Main1349
 * @Description: TODO
 * @author 王竹
 * @date 2014-10-5 下午5:02:27
 * 
 */
public class Main1349 {

	private static final int LEN = 1000001;
	private static int[] arr = new int[LEN];

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
				arr[i] = (int) in.nval;
			}
			in.nextToken();
			int t = (int) in.nval;
			for (int i = 0; i < t; i++) {
				in.nextToken();
				int m = (int) in.nval;
				int index = binarySearch(n, m);
				int count = 0;
				if (index != -1) {
					count++;
					int j = index - 1;
					while (j >= 0 && arr[j--] == m) {
						count++;
					}
					j = index + 1;
					while (j < n && arr[j++] == m) {
						count++;
					}
				}
				System.out.println(count);
			}
		}
	}

	/**
	 * 二分查找
	 * 
	 * @param len
	 * @param key
	 * @return
	 */
	private static int binarySearch(int len, int key) {
		int left = 0, right = len - 1;
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (arr[mid] > key) {
				right = mid - 1;
			} else if (arr[mid] < key) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

}
