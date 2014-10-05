package com.wangzhu.njupt;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Main1097 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = -1;
		while (cin.hasNext()) {
			n = cin.nextInt();
			cardGame(n);
		}
	}

	public static void cardGame(int n) {
		if (n < 1) {
			return;
		}
		Queue<Integer> queue = new ArrayBlockingQueue<Integer>(n);
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}
		while (queue.size() != 1) {
			Integer temp = queue.poll();
			System.out.print(temp + " ");
			temp = queue.poll();
			queue.add(temp);
		}
		System.out.println(queue.poll());
	}

}
