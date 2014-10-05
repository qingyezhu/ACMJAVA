package com.wangzhu.njupt;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main1371 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data.in"));
		// Scanner cin = new Scanner(new BufferedInputStream(System.in));
		StreamTokenizer in = new StreamTokenizer(new BufferedInputStream(
				System.in));
		// while (cin.hasNext()) {
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			// int n = cin.nextInt();
			// int k = cin.nextInt();
			int n = (int) in.nval;
			in.nextToken();
			int k = (int) in.nval;
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				// arr[i] = cin.nextInt();
				in.nextToken();
				arr[i] = (int) in.nval;
			}
			Arrays.sort(arr);
			StringBuilder ret = new StringBuilder();
			for (int i = 0; i < k; i++) {
				ret.append(arr[i] + " ");
			}
			System.out.println(ret.substring(0, ret.length() - 1));
			// work(arr, n, k);
		}
	}

	private static void work(int[] arr, int n, int k) {
		PriorityQueue<Integer> query = new PriorityQueue<Integer>(n + 100,
				new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						int flag = o1.compareTo(o2);
						if (flag > 0) {
							flag = -1;
						} else if (flag < 0) {
							flag = 1;
						}
						return flag;
					}
				});

		for (int i = 0; i < n; i++) {
			if (query.size() < k) {
				query.add(arr[i]);
			} else {
				if (query.peek().compareTo(arr[i]) > 0) {
					query.remove();
					query.add(arr[i]);
				}
			}
		}
		print(query);
		System.out.println();
	}

	private static void print(PriorityQueue<Integer> query) {
		if (query.isEmpty()) {
			return;
		}
		int item = query.poll();
		boolean flag = query.isEmpty();
		print(query);
		if (flag) {
			System.out.print(item);
		} else {
			System.out.print(" " + item);
		}

	}
}
